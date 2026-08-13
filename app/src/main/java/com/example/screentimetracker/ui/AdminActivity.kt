package com.example.screentimetracker.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.screentimetracker.R
import com.example.screentimetracker.data.SessionEntity
import com.example.screentimetracker.databinding.ActivityAdminBinding
import com.example.screentimetracker.service.ScreenTimeForegroundService
import com.example.screentimetracker.util.AdminPasswordDialog
import com.example.screentimetracker.util.CsvExporter
import com.example.screentimetracker.util.TimeFormatter
import com.example.screentimetracker.util.TrackingPrefs
import java.io.File

class AdminActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminBinding
    private val viewModel: AdminViewModel by viewModels()
    private lateinit var adapter: SessionHistoryAdapter

    private val handler = Handler(Looper.getMainLooper())
    private var tickerActive = false
    private var isAuthorized = false

    private val tickerRunnable = object : Runnable {
        override fun run() {
            if (tickerActive && TrackingPrefs.isTracking(this@AdminActivity)) {
                val elapsed = TrackingPrefs.getElapsedTime(this@AdminActivity)
                binding.tvActiveSessionElapsed.text = TimeFormatter.formatHms(elapsed)

                val isScreenOn = TrackingPrefs.isScreenOn(this@AdminActivity)
                binding.tvScreenState.visibility = View.VISIBLE
                binding.tvScreenState.text = if (isScreenOn) {
                    getString(R.string.screen_active)
                } else {
                    getString(R.string.screen_paused)
                }

                handler.postDelayed(this, 1000L)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        isAuthorized = intent.getBooleanExtra(EXTRA_IS_AUTHORIZED, false)

        setUpHistoryList()
        binding.btnStopSession.setOnClickListener { onStopSessionClicked() }
    }

    override fun onResume() {
        super.onResume()
        if (!isAuthorized) {
            AdminPasswordDialog.prompt(this) {
                isAuthorized = true
                refreshActiveSessionCard()
            }
        } else {
            refreshActiveSessionCard()
        }
    }

    override fun onPause() {
        super.onPause()
        tickerActive = false
        handler.removeCallbacks(tickerRunnable)
    }

    private fun setUpHistoryList() {
        adapter = SessionHistoryAdapter { session -> onReShareClicked(session) }
        binding.rvHistory.layoutManager = LinearLayoutManager(this)
        binding.rvHistory.adapter = adapter

        viewModel.allSessions.observe(this) { sessions ->
            adapter.submitList(sessions)
            binding.tvEmptyHistory.visibility = if (sessions.isEmpty()) View.VISIBLE else View.GONE
            binding.rvHistory.visibility = if (sessions.isEmpty()) View.GONE else View.VISIBLE
        }
    }

    private fun refreshActiveSessionCard() {
        if (TrackingPrefs.isTracking(this)) {
            val userName = TrackingPrefs.getUserName(this)
            binding.tvActiveSessionLabel.text = "Active session: $userName"
            binding.tvActiveSessionElapsed.visibility = View.VISIBLE
            binding.tvScreenState.visibility = View.VISIBLE
            binding.btnStopSession.isEnabled = true

            if (!tickerActive) {
                tickerActive = true
                handler.post(tickerRunnable)
            }
        } else {
            binding.tvActiveSessionLabel.text = "No active tracking session"
            binding.tvActiveSessionElapsed.visibility = View.GONE
            binding.tvScreenState.visibility = View.GONE
            binding.btnStopSession.isEnabled = false
        }
    }

    private fun onStopSessionClicked() {
        if (!TrackingPrefs.isTracking(this)) return

        tickerActive = false
        handler.removeCallbacks(tickerRunnable)

        val userName = TrackingPrefs.getUserName(this)
        val endTime = System.currentTimeMillis()
        val durationMillis = TrackingPrefs.getElapsedTime(this)
        val formattedDuration = TimeFormatter.formatHms(durationMillis)

        binding.btnStopSession.isEnabled = false

        try {
            // 1) Generate the spreadsheet.
            val exportResult = CsvExporter.exportSessionCsv(this, userName, formattedDuration, endTime)

            // 2) Log it permanently to Room -- this is the fail-safe record
            val entity = SessionEntity(
                userName = userName,
                screenTimeDuration = formattedDuration,
                durationMillis = durationMillis,
                timestamp = endTime,
                filePath = exportResult.file.absolutePath
            )
            viewModel.logSession(entity)

            // 3) Stop the foreground service + clear active-session state.
            ScreenTimeForegroundService.stop(this)
            TrackingPrefs.endSession(this)

            refreshActiveSessionCard()

            Toast.makeText(
                this,
                "Session saved: $userName — $formattedDuration",
                Toast.LENGTH_SHORT
            ).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Failed to generate report: ${e.message}", Toast.LENGTH_LONG).show()
            binding.btnStopSession.isEnabled = true
        }
    }

    private fun onReShareClicked(session: SessionEntity) {
        val file = File(session.filePath)
        if (!file.exists()) {
            Toast.makeText(
                this,
                "That report file is missing from device storage. Its database record is still kept.",
                Toast.LENGTH_LONG
            ).show()
            return
        }
        val uri = CsvExporter.uriForFile(this, file)
        startActivity(CsvExporter.buildShareIntent(this, uri))
    }

    companion object {
        const val EXTRA_IS_AUTHORIZED = "extra_is_authorized"
    }
}

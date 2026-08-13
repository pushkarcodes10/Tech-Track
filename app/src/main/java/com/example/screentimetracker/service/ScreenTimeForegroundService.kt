package com.example.screentimetracker.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.IBinder
import android.os.PowerManager
import androidx.core.app.NotificationCompat
import com.example.screentimetracker.R
import com.example.screentimetracker.ui.AdminActivity
import com.example.screentimetracker.util.TrackingPrefs

/**
 * Runs as a foreground service so a tracking session survives the
 * user minimizing the app or navigating away. Listens to screen ON/OFF
 * events to pause active screen time calculation when screen is off and
 * resume when screen is on.
 */
class ScreenTimeForegroundService : Service() {

    private var screenReceiver: BroadcastReceiver? = null

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        registerScreenStateReceiver()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val userName = intent?.getStringExtra(EXTRA_USER_NAME)
            ?: TrackingPrefs.getUserName(this)

        val powerManager = getSystemService(Context.POWER_SERVICE) as PowerManager
        val isScreenOn = powerManager.isInteractive

        startForeground(NOTIFICATION_ID, buildNotification(userName, isScreenOn))
        return START_STICKY
    }

    private fun registerScreenStateReceiver() {
        screenReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                val userName = TrackingPrefs.getUserName(this@ScreenTimeForegroundService)
                when (intent?.action) {
                    Intent.ACTION_SCREEN_OFF -> {
                        TrackingPrefs.handleScreenOff(this@ScreenTimeForegroundService)
                        updateNotification(buildNotification(userName, isScreenOn = false))
                    }
                    Intent.ACTION_SCREEN_ON, Intent.ACTION_USER_PRESENT -> {
                        TrackingPrefs.handleScreenOn(this@ScreenTimeForegroundService)
                        updateNotification(buildNotification(userName, isScreenOn = true))
                    }
                }
            }
        }

        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_SCREEN_OFF)
            addAction(Intent.ACTION_SCREEN_ON)
            addAction(Intent.ACTION_USER_PRESENT)
        }
        registerReceiver(screenReceiver, filter)
    }

    private fun buildNotification(userName: String, isScreenOn: Boolean): Notification {
        val openAdminIntent = Intent(this, AdminActivity::class.java)
        val contentIntent = PendingIntent.getActivity(
            this,
            0,
            openAdminIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val statusText = if (isScreenOn) {
            "Session active for $userName"
        } else {
            "Tracking paused (screen off)"
        }

        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Welcome to TechTrack")
            .setContentText(statusText)
            .setSmallIcon(R.drawable.ic_notification)
            .setOngoing(true)
            .setOnlyAlertOnce(true)
            .setContentIntent(contentIntent)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()
    }

    private fun updateNotification(notification: Notification) {
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(NOTIFICATION_ID, notification)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                getString(R.string.notification_channel_name),
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = getString(R.string.notification_channel_desc)
                setShowBadge(false)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        screenReceiver?.let {
            try {
                unregisterReceiver(it)
            } catch (_: Exception) {}
        }
        stopForeground(STOP_FOREGROUND_REMOVE)
    }

    companion object {
        const val EXTRA_USER_NAME = "extra_user_name"
        private const val CHANNEL_ID = "screen_time_tracking_channel"
        private const val NOTIFICATION_ID = 101

        fun start(context: Context, userName: String) {
            val intent = Intent(context, ScreenTimeForegroundService::class.java)
                .putExtra(EXTRA_USER_NAME, userName)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(intent)
            } else {
                context.startService(intent)
            }
        }

        fun stop(context: Context) {
            context.stopService(Intent(context, ScreenTimeForegroundService::class.java))
        }
    }
}

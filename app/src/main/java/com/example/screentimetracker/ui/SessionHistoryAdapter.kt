package com.example.screentimetracker.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.screentimetracker.data.SessionEntity
import com.example.screentimetracker.databinding.ItemSessionHistoryBinding
import com.example.screentimetracker.util.TimeFormatter

class SessionHistoryAdapter(
    private val onReShareClicked: (SessionEntity) -> Unit
) : ListAdapter<SessionEntity, SessionHistoryAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSessionHistoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), onReShareClicked)
    }

    class ViewHolder(private val binding: ItemSessionHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(session: SessionEntity, onReShareClicked: (SessionEntity) -> Unit) {
            binding.tvUserName.text = session.userName
            binding.tvScreenTime.text = session.screenTimeDuration
            binding.tvTimestamp.text = TimeFormatter.formatTimestamp(session.timestamp)
            binding.btnReShare.setOnClickListener { onReShareClicked(session) }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<SessionEntity>() {
            override fun areItemsTheSame(oldItem: SessionEntity, newItem: SessionEntity) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: SessionEntity, newItem: SessionEntity) =
                oldItem == newItem
        }
    }
}

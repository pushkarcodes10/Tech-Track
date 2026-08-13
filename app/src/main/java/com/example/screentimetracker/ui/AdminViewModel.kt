package com.example.screentimetracker.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.screentimetracker.data.SessionEntity
import com.example.screentimetracker.data.SessionRepository
import kotlinx.coroutines.launch

class AdminViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = SessionRepository(application)

    /** All completed sessions, newest first -- the fail-safe permanent history. */
    val allSessions: LiveData<List<SessionEntity>> = repository.allSessions.asLiveData()

    fun logSession(session: SessionEntity) {
        viewModelScope.launch {
            repository.insert(session)
        }
    }
}

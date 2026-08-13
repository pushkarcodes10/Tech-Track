package com.example.screentimetracker.util

import android.content.Context
import android.content.SharedPreferences

/**
 * Source of truth for active tracking session state and accumulated
 * screen-on time calculation (pausing when screen is off and resuming when on).
 */
object TrackingPrefs {

    private const val PREFS_NAME = "screen_time_tracking_prefs"
    private const val KEY_IS_TRACKING = "key_is_tracking"
    private const val KEY_USER_NAME = "key_user_name"
    private const val KEY_START_TIME = "key_start_time"
    private const val KEY_ACCUMULATED_TIME = "key_accumulated_time"
    private const val KEY_LAST_ACTIVE_START_TIME = "key_last_active_start_time"
    private const val KEY_IS_SCREEN_ON = "key_is_screen_on"

    private fun prefs(context: Context): SharedPreferences =
        context.applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun startSession(context: Context, userName: String, initialScreenOn: Boolean = true) {
        val now = System.currentTimeMillis()
        prefs(context).edit()
            .putBoolean(KEY_IS_TRACKING, true)
            .putString(KEY_USER_NAME, userName)
            .putLong(KEY_START_TIME, now)
            .putLong(KEY_ACCUMULATED_TIME, 0L)
            .putLong(KEY_LAST_ACTIVE_START_TIME, now)
            .putBoolean(KEY_IS_SCREEN_ON, initialScreenOn)
            .apply()
    }

    fun handleScreenOff(context: Context) {
        val p = prefs(context)
        if (!p.getBoolean(KEY_IS_TRACKING, false)) return
        val isScreenOn = p.getBoolean(KEY_IS_SCREEN_ON, true)
        if (isScreenOn) {
            val now = System.currentTimeMillis()
            val lastStart = p.getLong(KEY_LAST_ACTIVE_START_TIME, now)
            val currentAccumulated = p.getLong(KEY_ACCUMULATED_TIME, 0L)
            val additionalActive = (now - lastStart).coerceAtLeast(0L)

            p.edit()
                .putLong(KEY_ACCUMULATED_TIME, currentAccumulated + additionalActive)
                .putBoolean(KEY_IS_SCREEN_ON, false)
                .apply()
        }
    }

    fun handleScreenOn(context: Context) {
        val p = prefs(context)
        if (!p.getBoolean(KEY_IS_TRACKING, false)) return
        val isScreenOn = p.getBoolean(KEY_IS_SCREEN_ON, false)
        if (!isScreenOn) {
            val now = System.currentTimeMillis()
            p.edit()
                .putLong(KEY_LAST_ACTIVE_START_TIME, now)
                .putBoolean(KEY_IS_SCREEN_ON, true)
                .apply()
        }
    }

    fun getElapsedTime(context: Context): Long {
        val p = prefs(context)
        if (!p.getBoolean(KEY_IS_TRACKING, false)) return 0L

        val accumulated = p.getLong(KEY_ACCUMULATED_TIME, 0L)
        val isScreenOn = p.getBoolean(KEY_IS_SCREEN_ON, true)
        return if (isScreenOn) {
            val lastStart = p.getLong(KEY_LAST_ACTIVE_START_TIME, System.currentTimeMillis())
            val currentActiveSegment = (System.currentTimeMillis() - lastStart).coerceAtLeast(0L)
            accumulated + currentActiveSegment
        } else {
            accumulated
        }
    }

    fun isScreenOn(context: Context): Boolean =
        prefs(context).getBoolean(KEY_IS_SCREEN_ON, true)

    fun saveDraftUserName(context: Context, userName: String) {
        prefs(context).edit()
            .putString(KEY_USER_NAME, userName)
            .apply()
    }

    fun endSession(context: Context) {
        prefs(context).edit()
            .putBoolean(KEY_IS_TRACKING, false)
            .apply()
    }

    fun isTracking(context: Context): Boolean =
        prefs(context).getBoolean(KEY_IS_TRACKING, false)

    fun getUserName(context: Context): String =
        prefs(context).getString(KEY_USER_NAME, "") ?: ""

    fun getStartTime(context: Context): Long =
        prefs(context).getLong(KEY_START_TIME, System.currentTimeMillis())
}

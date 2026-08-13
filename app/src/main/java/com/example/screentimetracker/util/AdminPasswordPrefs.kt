package com.example.screentimetracker.util

import android.content.Context

/**
 * Manages verification of the hardcoded Admin page password.
 */
object AdminPasswordPrefs {

    const val HARDCODED_ADMIN_PASSWORD = "password420"

    fun hasPassword(context: Context): Boolean = true

    fun verifyPassword(context: Context, input: String): Boolean {
        return input == HARDCODED_ADMIN_PASSWORD
    }
}

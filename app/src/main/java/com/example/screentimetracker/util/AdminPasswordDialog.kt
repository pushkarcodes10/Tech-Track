package com.example.screentimetracker.util

import android.content.Context
import android.text.InputType
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.example.screentimetracker.R

object AdminPasswordDialog {

    fun prompt(context: Context, onSuccess: () -> Unit) {
        showEnterPasswordDialog(context, onSuccess = onSuccess)
    }

    private fun showEnterPasswordDialog(context: Context, onSuccess: () -> Unit) {
        val container = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            val padding = (20 * context.resources.displayMetrics.density).toInt()
            setPadding(padding, padding / 2, padding, 0)
        }

        val til = TextInputLayout(context, null, com.google.android.material.R.style.Widget_Material3_TextInputLayout_OutlinedBox).apply {
            hint = context.getString(R.string.admin_pass_hint)
        }
        val et = TextInputEditText(til.context).apply {
            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            maxLines = 1
        }
        til.addView(et)
        container.addView(til)

        MaterialAlertDialogBuilder(context)
            .setTitle(R.string.admin_pass_enter_title)
            .setMessage(R.string.admin_pass_enter_msg)
            .setView(container)
            .setPositiveButton(R.string.btn_submit) { dialog, _ ->
                val input = et.text?.toString()?.trim().orEmpty()
                if (AdminPasswordPrefs.verifyPassword(context, input)) {
                    dialog.dismiss()
                    onSuccess()
                } else {
                    Toast.makeText(context, R.string.admin_pass_incorrect, Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton(R.string.btn_cancel, null)
            .show()
    }
}

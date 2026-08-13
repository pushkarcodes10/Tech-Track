package com.example.screentimetracker.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.screentimetracker.databinding.ActivityRoleSelectionBinding
import com.example.screentimetracker.util.AdminPasswordDialog

/**
 * Entry point. Keeps the User and Admin roles cleanly separated as
 * two distinct pages/activities. Accessing Admin role requires password verification.
 */
class RoleSelectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRoleSelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoleSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUserRole.setOnClickListener {
            startActivity(Intent(this, UserActivity::class.java))
        }

    }
}

package com.example.expenses

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Simple validation (replace with your backend logic)
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username or password cannot be empty", Toast.LENGTH_SHORT).show()
            } else {
                // Login successful (replace with actual logic)
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

//                // Redirect to Dashboard Activity
//                val intent = Intent(this, DashboardActivity::class.java)
//                startActivity(intent)
            }

        }
    }
}
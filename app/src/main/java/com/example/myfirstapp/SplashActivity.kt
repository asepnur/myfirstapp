package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity

class SplashActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val handler = Handler()
        handler.postDelayed(Runnable {
            val notificationIntent = Intent(this, Notification::class.java)
            startActivity(notificationIntent)
            finish()
        }, 1000)
    }
}
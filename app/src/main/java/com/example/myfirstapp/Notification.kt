package com.example.myfirstapp

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity

interface AbsNotification {
    fun getToken(): String
}

interface FragmentCallback {
    fun goToHome()
    fun goToApp()
}
class Notification: AppCompatActivity(), FragmentCallback {


    private var callback: FragmentCallback? = null

    // overriding function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notification)

        setOnFragmentCallbackListener(this)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FragmentHome().apply {
                callback = this@Notification.callback
            })
            .commit()

    }

    private fun setOnFragmentCallbackListener(callback: FragmentCallback) {
        this.callback = callback
    }

    override fun goToApp() {

        supportFragmentManager.beginTransaction()
            .add(R.id.container, FragmentApp().apply {
                callback = this@Notification.callback
            })
            .commit()
    }

    override fun goToHome() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FragmentHome().apply {
                callback = this@Notification.callback
            })
            .commit()
    }
}
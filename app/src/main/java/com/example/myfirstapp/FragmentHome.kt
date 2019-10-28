package com.example.myfirstapp

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.fragment_home.*


class FragmentHome: Fragment(), AbsNotification {

    var callback: FragmentCallback? = null

    override
        fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(
                R.layout.fragment_home, container, false
            )
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonApp.setOnClickListener {
            callback?.goToApp()
        }
        buttonToken.setOnClickListener {
            textViewToken.text = getToken()
        }
    }

    override fun getToken(): String {
        FirebaseMessaging.getInstance().isAutoInitEnabled = true
        var token = FirebaseInstanceId.getInstance().getToken()
        return  token.toString()
    }
}
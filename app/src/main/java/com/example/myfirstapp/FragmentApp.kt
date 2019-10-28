package com.example.myfirstapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_app.*

class FragmentApp: Fragment() {
    var callback: FragmentCallback? = null
    override
        fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(
                R.layout.fragment_app, container, false
            )
        }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonReturn.setOnClickListener {
            callback?.goToHome()
        }
    }
}
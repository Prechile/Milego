package com.example.milegov1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class info_app : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_app)

        supportActionBar!!.hide()
    }
}

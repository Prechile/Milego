package com.example.milegov1

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView

class recharge_togocel : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recharge_togocel)

        val c1 = findViewById<CardView>(R.id.c1)
        val c2 = findViewById<CardView>(R.id.c2)
        val c3 = findViewById<CardView>(R.id.c3)
        val c4 = findViewById<CardView>(R.id.c4)
        val c5 = findViewById<CardView>(R.id.c5)
        val c6 = findViewById<CardView>(R.id.c6)
        val c7 = findViewById<CardView>(R.id.c7)
        val c8 = findViewById<CardView>(R.id.c8)

        c1.setOnClickListener(){
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }


}

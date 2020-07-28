package com.example.milegov1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView

class Ceet_services : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ceet_services)

        supportActionBar!!.setTitle("Electricité")
        if(supportActionBar != null){
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }

        val lafia = findViewById<CardView>(R.id.lafia)
        val facture = findViewById<CardView>(R.id.facture)
        val cizo1 = findViewById<CardView>(R.id.cizo1)
        val ares = findViewById<CardView>(R.id.aress)


        lafia.setOnClickListener(){
            //Inflate the dialog with custom view
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.activity_service_ceet, null)
            //AlertDialogBuilder
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Cash power")
                .setIcon(R.drawable.ceet)
            //show dialog
            mBuilder.show()


        }

        cizo1.setOnClickListener(){
            //Inflate the dialog with custom view
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.activity_solaire_cizo, null)
            //AlertDialogBuilder
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Cizo")
                .setIcon(R.drawable.ceet)
            //show dialog
            mBuilder.show()


        }

        ares.setOnClickListener(){
            //Inflate the dialog with custom view
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.activity_aresstg, null)
            //AlertDialogBuilder
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Aress TG")
                .setIcon(R.drawable.ceet)
            //show dialog
            mBuilder.show()


        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}

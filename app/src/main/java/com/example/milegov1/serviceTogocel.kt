package com.example.milegov1

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.activity_tmoney_pret.view.*

class serviceTogocel : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_togocel)

        getSupportActionBar()!!.setTitle("Services Togocel");
        // add back arrow to toolbar
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }

        val tmoney = findViewById<CardView>(R.id.tmoney)
        val recharge = findViewById<CardView>(R.id.recharge)
        val data = findViewById<CardView>(R.id.data)

        tmoney.setOnClickListener(){
            //Inflate the dialog with custom view
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.activity_tmoney_pret, null)
            //AlertDialogBuilder
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Demande d'argent Tmoney")
                .setIcon(R.drawable.tmoney)
            //show dialog
            val  mAlertDialog = mBuilder.show()
            //login button click of custom layout
            mDialogView.dialogLoginBtn.setOnClickListener {
                //dismiss dialog
                //mAlertDialog.dismiss()
                //get text from EditTexts of custom layout
                val name = mDialogView.dialogNumeroEt.text.toString()
                val email = mDialogView.dialogMontantEt.text.toString()
                val password = mDialogView.dialogMotifEt.text.toString()
                //set the input text in TextView
                Toast.makeText(this, "Pas encore disponible", Toast.LENGTH_SHORT).show()
            }
            //cancel button click of custom layout
            mDialogView.dialogCancelBtn.setOnClickListener {
                //dismiss dialog
                mAlertDialog.dismiss()
            }
        }

        recharge.setOnClickListener(){
            //Inflate the dialog with custom view
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.activity_recharge_togocel, null)
            //AlertDialogBuilder
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Choisir le montant")
                .setIcon(R.drawable.togocel)
            //show dialog
            mBuilder.show()
            
        }

        data.setOnClickListener(){
            //Inflate the dialog with custom view
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.activity_data_togocel, null)
            //AlertDialogBuilder
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Choisir votre forfait")
                .setIcon(R.drawable.togocel)
            //show dialog
            mBuilder.show()

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

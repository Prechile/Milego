package com.example.milegov1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.activity_flooz_pret.view.*
import kotlinx.android.synthetic.main.activity_tmoney_pret.view.*

class serviceMoov : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_moov)
        getSupportActionBar()!!.setTitle("Services Moov");
        // add back arrow to toolbar
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }

        val flooz = findViewById<CardView>(R.id.flooz)
        val recharge = findViewById<CardView>(R.id.Mrecharge)
        val data = findViewById<CardView>(R.id.Mdata)

        flooz.setOnClickListener(){
            //Inflate the dialog with custom view
            val fDialogView = LayoutInflater.from(this).inflate(R.layout.activity_flooz_pret, null)
            //AlertDialogBuilder
            val mBuilder = AlertDialog.Builder(this)
                .setView(fDialogView)
                .setTitle("Demande d'argent Flooz")
                .setIcon(R.drawable.flooz)
            //show dialog
            val  fAlertDialog = mBuilder.show()
            //login button click of custom layout
            fDialogView.envoyer.setOnClickListener {
                //dismiss dialog
                fAlertDialog.dismiss()
                //get text from EditTexts of custom layout
                val telephone = fDialogView.telF.text.toString()
                val montant = fDialogView.amount.text.toString()
                val motif = fDialogView.motiF.text.toString()
                //set the input text in TextView
                // mainInfoTv.setText("Name:"+ name +"\nEmail: "+ email +"\nPassword: "+ password)
            }
            //cancel button click of custom layout
            fDialogView.annuler.setOnClickListener {
                //dismiss dialog
                fAlertDialog.dismiss()
            }
        }

        recharge.setOnClickListener(){
            //Inflate the dialog with custom view
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.activity_recharge_moov, null)
            //AlertDialogBuilder
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Choisir le montant")
                .setIcon(R.drawable.flooz)
            //show dialog
            mBuilder.show()


        }

        data.setOnClickListener(){
            //Inflate the dialog with custom view
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.activity_data_moov, null)
            //AlertDialogBuilder
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Choisir le forfait")
                .setIcon(R.drawable.flooz)
            //show dialog
            mBuilder.show()


        }


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
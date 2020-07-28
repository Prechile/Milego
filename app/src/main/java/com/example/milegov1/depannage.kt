package com.example.milegov1

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_service_canal.view.*
import kotlinx.android.synthetic.main.activity_service_tde.view.*

class depannage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_depannage)
        getSupportActionBar()!!.setTitle("Dépannage milego");
        // add back arrow to toolbar
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }

        val togocel = findViewById<ImageView>(R.id.togocel)
        val moov = findViewById<ImageView>(R.id.moov)
        val canal = findViewById<ImageView>(R.id.canal)
        val ceet = findViewById<ImageView>(R.id.ceet)
        val tde = findViewById<ImageView>(R.id.tde)
        val boutique = findViewById<ImageView>(R.id.aliment)
        val pharmacie = findViewById<ImageView>(R.id.pharmacie)
        val prgDialog = ProgressDialog(this)


        togocel.setOnClickListener(){
            val i = Intent(this,serviceTogocel::class.java)
            startActivity(i)
        }

        moov.setOnClickListener(){
            val i = Intent(this,serviceMoov::class.java)
            startActivity(i)
        }

        canal.setOnClickListener(){
            //Inflate the dialog with custom view
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.activity_service_canal, null)
            //AlertDialogBuilder
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Réabonnement canal+")
                .setIcon(R.drawable.canal)
                val alert =  mBuilder.show()

            mDialogView.EnvoyerCanal.setOnClickListener(){
                prgDialog.setTitle("Traitement")
                prgDialog.setMessage("Demande de réabonnement canal+ en cours... traitement de la requête")
                prgDialog.show()
            }

            mDialogView.annulerCanal.setOnClickListener(){
                alert.dismiss()
            }


        }

        tde.setOnClickListener(){
            //Inflate the dialog with custom view
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.activity_service_tde, null)
            //AlertDialogBuilder
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Règlement de facture Tde")
                .setIcon(R.drawable.tde)
            //show dialog
           val alertTde = mBuilder.show()

            mDialogView.envoyerTde.setOnClickListener(){
                prgDialog.setTitle("Traitement")
                prgDialog.setMessage("Demande de paiement de facture canal+ en cours... traitement de la requête")
                prgDialog.show()
            }

            mDialogView.annulerTde.setOnClickListener(){
                alertTde.dismiss()
            }


        }

//        ceet.setOnClickListener(){
//            //Inflate the dialog with custom view
//            val mDialogView = LayoutInflater.from(this).inflate(R.layout.activity_service_ceet, null)
//            //AlertDialogBuilder
//            val mBuilder = AlertDialog.Builder(this)
//                .setView(mDialogView)
//                .setTitle("Cash Power")
//                .setIcon(R.drawable.ceet)
//            //show dialog
//            mBuilder.show()
//
//
//        }

        ceet.setOnClickListener(){
            val i = Intent(this,Ceet_services::class.java)
            startActivity(i)
        }

        boutique.setOnClickListener(){
            val i = Intent(this, Boutique::class.java)
            startActivity(i)
        }

        pharmacie.setOnClickListener(){
            val i = Intent(this, Pharmacie::class.java)
            startActivity(i)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

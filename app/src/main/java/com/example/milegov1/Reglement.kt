package com.example.milegov1

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.GridView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_reglement.*

class Reglement : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reglement)

        supportActionBar!!.setTitle("Reglements")

        // add back arrow to toolbar
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }
val btn = findViewById(R.id.rembourser) as Button


        btn.setOnClickListener(){

            val alert = AlertDialog.Builder(this)
            alert.create()
            alert.setTitle("Avertissement")
            alert.setMessage("Un montant total de 0.000 sera prelevé sur votre compte, voulez vous procéder au remboursement ?")
                // positive button text and action
                .setPositiveButton("Oui", DialogInterface.OnClickListener {
                        dialog, id -> finish()
                })
                // negative button text and action
                .setNegativeButton("Non", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })
                .setCancelable(false)
            alert.show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

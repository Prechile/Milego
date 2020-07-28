package com.example.milegov1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog

class simulation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.simulation)

        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.alert_dialog_with_imageview, null)
        builder.setMessage("Simulation pas encore disponible...")
        builder.setPositiveButton("OK", null)
        builder.setView(dialogLayout)
        builder.show()

        supportActionBar!!.setTitle("Simulation d'achat")
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)

            val produit = findViewById<Spinner>(R.id.produit)
            val qte = findViewById<Spinner>(R.id.qte)
            val type = findViewById<Spinner>(R.id.type)

            val produitB = findViewById<Spinner>(R.id.produitBoutique)
            val qteB = findViewById<Spinner>(R.id.qteB)
            val typeB = findViewById<Spinner>(R.id.typeB)

            //SIMULATION ACHAT MARCHES
            val ListProduit =
                arrayOf("Maïs", "Mil", "Riz", "Soja", "farine de blé", "Haricot", "Arachide")
            val adapterProduit =
                ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, ListProduit)
            produit.adapter = adapterProduit

            val Qte =
                arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
            val adapterQte =
                ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, Qte)
            qte.adapter = adapterQte

            val types =
                arrayOf("Bols", "Sacs")
            val adapterType =
                ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, types)
            type.adapter = adapterType

            //SIMULATION ACHAT BOUTIQUE
            val ListProduitBoutique =
                arrayOf("Maïs", "Mil", "Riz", "Soja", "farine de blé", "Haricot", "Arachide")
            val adapterProduitB =
                ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_dropdown_item,
                    ListProduitBoutique
                )
            produitB.adapter = adapterProduitB

            val QteBoutique =
                arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
            val adapterQteB =
                ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, QteBoutique)
            qteB.adapter = adapterQteB

            val typesBoutique =
                arrayOf("Sacs" )
            val adapterTypeB =
                ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, typesBoutique)
            typeB.adapter = adapterTypeB


        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

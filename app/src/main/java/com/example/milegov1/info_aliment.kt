package com.example.milegov1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

class info_aliment : AppCompatActivity() {
    val language = arrayOf<String>(
        "Maïs",
        "Mil",
        "soja",
        "Haricot",
        "Tomate",
        "Riz",
        "arachide",
        "Maïs",
        "soja",
        "tomate",
        "blé",
        "mil"
    )
    val description = arrayOf<String>(
        "aliment de base du peuple Togolais. Prix actuel sur le marché: 500 FCFA",
        "aliment de base du peuple Togolais. Prix actuel sur le marché: 450 FCFA",
        "aliment de base du peuple Togolais. Prix actuel sur le marché: 600 FCFA",
        "aliment de base du peuple Togolais. Prix actuel sur le marché: 300 FCFA",
        "aliment de base du peuple Togolais. Prix actuel sur le marché: 650 FCFA",
        "aliment de base du peuple Togolais. Prix actuel sur le marché: 250 FCFA",
        "aliment de base du peuple Togolais. Prix actuel sur le marché: 525 FCFA",
        "aliment de base du peuple Togolais. Prix actuel sur le marché: 925 FCFA",
        "aliment de base du peuple Togolais. Prix actuel sur le marché: 1050 FCFA",
        "aliment de base du peuple Togolais. Prix actuel sur le marché: 725 FCFA",
        "aliment de base du peuple Togolais. Prix actuel sur le marché: 925 FCFA",
        "aliment de base du peuple Togolais. Prix actuel sur le marché: 250 FCFA"

    )

    val imageId = arrayOf<Int>(
        R.drawable.mais, R.drawable.mil, R.drawable.soja,
        R.drawable.haricot, R.drawable.tomate, R.drawable.riz,
        R.drawable.arachide, R.drawable.mais, R.drawable.piment,
        R.drawable.soja, R.drawable.tomate, R.drawable.ble,
        R.drawable.mil
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_aliment)
        getSupportActionBar()!!.setTitle("informations");

        // add back arrow to toolbar
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }

        val listeClient = findViewById<ListView>(R.id.list)

        val myListAdapter = Listrow(this, language, description, imageId)
        listeClient.adapter = myListAdapter

        listeClient.setOnItemClickListener() {
                adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
            Toast.makeText(
                this,
                "Click on item at $itemAtPos its item id $itemIdAtPos",
                Toast.LENGTH_LONG
            ).show()


        }



    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

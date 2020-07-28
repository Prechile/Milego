package com.example.milegov1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.CollapsingToolbarLayout
import androidx.cardview.widget.CardView


class compte : AppCompatActivity() {

    var toolbar: Toolbar? = null
    var collapsingToolbarLayout: CollapsingToolbarLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compte)
        supportActionBar!!.setTitle("Gestion de compte")
        // add back arrow to toolbar

            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)

        val bilan = findViewById<CardView>(R.id.bilan)
        bilan.setBackgroundResource(R.drawable.card_background)
        //home navigation
        initInstancesDrawer()
    }


   fun initInstancesDrawer() {

//      var toolbar = findViewById(R.id.toolbar) as Toolbar
//       setSupportActionBar(toolbar);
        var collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout) as CollapsingToolbarLayout;
        collapsingToolbarLayout.setTitle("Nom prenom");
        collapsingToolbarLayout.setBackgroundResource(R.drawable.parallax);
    }

    //setting menu in action bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.compte, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // actions on click menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.addCompte -> {

           val intent = Intent(this, TypeCompte::class.java)
            startActivity(intent)
            }
            else -> {
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                super.onOptionsItemSelected(item)
            }


        }
        return true
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

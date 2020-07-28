package com.example.milegov1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog



class Boutique : AppCompatActivity(){

    val textCartItemCount: TextView? = null
    val mCartItemCount = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boutique)
        supportActionBar!!.title="Boutique Milego"

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.alert_dialog_with_imageview, null)
        builder.setMessage("Boutique pas encore disponible...")
        builder.setPositiveButton("OK", null)
        builder.setView(dialogLayout)
        builder.show()


    }

    //setting menu in action bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(com.example.milegov1.R.menu.panier, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // actions on click menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            com.example.milegov1.R.id.action_cart -> {

//                val intent = Intent(this, TypeCompte::class.java)
//                startActivity(intent)
            }
            else -> {
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                super.onOptionsItemSelected(item)
            }


        }
        return true
    }

    private fun setupBadge() {

        if (textCartItemCount != null) {
            if (mCartItemCount == 0) {
                if (textCartItemCount.visibility != View.GONE) {
                    textCartItemCount.visibility = View.GONE
                }
            } else {
                textCartItemCount.text = Math.min(mCartItemCount, 99).toString()
                if (textCartItemCount.visibility != View.VISIBLE) {
                    textCartItemCount.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

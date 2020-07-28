package com.example.milegov1

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.widget.Button
import android.widget.ImageView
import android.widget.ViewFlipper
import android.os.Build
import android.preference.PreferenceManager
import android.view.*
import androidx.appcompat.app.AlertDialog


lateinit var viewflipper : ViewFlipper
val image = arrayOf(R.drawable.pret_credit,R.drawable.mache_anime1)

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.statusBarColor = resources.getColor(R.color.colorPrimary);
        }

        viewflipper = findViewById(R.id.v_flipper)

        for(i in 0 until image.size) {
            flip_image(image[i])
        }

        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener{
            val intent = Intent(this, info_aliment::class.java)
            startActivity(intent)
        }



    }


    private fun flip_image(i : Int) {
        val view = ImageView(this)
        view.setBackgroundResource(i)
        viewflipper.addView(view)
        viewflipper.flipInterval = 3000
        viewflipper.isAutoStart = true
        viewflipper.setInAnimation(this , android.R.anim.slide_in_left)
        viewflipper.setOutAnimation(this , android.R.anim.slide_out_right)
    }


    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {

            }
            R.id.Compte -> {
                val intent = Intent(this, compte::class.java)
                startActivity(intent)
            }

            R.id.simulation -> {
                val intent = Intent(this, simulation::class.java)
                startActivity(intent)

//                val builder = AlertDialog.Builder(this)
//                val inflater = layoutInflater
//                val dialogLayout = inflater.inflate(R.layout.alert_dialog_with_imageview, null)
//                builder.setPositiveButton("OK", null)
//                builder.setView(dialogLayout)
//                builder.show()

            }

            R.id.login ->{
                val intent = Intent(this, Inscription::class.java)
                startActivity(intent)
            }
            R.id.depannage -> {
                    val intent = Intent(this, depannage::class.java)
                startActivity(intent)
            }
            R.id.simulation -> {

            }
            R.id.nav_share -> {
                    val share = Intent(Intent.ACTION_SEND)
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT,"Milego");
                val message= "Télécharger l'application en cliquant sur le lien \n\n";
                share.putExtra(Intent.EXTRA_TEXT,message);
                startActivity(Intent.createChooser(share,"Partager Milego"));
            }

            R.id.info -> {
                val info = Intent(this, info_app::class.java)
                startActivity(info)
            }

            R.id.logout -> {
                val alertDialog = AlertDialog.Builder(this).create()
                alertDialog.setCancelable(true)
                alertDialog.setTitle("Deconnexion")
                alertDialog.setMessage("Etes vous vraiment sûr de vous deconnecter ?")
                alertDialog.setButton(
                    AlertDialog.BUTTON_POSITIVE, "Oui"
                ) { dialogInterface, i ->
                    val preferences = PreferenceManager.getDefaultSharedPreferences(this)
                    val editor = preferences.edit()
                    //editor.putString("isConnect", "1/2");
                    editor.commit()
                    val i1 = Intent(this, Login::class.java)
                    startActivity(i1)
                    finish()
                }
                alertDialog.setButton(
                    AlertDialog.BUTTON_NEGATIVE, "Non"
                ) { dialogInterface, i -> }
                alertDialog.show()
                alertDialog.setOnCancelListener { }
            }

            R.id.credit -> {
                val i = Intent(this, Reglement::class.java)
                startActivity(i)

            }

            R.id.boutique -> {
                val intent = Intent(this, Boutique::class.java)
                startActivity(intent)
            }

        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

   override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            var box: AlertDialog.Builder? = null
            box = AlertDialog.Builder(this)
            box!!.setTitle("Quitter")
            box!!.setMessage("Voulez vous vraiment quitter Milego ?")
            box!!.setNegativeButton("Non",
                DialogInterface.OnClickListener { dialog, which -> })
            box!!.setPositiveButton("Oui",
                DialogInterface.OnClickListener { dialog, which -> finish() })
            box!!.show()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}

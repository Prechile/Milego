package com.example.milegov1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_type_compte.*


class TypeCompte : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var tabLayout: TabLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type_compte)

        //initInstancesDrawer()

        // add back arrow to toolbar
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }

        supportActionBar!!.hide()
        supportActionBar!!.setTitle("Gestion de compte")

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(Banque(), "Banque")
        adapter.addFragment(Microfinance(), "Microfinance")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

package com.example.milegov1

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.app_bar_main.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import java.lang.Thread.sleep


class splash_screen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         val  myThread =  Thread()

//        try {
//            this.getSupportActionBar()!!.show()
//        } catch (e: NullPointerException) {
//        }


        setContentView(R.layout.activity_splash_screen)

        try {
            sleep(1000)
            val intent = Intent(applicationContext, Login::class.java)
            startActivity(intent)
            finish()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        myThread.start();

    }
}

package com.example.milegov1

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.milegov1.Metier.LoginMetier
import com.example.milegov1.Models.LoginModel
import com.example.milegov1.RetrofitUrl.MilegoInterface
import com.example.milegov1.RetrofitUrl.URL
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        setContentView(R.layout.activity_login)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)


        val acti = findViewById<RelativeLayout>(R.id.global)
        val user = findViewById<EditText>(R.id.username)
        val pass = findViewById<EditText>(R.id.password)
        val connexion = findViewById<Button>(R.id.seConnecter)
        val pgb = findViewById<ProgressBar>(R.id.pb)
        val signin = findViewById<TextView>(R.id.signin)

        pgb.visibility = View.GONE

        connexion.setOnClickListener {
            if (TextUtils.isEmpty(user.text.toString()) || TextUtils.isEmpty(pass.text.toString())) {
                user.error="utilisateur invalide"
                pass.error="Mot de passe invalide"

            } else {
                pgb.visibility = View.VISIBLE
                connexion.isClickable=false

//                val retrofit = Retrofit.Builder()
//                    .baseUrl(URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//
//                val service: MilegoInterface = retrofit.create(MilegoInterface::class.java)
//                val call: Call<LoginModel> = service.Connexion(user.text.toString(), pass.text.toString())
//
//                call.enqueue(object : Callback<LoginModel> {
//                    override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
//                        pgb.visibility = View.GONE
//                        response.body()
//
//                        if(response.body()!=null) {
////                            SharedPrefManager.getInstance(applicationContext)!!
////                                .userLogin(response.body()!!.getUser());
//
//                            val home = Intent(applicationContext, MainActivity::class.java)
//                            startActivity(home)
//                            finish()
//                        } else {
//                            connexion.isClickable = true
//                            Toast.makeText(
//                                applicationContext,
//                                "erreur, veuillez réessayer", Toast.LENGTH_LONG
//                            ).show()
//
//                            val builder = AlertDialog.Builder(this@Login)
//                            val inflater = layoutInflater
//                            val dialogLayout1 = inflater.inflate(
//                                R.layout.alert_dialog_with_imageviewfalse,
//                                null
//                            )
//                            builder.setPositiveButton(
//                                "OK",
//                                DialogInterface.OnClickListener { dialog, id ->
//                                    pgb.visibility = View.GONE
//
//                                })
//                            builder.setView(dialogLayout1)
//                            builder.setCancelable(false)
//                            builder.show()
//                        }
//                    }
//
//                    override fun onFailure(call: Call<LoginModel>, t: Throwable) {
//
//                        pgb.visibility = View.GONE
//                        val dialogBuilder = AlertDialog.Builder(this@Login)
//                            //dialogBuilder.setMessage("")
//                            .setCancelable(false)
//                            .setPositiveButton(
//                                "Quitter",
//                                DialogInterface.OnClickListener { dialog, id ->
//                                    finish()
//                                })
//                            .setNegativeButton(
//                                "réessayer",
//                                DialogInterface.OnClickListener { dialog, id ->
//                                    dialog.cancel()
//                                    connexion.isClickable = true
//                                })
//
//
//                        val alert = dialogBuilder.create()
//                        alert.setTitle("Erreur")
//                        alert.setMessage("problème de connexion, veuillez réessayer")
//                        alert.show()
//
//
//                    }
//                });

                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
                finish()

            }


            signin.setOnClickListener() {
                val i = Intent(this, Inscription::class.java)
                startActivity(i)

            }

        }

    }
}
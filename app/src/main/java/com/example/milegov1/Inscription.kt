package com.example.milegov1

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Build.*
import android.os.StrictMode
import android.preference.PreferenceManager
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.milegov1.Metier.InscriptionMetier
import com.example.milegov1.Models.InscriptionModels
import com.example.milegov1.RetrofitUrl.URL
import kotlinx.android.synthetic.main.activity_inscription.*
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class Inscription : AppCompatActivity() {

    private lateinit var pDialog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscription)
        supportActionBar!!.title = "Inscription sur milego"

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }

        initDialog()

        val sexe = findViewById<Spinner>(R.id.sexe)
        val activite = findViewById<Spinner>(R.id.activite)
        val dateN = findViewById<TextView>(R.id.dateNaissance)
        val valider = findViewById<Button>(R.id.valider)
        val connexion = findViewById<TextView>(R.id.connexion)
        val addProfile = findViewById<ImageView>(R.id.addProfil)

        val nom = findViewById<EditText>(R.id.nom)
        val prenom = findViewById<EditText>(R.id.prenom)
        val numTel = findViewById<EditText>(R.id.tel)
        val numTg = findViewById<EditText>(R.id.mobileMoneyTg)
        val numMv = findViewById<EditText>(R.id.mobileMoneyMv)
        val quartier = findViewById<EditText>(R.id.quartier)
        val cni = findViewById<EditText>(R.id.cni)
        val email = findViewById<EditText>(R.id.email)
        val personne = findViewById<EditText>(R.id.personne)
        val numPersonne = findViewById<EditText>(R.id.num_personne)
        val pseudo = findViewById<EditText>(R.id.pseudo)
        val passe = findViewById<EditText>(R.id.password)

        val List1 =
            arrayOf(
                "Quelle est votre fonction",
                "Fonctionnaire",
                "Particulier",
                "Etudiant",
                "Eleve",
                "Ménagère",
                "Autre..."
            )
        val adapterActivite =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, List1)
        activite.adapter = adapterActivite

        val List =
            arrayOf("Choisir votre sexe", "Masculin", "Feminin")
        val adapterCivilite =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, List)
        sexe.adapter = adapterCivilite

        var cal = Calendar.getInstance()
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val myFormat = "dd-MM-yyyy" // mention the format you need
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                dateN.text = sdf.format(cal.time).toString()
            }

        dateN.setOnClickListener {
            DatePickerDialog(
                this, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val date: String = "" + year + "-" + month + "-" + day


        //BUTTON CLICK
        addProfile.setOnClickListener {
            //check runtime permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED
                ) {
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    //show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE);
                } else {
                    //permission already granted
                    pickImageFromGallery();
                }
            } else {
                //system OS is < Marshmallow
                pickImageFromGallery();
            }

        }

        val inscriptionMetier = InscriptionMetier()

        valider.setOnClickListener() {

            showpDialog()

            if (nom.length() != 0 && prenom.length() != 0 && date.length != 0 && sexe.selectedItem != 0 && numTel.length() != 0
                && numTg.length() != 0 && numMv.length() != 0 && quartier.length() != 0 && activite.selectedItem != 0
                && cni.length() != 0  && email.length() != 0 && personne.length() != 0 && numPersonne.length() != 0
                && pseudo.length() != 0 && passe.length() != 0)
            {


                val inscrip = InscriptionModels(
                    nom.text.toString(),
                    prenom.text.toString(),
                    date,
                    sexe.selectedItem.toString(),
                    numTel.text.toString(),
                    numTg.text.toString(),
                    numMv.text.toString(),
                    quartier.text.toString(),
                    activite.selectedItem.toString(),
                    cni.text.toString(),
                    email.text.toString(),
                    personne.text.toString(),
                    numPersonne.text.toString(),
                    pseudo.text.toString(),
                    passe.text.toString()
                    //addProfile.toString()
                )

                val respons = inscriptionMetier.envoieIns(inscrip, URL)

                if (respons != null) {


                    val toast=Toast.makeText(getApplicationContext(),"Vous êtes à présent connecté",Toast.LENGTH_SHORT);
                    toast.show();

                    val i = Intent(this, MainActivity::class.java)
                    startActivity(i)
                    finish()

                } else {

                    hidepDialog()
                    val alertDialog = AlertDialog.Builder(this).create()
                    alertDialog.setCancelable(true)
                    alertDialog.setTitle("Erreur")
                    alertDialog.setMessage("Compte déja existant, ou veuillez vérifier votre connexion")
                    alertDialog.setButton(
                        AlertDialog.BUTTON_NEGATIVE, "OK"
                    ) { dialogInterface, i -> }
                    alertDialog.show()
                    //alertDialog.setOnCancelListener { }
                }


            } else {

                    hidepDialog()
                val alertDialog = AlertDialog.Builder(this).create()
                alertDialog.setCancelable(true)
                alertDialog.setTitle("Erreur")
                alertDialog.setMessage("Il manque un ou plusieurs champs, veuillez bien renseigner les informations correct")
                alertDialog.setButton(
                    AlertDialog.BUTTON_NEGATIVE, "OK"
                ) { dialogInterface, i -> }
                alertDialog.show()
                alertDialog.setCancelable(false)

            }
        }
            connexion.setOnClickListener() {
                val i = Intent(this, Login::class.java)
                startActivity(i)
            }

            //handle result of picked image
            fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
                if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {
                    addProfile.setImageURI(data?.data)
                }
            }

        }




    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1000;
        //Permission code
        private val PERMISSION_CODE = 1001;
    }

    //handle requested permission result
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                    //permission from popup granted
                    pickImageFromGallery()
                } else {
                    //permission from popup denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    //handle result of picked image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            addProfil.setImageURI(data?.data)
        }
    }

    protected fun initDialog() {

        pDialog = ProgressDialog(this)
        pDialog.setTitle("Création de compte")
        pDialog.setMessage("Vérification des informations, veuillez patienter svpS")
        pDialog.setCancelable(false)
    }

    protected fun showpDialog() {

        if (!pDialog.isShowing) pDialog.show()
    }

    protected fun hidepDialog() {

        if (pDialog.isShowing) pDialog.dismiss()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}







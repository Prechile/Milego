package com.example.milegov1.RetrofitUrl

import com.example.milegov1.Models.InscriptionModels
import com.example.milegov1.Models.LoginModel
import retrofit2.Call
import retrofit2.http.*
import okhttp3.RequestBody
import retrofit2.http.PartMap



interface MilegoInterface {

    @POST("/Api/Connexion")
    fun envoieInscription(
        @Body apiInscription: InscriptionModels
    ): Call<Int>


    @GET("/Api/Connexion")
    fun Connexion(
        @Query("username") username: String,
        @Query("password") password: String
    ): Call<LoginModel>
}
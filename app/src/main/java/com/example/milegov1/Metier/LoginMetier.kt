package com.example.milegov1.Metier


import com.example.milegov1.Models.LoginModel
import com.example.milegov1.RetrofitUrl.MilegoInterface
import com.example.milegov1.RetrofitUrl.URL
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginMetier {

    fun envoie(username: String, password: String): LoginModel? {
        val server = MockWebServer()
        server.enqueue(MockResponse())
        try {

            server.start()
            val retrofit2 = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit2.create<MilegoInterface>(MilegoInterface::class.java)
            val response = service.Connexion(username, password).execute()

            return if (response.code() == 200 && response.body() != null) {
                LoginModel()

//                val userInfo = ApiUser(
//                    apiUser!!.id_user, apiUser.nom, apiUser.prenom, apiUser.username,
//                    apiUser.password, apiUser.code_user,apiUser.typeMaisonsListe,apiUser.typeOrganeListe)
//
//                userInfo

            } else {
                null
            }

        } catch (ex: Exception) {
            println(ex)
        }
        return null
    }

}
package com.example.milegov1.Metier

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import com.example.milegov1.Models.InscriptionModels
import com.example.milegov1.RetrofitUrl.MilegoInterface
import com.example.milegov1.RetrofitUrl.URL

class InscriptionMetier {
    fun envoieIns(inscription: InscriptionModels, url: String): InscriptionModels? {
        val server = MockWebServer()
        server.enqueue(MockResponse())
        try {

            server.start()
            val retrofit2 = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit2.create<MilegoInterface>(MilegoInterface::class.java)
            val response = service.envoieInscription(inscription).execute()

            return if (response.code() == 200 && response.body() != null ) {
                inscription

            } else if (response.body()==2 && response.errorBody()==null){
                null
            }else {
                null
            }

        } catch (ex: Exception) {
            println(ex)
        }
        return null
    }
}
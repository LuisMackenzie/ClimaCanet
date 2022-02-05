package com.example.climacanet.utils

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API {

    companion object {
        val BASE_URL = "http://api.openweathermap.org/data/2.5/"
        val BASE_ICONS = "http://openweathermap.org/img/w/"
        val BASE_ID_CANET = "3126584"
        val EXTENSION_ICONS = ".png"
        private val retrofit: Retrofit? = null
        val APIKEY = "YOUR_KEY_HERE"
        val TEST_URL = "YOUR_WEB_AND_KEY_HERE"


        /*fun getApi(): Retrofit? {
            if (retrofit == null) {
                val builder = GsonBuilder()
                builder.registerTypeAdapter(City::class.java, MyDeserializer())

                // Preparamos la libreria retrofit con la baseURL
                retrofit = Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(builder.create()))
                    .build()
            }
            return retrofit
        }*/

    }




}
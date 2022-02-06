package com.example.climacanet.utils

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API {

    companion object {
        val BASE_URL = "https://api.openweathermap.org/data/2.5/weather?"
        val BASE_ICONS = "http://openweathermap.org/img/w/"
        val BASE_ID = "id="
        val BASE_ID_CANET = "3126584"
        val BASE_ID_CANET2 = "6533989"
        val BASE_ID_BCN = "3128760"
        val BASE_ID_STPOL = "6533996"
        val BASE_ID_ARENYS = "6533985"
        val BASE_ID_CALELLA = "6533988"
        val BASE_UNITS = "units=metric"
        val BASE_LANG = "lang=es"
        val BASE_SEPARATOR = "&"
        val BASE_API_KEY = "appid=YOUR_KEY_HERE"
        val EXTENSION_ICONS = ".png"
        // private val retrofit: Retrofit? = null
        val API_KEY = "YOUR_KEY_HERE"
        val TEST_URL = "https://api.openweathermap.org/data/2.5/weather?q=Canet%20De%20Mar&appid=YOUR_KEY_HERE&units=metric&lang=es"
        val TEST_HOLDER = "YOUR_KEY_HERE"

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
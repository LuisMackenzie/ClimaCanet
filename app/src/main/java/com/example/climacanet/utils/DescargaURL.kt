package com.example.climacanet.utils

import android.os.AsyncTask
import android.os.StrictMode
import com.example.climacanet.inter.CompletedListener
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import kotlin.jvm.Throws

class DescargaURL(var listener:CompletedListener): AsyncTask<String, Void, String>() {


    override fun doInBackground(vararg p0: String): String? {
        try {
            return descargarDatos(p0[0])
        } catch (e:IOException) {
            return null
        }
    }

    override fun onPostExecute(result: String) {
        try {
            listener.downComplete(result)
        } catch (e:Exception) {

        }

        //super.onPostExecute(result)
    }

    @Throws(IOException::class)
    private fun descargarDatos(url:String):String {
        /*val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)*/
        var input: InputStream?=null
        try {
            val newUrl = URL(url)
            val conn = newUrl.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            conn.connect()
            input = conn.inputStream
            return input.bufferedReader().use {
                it.readText()
            }

        } finally {
            if (input != null) {
                input.close()
            }
        }
    }
}
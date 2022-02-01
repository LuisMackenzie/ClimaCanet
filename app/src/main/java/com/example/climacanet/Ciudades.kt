package com.example.climacanet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.climacanet.databinding.ActivityCiudadesBinding
import com.example.climacanet.utils.Network
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import kotlin.jvm.Throws

class Ciudades : AppCompatActivity() {

    private lateinit var binding:ActivityCiudadesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCiudadesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpElements()

        if (Network.haveNet(this)) {
            Toast.makeText(applicationContext, "HAY Intenet", Toast.LENGTH_LONG).show()
            // descargarDatos("http://www.google.es")
            // Log.d("INFO_DESCARGADA", "Se han descargado lo datos necesarios")
        } else {
            Toast.makeText(applicationContext, "NO HAY Intenet!!!!!!", Toast.LENGTH_LONG).show()
        }

    }

    @Throws(IOException::class)
    private fun descargarDatos(url:String):String {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        var input:InputStream?=null
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

    private fun setUpElements() {
        /*binding.btnCanet.setOnClickListener {

            Toast.makeText(applicationContext, "Se Pulso el Boton de Canet", Toast.LENGTH_LONG).show()

        }*/

        binding.btnCanet.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "Se Pulso el Boton de Canet", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(Constants.TAG, Constants.CANET_VALUE)
            startActivity(intent)
        })


        binding.btnPlaya.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(Constants.TAG, Constants.PLAYA_VALUE)
            startActivity(intent)
            Toast.makeText(applicationContext, "Se Pulso el Boton de Playa", Toast.LENGTH_LONG).show()

        }
        binding.btnBcn.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(Constants.TAG, Constants.BCN_VALUE)
            startActivity(intent)
            Toast.makeText(applicationContext, "Se Pulso el Boton de Barcelona", Toast.LENGTH_LONG).show()

        }
    }
}
package com.example.climacanet

import android.content.Intent
import android.os.AsyncTask.execute
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.climacanet.databinding.ActivityCiudadesBinding
import com.example.climacanet.inter.CompletedListener
import com.example.climacanet.models.City
import com.example.climacanet.utils.API
import com.example.climacanet.utils.DescargaURL
import com.example.climacanet.utils.Network
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import kotlin.jvm.Throws

class Ciudades:AppCompatActivity(), CompletedListener {

    private lateinit var binding:ActivityCiudadesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCiudadesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpElements()

        if (Network.haveNet(this)) {
            // Toast.makeText(applicationContext, "HAY Intenet", Toast.LENGTH_LONG).show()
            // volleyRequest(API.TEST_URL)
        } else {
            Toast.makeText(applicationContext, "NO HAY RED!!!!!!", Toast.LENGTH_LONG).show()
        }

    }

    private fun setUpElements() {

        binding.btnCanet.setOnClickListener(View.OnClickListener {
            // Toast.makeText(applicationContext, "Se Pulso el Boton de Canet", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(Constants.TAG, API.BASE_ID_CANET2)
            startActivity(intent)
        })


        binding.btnPlaya.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(Constants.TAG, API.BASE_ID_CANET)
            startActivity(intent)
            // Toast.makeText(applicationContext, "Se Pulso el Boton de Playa", Toast.LENGTH_LONG).show()

        }
        binding.btnBcn.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(Constants.TAG, API.BASE_ID_BCN)
            startActivity(intent)
            // Toast.makeText(applicationContext, "Se Pulso el Boton de Barcelona", Toast.LENGTH_LONG).show()

        }
    }

    override fun downComplete(result: String) {
        TODO("Not yet implemented")
    }
}
package com.example.climacanet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.climacanet.databinding.ActivityCiudadesBinding
import com.example.climacanet.utils.Network

class Ciudades : AppCompatActivity() {

    private lateinit var binding:ActivityCiudadesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCiudadesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpElements()

        if (Network.haveNet(this)) {
            Toast.makeText(applicationContext, "HAY Intenet", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(applicationContext, "NO HAY Intenet!!!!!!", Toast.LENGTH_LONG).show()
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
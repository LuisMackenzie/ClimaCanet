package com.example.climacanet

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.example.climacanet.Constants.TAG
import com.example.climacanet.databinding.ActivityMainBinding
import com.example.climacanet.models.City
import com.example.climacanet.models.CityOld
import com.example.climacanet.utils.API
import com.example.climacanet.utils.Network
import com.google.gson.Gson
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    private var dayNightMode by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        dayNightMode = AppCompatDelegate.getDefaultNightMode()

        val city = intent.getStringExtra(TAG)


        if (Network.haveNet(this)) {
            if (city != null) createUrl(city)
        } else {
            Toast.makeText(applicationContext, "NO HAY RED!!!!!!", Toast.LENGTH_LONG).show()
        }






    }

    private fun createUrl(city: String) {
        volleyRequest(API.BASE_URL+API.BASE_ID+
                city+
                API.BASE_SEPARATOR+
                API.BASE_API_KEY+
                API.BASE_SEPARATOR+
                API.BASE_UNITS+
                API.BASE_SEPARATOR+
                API.BASE_LANG)

    }

    // Metodo para volley
    private fun volleyRequest(url: String) {
        val queue = Volley.newRequestQueue(this)
        val request = StringRequest(Request.Method.GET, url, { response ->
            try {
                Log.d("VolleyRequest", response)
                val gson = Gson()
                val city = gson.fromJson(response, City::class.java)
                showCityData(city)
                /*with(binding) {
                    tvCity.text = city.name
                    tvDegrees.text = "${city.main.temp}º"
                    tvStatus.text = city.weather.get(0).description
                }*/
                // setLiveBackground(city.weather.get(0).description)
            } catch (e:Exception) {

            }
        }, {  })

        queue.add(request)
    }

    private fun showCityData(city:City) {
        // val timeKey = city.weather.get(0).description
        // setLiveBackground(timeKey)
        with(binding) {
            tvCity.text = city.name
            tvDegrees.text = "${city.main.temp}º"
            tvStatus.text = city.weather.get(0).description
            setLiveBackground(tvStatus.text.toString())
        }


    }

    private fun setLiveBackground(key:String) {

        when(key) {
            "nubes dispersas" -> setSunny()
            "muy nuboso" -> setCloudy()
            else -> setRainy()
        }
        /*val urlGif = "https://4.bp.blogspot.com/-0ak6SgeNvIY/VBjrWzf8HrI/AAAAAAACHZI/EVFRXN6mdQI/s1600/0618gif%2Bpaisaje.gif"
        // val uri: Uri = Uri.parse(urlGif)
        Glide.with(applicationContext)
            .asGif()
            .load(urlGif)
            .centerCrop()
            .into(binding.ivBackground)*/
    }

    private fun setSunny() {
        val urlGifSunny = "https://acegif.com/wp-content/gifs/sun-29.gif"
        val urlGifSunnyNight = "https://www.gifmaniacos.es/wp-content/uploads/2016/06/paisaje-espacial-gifmaniacos.es-2.gif"

        if (isNightModeActivated(dayNightMode)) {
            Glide.with(applicationContext)
                .asGif()
                .load(urlGifSunnyNight)
                .centerCrop()
                .into(binding.ivBackground)
        } else {
            Glide.with(applicationContext)
                .asGif()
                .load(urlGifSunny)
                .centerCrop()
                .into(binding.ivBackground)
        }


    }

    private fun setCloudy() {
        val urlGifCloudy = "https://i.pinimg.com/originals/bc/46/8d/bc468d28f5243d4b7e53227e46c5173e.gif"
        val urlGifCloudyNight = "https://www.gifmaniacos.es/wp-content/uploads/2019/06/paisaje-gifmaniacos.es-33.gif"
        if (isNightModeActivated(dayNightMode)) {
            Glide.with(applicationContext)
                .asGif()
                .load(urlGifCloudyNight)
                .centerCrop()
                .into(binding.ivBackground)
        } else {
            Glide.with(applicationContext)
                .asGif()
                .load(urlGifCloudy)
                .centerCrop()
                .into(binding.ivBackground)
        }
    }

    private fun setRainy() {
        val urlGifRainy = "https://i.pinimg.com/originals/96/d1/79/96d17958eae5ac2f159f2314a34f3009.gif"
        val urlGifRainyNight = "https://i.pinimg.com/originals/11/39/a6/1139a669dd3a5aa19c9e512ff2611f2d.gif"
        if (isNightModeActivated(dayNightMode)) {
            Glide.with(applicationContext)
                .asGif()
                .load(urlGifRainyNight)
                .centerCrop()
                .into(binding.ivBackground)
        } else {
            Glide.with(applicationContext)
                .asGif()
                .load(urlGifRainy)
                .centerCrop()
                .into(binding.ivBackground)
        }
    }

    private fun setCloudyRay() {
        val urlGifRay = "https://i.pinimg.com/originals/b2/49/c6/b249c6da2a374293b2baaf8de1643bda.gif"
        Glide.with(applicationContext)
            .asGif()
            .load(urlGifRay)
            .centerCrop()
            .into(binding.ivBackground)
    }

    private fun isNightModeActivated(mode: Int): Boolean {

        return mode == AppCompatDelegate.MODE_NIGHT_YES

    }
}
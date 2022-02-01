package com.example.climacanet

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.bumptech.glide.Glide
import com.example.climacanet.Constants.TAG
import com.example.climacanet.databinding.ActivityMainBinding
import com.example.climacanet.models.City
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var dayNightMode by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setLiveBackground()
        // AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        // dayNightMode = AppCompatDelegate.getDefaultNightMode()
        // setCloudy()
        val city = intent.getStringExtra(TAG)
        if (city != null) {
            cityData(city)
        }





    }

    private fun cityData(city:String) {
        val canetCity = City("Canet de Mar", 9, "Soleado")
        val canetPlaya = City("Playa de Canet", 12, "Soleado")
        val bcnCity = City("Barcelona", 45, "El Infierno")
        when(city) {
            Constants.CANET_VALUE -> {
                binding.tvCity.text = canetCity.name
                binding.tvDegrees.text = "${canetCity.degrees}º"
                binding.tvStatus.text = canetCity.status
            }
            Constants.PLAYA_VALUE -> {
                binding.tvCity.text = canetPlaya.name
                binding.tvDegrees.text = "${canetPlaya.degrees}º"
                binding.tvStatus.text = canetPlaya.status
            }
            Constants.BCN_VALUE -> {
                binding.tvCity.text = bcnCity.name
                binding.tvDegrees.text = "${bcnCity.degrees}º"
                binding.tvStatus.text = bcnCity.status
            }
            else -> Toast.makeText(this,"No se encontro la ciudad", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setLiveBackground() {
        val urlGif = "https://4.bp.blogspot.com/-0ak6SgeNvIY/VBjrWzf8HrI/AAAAAAACHZI/EVFRXN6mdQI/s1600/0618gif%2Bpaisaje.gif"
        // val uri: Uri = Uri.parse(urlGif)
        Glide.with(applicationContext)
            .asGif()
            .load(urlGif)
            .centerCrop()
            .into(binding.ivBackground)
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
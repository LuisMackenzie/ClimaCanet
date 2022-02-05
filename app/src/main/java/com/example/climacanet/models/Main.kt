package com.example.climacanet.models

data class Main(
    val feels_like: Double,
    val grnd_level: Int,
    val humidity: Int,
    val pressure: Int,
    val sea_level: Int,
    val temp: Double=0.0,
    val temp_max: Double,
    val temp_min: Double
)
package com.example.klarnaassignmentbyparisa.data.remote

import com.example.klarnaassignmentbyparisa.data.remote.WeatherDataDto
import com.squareup.moshi.Json

data class WeatherDto(
    @field:Json(name = "hourly")
    val weatherData: WeatherDataDto
)

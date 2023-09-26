package com.example.klarnaassignmentbyparisa.peresentation

import com.example.klarnaassignmentbyparisa.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

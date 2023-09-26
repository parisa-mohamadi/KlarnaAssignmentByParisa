package com.example.klarnaassignmentbyparisa.domain.weather

import com.example.klarnaassignmentbyparisa.domain.weather.WeatherData

data class WeatherInfo(
    val weatherDataPerDay: Map<Int, List<WeatherData>>,
    val currentWeatherData: WeatherData?
)

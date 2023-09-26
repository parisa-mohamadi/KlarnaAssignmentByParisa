package com.example.klarnaassignmentbyparisa.domain.repository

import com.example.klarnaassignmentbyparisa.domain.util.Resource
import com.example.klarnaassignmentbyparisa.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}
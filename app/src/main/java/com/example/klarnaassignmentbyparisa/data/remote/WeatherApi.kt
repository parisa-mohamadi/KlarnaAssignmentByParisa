package com.example.klarnaassignmentbyparisa.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * WeatherApi is an interface that defines the contract for retrieving weather data
 * from an external API.
 */

interface WeatherApi {

    @GET("v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl")
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ): WeatherDto
}
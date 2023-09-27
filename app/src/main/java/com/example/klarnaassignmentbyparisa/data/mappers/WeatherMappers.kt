package com.example.klarnaassignmentbyparisa.data.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.klarnaassignmentbyparisa.data.remote.WeatherDataDto
import com.example.klarnaassignmentbyparisa.data.remote.WeatherDto
import com.example.klarnaassignmentbyparisa.domain.weather.WeatherData
import com.example.klarnaassignmentbyparisa.domain.weather.WeatherInfo
import com.example.klarnaassignmentbyparisa.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Represents indexed weather data containing an index and associated WeatherData object.
 * @param index The index indicating the position in a list.
 * @param data The WeatherData associated with the index.
 * Converts a WeatherDataDto into a map of WeatherData objects grouped by day.
 * @return A map with day indices as keys and lists of WeatherData as values.
 * Converts a WeatherDto into a WeatherInfo object containing weather data and current conditions.
 * @return A WeatherInfo object with weather data per day and current weather information.
 */

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(weatherCode)
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map { it.data }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if(now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }
    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}
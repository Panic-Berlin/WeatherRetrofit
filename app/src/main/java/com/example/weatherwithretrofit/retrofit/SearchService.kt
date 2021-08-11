package com.example.weatherwithretrofit.retrofit

import com.example.weatherwithretrofit.model.Temp
import com.example.weatherwithretrofit.model.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val KEY = "O6OsWZoZuJ8oqxQ6vNZm6ykTCAYV6WHT"

interface SearchService {
    @GET("locations/v1/cities/autocomplete?language=ru-ru")
    abstract fun getSearchList(
        @Query("apikey") key: String,
        @Query("q") q: String
    ): Call<MutableList<Weather>>

    @GET("locations/v1/topcities/50?language=ru-ru")
    fun getWeatherList(
        @Query("apikey") key: String = KEY
    ): Call<MutableList<Weather>>

    @GET("forecasts/v1/daily/1day/{key}?language=ru-ru")
    fun getDaily(
        @Path("key") cityKey: String,
        @Query("apikey") key: String = KEY
    ): Call<Temp>

    @GET("forecasts/v1/daily/5day/{key}?language=ru-ru")
    fun getFiveDay(
        @Path("key") cityKey: String,
        @Query("apikey") key: String = KEY
    ): Call<Temp>
}
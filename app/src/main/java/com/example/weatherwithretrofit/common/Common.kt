package com.example.weatherwithretrofit.common

import com.example.weatherwithretrofit.retrofit.RetrofitClient
import com.example.weatherwithretrofit.retrofit.SearchService

object Common {
    private const val BASE_URL = "https://dataservice.accuweather.com/"
    val topCityService : SearchService
        get() = RetrofitClient.getClient(BASE_URL).create(SearchService::class.java)
}
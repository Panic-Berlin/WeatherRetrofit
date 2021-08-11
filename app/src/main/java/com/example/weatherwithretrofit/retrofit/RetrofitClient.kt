package com.example.weatherwithretrofit.retrofit

import android.util.Log
import com.squareup.picasso.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getClient(baseUrl : String): Retrofit{
        val okHttp = OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG){
                val logger = HttpLoggingInterceptor{
                    Log.d("HTTP", it)
                }
                logger.level = HttpLoggingInterceptor.Level.BODY
                addInterceptor(logger)
            }
        }
            .build()
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttp)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}
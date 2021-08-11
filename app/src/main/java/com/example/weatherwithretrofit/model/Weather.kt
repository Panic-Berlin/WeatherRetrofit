package com.example.weatherwithretrofit.model

import java.io.Serializable

data class Weather(
    val Key: String,
    val LocalizedName: String,
    val Country: Country,
    val AdministrativeArea: AdministrativeArea,
):Serializable


class Country(
    val LocalizedName: String,
)

class AdministrativeArea(
    val LocalizedName: String
)

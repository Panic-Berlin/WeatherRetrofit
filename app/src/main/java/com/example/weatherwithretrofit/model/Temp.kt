package com.example.weatherwithretrofit.model

data class Temp(val Headline: Headline, var DailyForecasts: List<DailyForecasts>)
class Headline(val Text: String)
class DailyForecasts(val Temperature: Temperature, val Day: Day, val Night: Night)
class Temperature(val Minimum: Minimum, val Maximum: Maximum)
class Minimum(val Value: Int, val Unit: String) {
    val valueInC: Int
        get() = (Value - 32) * 5/9
}

class Maximum(val Value: Int, val Unit: String){
    val valueInC: Int
        get() = (Value - 32) * 5/9
}
class Day(val IconPhrase: String)
class Night(val IconPhrase: String)
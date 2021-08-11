package com.example.weatherwithretrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.weatherwithretrofit.R
import com.example.weatherwithretrofit.databinding.Top50ItemBinding
import com.example.weatherwithretrofit.model.Weather

class WeatherAdapter(
    private val weather: MutableList<Weather>,
    private val onCityClick: (weather: Weather) -> Unit
    ): RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForWeather = layoutInflater.inflate(R.layout.top50_item, parent, false)
        return WeatherViewHolder(cellForWeather)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(weather[position])
        holder.itemView.setOnClickListener {
            onCityClick.invoke(weather[position])
        }
    }

    override fun getItemCount(): Int {
        return weather.count()
    }

    class WeatherViewHolder(view : View): RecyclerView.ViewHolder(view){
        private val viewBinding: Top50ItemBinding by viewBinding(Top50ItemBinding::bind)

        fun bind(weather: Weather){
            viewBinding.city.text = weather.LocalizedName
            viewBinding.country.text = weather.Country.LocalizedName
            viewBinding.region.text = weather.AdministrativeArea.LocalizedName

        }
    }
}
package com.example.weatherwithretrofit.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.weatherwithretrofit.R
import com.example.weatherwithretrofit.databinding.FiveDaysItemBinding
import com.example.weatherwithretrofit.model.DailyForecasts
import com.example.weatherwithretrofit.model.Temp

class DailyAdapter(val temperature: Temp): RecyclerView.Adapter<DailyAdapter.DailyViewHolder>() {

    class DailyViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val viewBinding: FiveDaysItemBinding by viewBinding(FiveDaysItemBinding::bind)
        @SuppressLint("SetTextI18n")
        fun bind(temperature: DailyForecasts){
            viewBinding.dayMax.text = temperature.Temperature.Maximum.valueInC.toString() + "°"
            viewBinding.dayMin.text = temperature.Temperature.Minimum.valueInC.toString() + "°"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForDay = layoutInflater.inflate(R.layout.five_days_item, parent, false)
        return DailyViewHolder(cellForDay)
    }

    override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {
        holder.bind(temperature.DailyForecasts[position])
    }

    override fun getItemCount(): Int {
        return temperature.DailyForecasts.count()
    }
}
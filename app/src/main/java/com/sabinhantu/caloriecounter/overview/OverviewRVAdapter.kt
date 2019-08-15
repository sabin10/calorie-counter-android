package com.sabinhantu.caloriecounter.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sabinhantu.caloriecounter.CalorieCounterApplication
import com.sabinhantu.caloriecounter.R
import com.sabinhantu.caloriecounter.database.FoodModel
import com.sabinhantu.caloriecounter.databinding.ItemFoodOverviewBinding
import com.sabinhantu.caloriecounter.foodNameToShortString

class OverviewRVAdapter : RecyclerView.Adapter<OverviewRVAdapter.ViewHolder>()  {

    var data = listOf<FoodModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewRVAdapter.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: OverviewRVAdapter.ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }


    class ViewHolder private constructor(val binding: ItemFoodOverviewBinding)
        : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemFoodOverviewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(item: FoodModel) {
            binding.tvItemOverviewName.text = item.name?.foodNameToShortString()
            binding.tvItemOverviewGrams.text = CalorieCounterApplication.instance.getString(R.string.format_grams, item.grams)
            binding.tvItemOverviewKcal.text = CalorieCounterApplication.instance.getString(R.string.format_total_kcal, item.kcal)
            binding.tvItemOverviewCarbs.text = CalorieCounterApplication.instance.getString(R.string.format_grams, item.carbs)
            binding.tvItemOverviewProteins.text = CalorieCounterApplication.instance.getString(R.string.format_grams, item.proteins)
            binding.tvItemOverviewFats.text = CalorieCounterApplication.instance.getString(R.string.format_grams, item.fats)
        }

    }

}
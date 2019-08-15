package com.sabinhantu.caloriecounter.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sabinhantu.caloriecounter.CalorieCounterApplication
import com.sabinhantu.caloriecounter.R
import com.sabinhantu.caloriecounter.database.FoodModel
import com.sabinhantu.caloriecounter.databinding.ItemFoodOverviewBinding
import com.sabinhantu.caloriecounter.foodNameToShortString

class OverviewRVAdapter(val onBtnDeleteListener: OnBtnDeleteListener) : RecyclerView.Adapter<OverviewRVAdapter.ViewHolder>()  {

    var data = listOf<FoodModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewRVAdapter.ViewHolder {
        return ViewHolder.from(parent, onBtnDeleteListener)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: OverviewRVAdapter.ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
        holder.click(item)


    }


    class ViewHolder constructor(val binding: ItemFoodOverviewBinding, val onBtnDeleteListener: OnBtnDeleteListener)
        : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup, onBtnDeleteListener: OnBtnDeleteListener): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemFoodOverviewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding, onBtnDeleteListener)
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

        fun click(item: FoodModel) {
            binding.btnDeleteItemOverview.setOnClickListener {
                onBtnDeleteListener.onClick(item)
            }
        }


    }


    class OnBtnDeleteListener(val clickListener: (foodModel: FoodModel) -> Unit) {
        fun onClick(foodModel: FoodModel) = clickListener(foodModel)
    }

}
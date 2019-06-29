package com.sabinhantu.caloriecounter.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sabinhantu.caloriecounter.convertFoodKcalDoubletoString
import com.sabinhantu.caloriecounter.convertFoodNameToShortString
import com.sabinhantu.caloriecounter.databinding.ListItemSearchBinding
import com.sabinhantu.caloriecounter.network.model.Food

class SearchItemAdapter : RecyclerView.Adapter<SearchItemAdapter.ViewHolder>() {

    var data = listOf<Food>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchItemAdapter.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: SearchItemAdapter.ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    class ViewHolder private constructor(val binding: ListItemSearchBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
//                val view = layoutInflater
//                    .inflate(R.layout.list_item_search, parent, false)
                val binding = ListItemSearchBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }

        fun bind(item: Food) {
//            val res = binding.context.resources

            binding.searchItemName.text = convertFoodNameToShortString(item.label)
            binding.searchItemKcal.text = convertFoodKcalDoubletoString(item.nutrients.kcal)
        }

    }

}
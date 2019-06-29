package com.sabinhantu.caloriecounter.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sabinhantu.caloriecounter.R
import com.sabinhantu.caloriecounter.convertFoodKcalDoubletoString
import com.sabinhantu.caloriecounter.convertFoodNameToShortString
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

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val foodName: TextView = itemView.findViewById(R.id.search_item_name)
        val foodKcal: TextView = itemView.findViewById(R.id.search_item_kcal)

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.list_item_search, parent, false)

                return ViewHolder(view)
            }
        }

        fun bind(item: Food) {
//            val res = itemView.context.resources

            foodName.text = convertFoodNameToShortString(item.label)
            foodKcal.text = convertFoodKcalDoubletoString(item.nutrients.kcal)
        }

    }

}
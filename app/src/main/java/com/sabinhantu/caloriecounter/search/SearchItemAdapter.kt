package com.sabinhantu.caloriecounter.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sabinhantu.caloriecounter.databinding.ListItemSearchBinding
import com.sabinhantu.caloriecounter.foodNameToShortString
import com.sabinhantu.caloriecounter.network.model.Food
import com.sabinhantu.caloriecounter.toKcalString

class SearchItemAdapter(val onClickListener: OnClickListener) : RecyclerView.Adapter<SearchItemAdapter.ViewHolder>() {

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
        holder.itemView.setOnClickListener {
            onClickListener.onClick(item)
        }
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

//            binding.searchItemName.text = convertFoodNameToShortString(item.label)
            binding.searchItemName.text = item.label.foodNameToShortString()
//            binding.searchItemKcal.text = convertFoodKcalDoubletoString(item.nutrients.kcal)
            binding.searchItemKcal.text = item.nutrients.kcal.toKcalString()
        }

    }

    /**
     * Custom listener that handles clicks on [RecyclerView] items.  Passes the [Food]
     * associated with the current item to the [onClick] function.
     * It will be called in onBindViewHolder
     * @param clickListener lambda that will be called with the current [Food]
     */
    class OnClickListener(val clickListener: (food: Food) -> Unit) {
        fun onClick(food: Food) = clickListener(food)
    }


}
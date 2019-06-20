package com.sabinhantu.caloriecounter.Search


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.sabinhantu.caloriecounter.R


class SearchFragment : Fragment() {

    private lateinit var toAddFoodButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        toAddFoodButton = view.findViewById(R.id.btn_search_to_add_food)
        toAddFoodButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_searchFragment_to_addFoodFragment)
        )

        return view
    }


}

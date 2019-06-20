package com.sabinhantu.caloriecounter.DayOverview


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.sabinhantu.caloriecounter.R

class DayOverviewFragment : Fragment() {

    private lateinit var toSearchButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_day_overview, container, false)

        toSearchButton = view.findViewById(R.id.btn_overview_to_search)
        toSearchButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_dayOverviewFragment_to_searchFragment)
        )

        return view
    }


}

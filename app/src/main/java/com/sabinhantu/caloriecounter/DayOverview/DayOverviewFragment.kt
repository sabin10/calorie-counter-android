package com.sabinhantu.caloriecounter.DayOverview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.sabinhantu.caloriecounter.R
import com.sabinhantu.caloriecounter.databinding.FragmentDayOverviewBinding

class DayOverviewFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentDayOverviewBinding>(inflater, R.layout.fragment_day_overview, container, false)

        binding.btnOverviewToSearch.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_dayOverviewFragment_to_searchFragment)
        )


        return binding.root
    }


}

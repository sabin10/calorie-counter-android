package com.sabinhantu.caloriecounter.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.sabinhantu.caloriecounter.R
import com.sabinhantu.caloriecounter.database.FoodDatabase
import com.sabinhantu.caloriecounter.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentOverviewBinding>(inflater, R.layout.fragment_overview, container, false)
        binding.lifecycleOwner = this

        binding.btnOverviewToSearch.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_overviewFragment_to_searchFragment)
        )

        val application = requireNotNull(activity).application
        val dataSource = FoodDatabase.getInstance(application).foodDatabaseDao

        val viewModelFactory = OverviewViewModelFactory(dataSource, application)
        binding.viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(OverviewViewModel::class.java)

        return binding.root
    }

}

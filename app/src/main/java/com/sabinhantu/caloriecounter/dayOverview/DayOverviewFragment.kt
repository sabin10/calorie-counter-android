package com.sabinhantu.caloriecounter.dayOverview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.sabinhantu.caloriecounter.R
import com.sabinhantu.caloriecounter.databinding.FragmentDayOverviewBinding

class DayOverviewFragment : Fragment() {

    /**
     * Lazily initialize our [DayOverviewViewModel].
     */
    private val viewModel: DayOverviewViewModel by lazy {
        ViewModelProviders.of(this).get(DayOverviewViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentDayOverviewBinding>(inflater, R.layout.fragment_day_overview, container, false)

        binding.btnOverviewToSearch.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_dayOverviewFragment_to_searchFragment)
        )

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.setLifecycleOwner(this)

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel


        return binding.root
    }


}

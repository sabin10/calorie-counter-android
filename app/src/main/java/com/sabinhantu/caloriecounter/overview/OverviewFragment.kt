package com.sabinhantu.caloriecounter.overview

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.sabinhantu.caloriecounter.MainActivity
import com.sabinhantu.caloriecounter.R
import com.sabinhantu.caloriecounter.database.FoodDatabase
import com.sabinhantu.caloriecounter.databinding.FragmentOverviewBinding
import com.sabinhantu.caloriecounter.getCurrentDayString

class OverviewFragment : Fragment() {

    private lateinit var listenerCurrent: OnOverviewCurrent
    private lateinit var viewModel: OverviewViewModel
    private lateinit var binding: FragmentOverviewBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentOverviewBinding>(inflater, R.layout.fragment_overview, container, false)
        binding.lifecycleOwner = this

        binding.btnOverviewToSearch.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_overviewFragment_to_searchFragment)
        )

        val application = requireNotNull(activity).application
        val dataSource = FoodDatabase.getInstance(application).foodDatabaseDao

        val viewModelFactory = OverviewViewModelFactory(dataSource,application)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(OverviewViewModel::class.java)


        binding.viewModel = viewModel

        val adapter = OverviewRVAdapter(OverviewRVAdapter.OnBtnDeleteListener {
            viewModel.onDeleteChoosedFood(it)
        })

        binding.rvOverview.adapter = adapter

        viewModel.foods.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })


        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val activity = activity as MainActivity
        val selectedDate = activity.selectedDate
        if (selectedDate != null) {
            viewModel.setDateSelected(selectedDate)
            if (selectedDate != getCurrentDayString()) {
                // Hide search btn
                binding.btnOverviewToSearch.visibility = View.INVISIBLE
            } else {
                binding.btnOverviewToSearch.visibility = View.VISIBLE
            }

        }

        listenerCurrent.onOverviewCurrent(true)
    }

    override fun onStop() {
        super.onStop()
        listenerCurrent.onOverviewCurrent(false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnOverviewCurrent) {
            listenerCurrent = context
        } else {
            throw ClassCastException(
                context.toString() + " must implement OnOverviewCurrent.")
        }
    }

    interface OnOverviewCurrent {
        fun onOverviewCurrent(isCurrent: Boolean)
    }

}

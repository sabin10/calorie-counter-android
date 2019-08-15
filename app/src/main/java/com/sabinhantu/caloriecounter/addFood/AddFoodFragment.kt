package com.sabinhantu.caloriecounter.addFood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.sabinhantu.caloriecounter.R
import com.sabinhantu.caloriecounter.database.FoodDatabase
import com.sabinhantu.caloriecounter.databinding.FragmentAddFoodBinding

class AddFoodFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val application = requireNotNull(activity).application

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentAddFoodBinding>(inflater, R.layout.fragment_add_food, container, false)
        binding.lifecycleOwner = this

        val food = AddFoodFragmentArgs.fromBundle(arguments!!).selectedFood
        val dataSource = FoodDatabase.getInstance(application).foodDatabaseDao

        val viewModelFactory = AddFoodViewModelFactory(food, dataSource, application)
        val viewModel = ViewModelProviders.of(this,
            viewModelFactory).get(AddFoodViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.navigateToOverview.observe(this, Observer {
            if (it) {
                this.findNavController().navigate(AddFoodFragmentDirections.actionAddFoodFragmentToOverviewFragment())
//                Navigation.createNavigateOnClickListener(R.id.action_addFoodFragment_to_overviewFragment)
//                viewModel.onNavigateToOverviewCompleted()
            }
        })




        return binding.root
    }


}

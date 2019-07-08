package com.sabinhantu.caloriecounter.addFood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.sabinhantu.caloriecounter.R
import com.sabinhantu.caloriecounter.databinding.FragmentAddFoodBinding

class AddFoodFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val application = requireNotNull(activity).application

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentAddFoodBinding>(inflater, R.layout.fragment_add_food, container, false)
        binding.setLifecycleOwner(this)

        val food = AddFoodFragmentArgs.fromBundle(arguments!!).selectedFood

        val viewModelFactory = AddFoodViewModelFactory(food, application)
        binding.viewModel = ViewModelProviders.of(this,
            viewModelFactory).get(AddFoodViewModel::class.java)


        return binding.root
    }


}

package com.sabinhantu.caloriecounter.AddFood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.sabinhantu.caloriecounter.R
import com.sabinhantu.caloriecounter.databinding.FragmentAddFoodBinding

class AddFoodFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentAddFoodBinding>(inflater, R.layout.fragment_add_food, container, false)

        return binding.root
    }


}

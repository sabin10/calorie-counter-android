package com.sabinhantu.caloriecounter.search


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.sabinhantu.caloriecounter.R
import com.sabinhantu.caloriecounter.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentSearchBinding>(inflater, R.layout.fragment_search, container, false)

        binding.btnSearchToAddFood.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_searchFragment_to_addFoodFragment)
        )

        return binding.root
    }


}

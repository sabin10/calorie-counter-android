package com.sabinhantu.caloriecounter.search


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
import com.sabinhantu.caloriecounter.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    private val viewModel: SearchViewModel by lazy {
        ViewModelProviders.of(this).get(SearchViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentSearchBinding>(inflater, R.layout.fragment_search, container, false)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the viewModel
        binding.viewModel = viewModel

        // Set the adapter with clickHandler lambad that tells the viewModel when a item is clicked
        val adapter = SearchItemAdapter(SearchItemAdapter.OnClickListener {
            viewModel.displayAddFood(it)
        })
        binding.searchRecyclerview.adapter = adapter

        viewModel.searchListFood.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

        // Observe navigateToSelectedFood data and navigate if it isn't null
        // After navigate, set the selectedFood to null so that ViewModel is rdy for another navigation
        viewModel.navigateToSelectedFood.observe(this, Observer {
            if (it != null) {
                this.findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToAddFoodFragment(it))
                // tell the viewModel we've mafe the navigate call
                viewModel.displayAddFoodIsComplete()
            }
        })

        // ProgressBar's Visibility
        viewModel.searchInProgress.observe(this, Observer {
            if (it == false) {
                binding.searchProgressbar.visibility = View.INVISIBLE
            } else {
                binding.searchProgressbar.visibility = View.VISIBLE
            }
        })


        return binding.root
    }



}

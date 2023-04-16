package com.udacity.shoestore.shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.databinding.ShoeDetailFragmentBindingImpl
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.shoe.models.Shoe

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: ShoeDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ShoeDetailFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            cancelButton.setOnClickListener { navigateToShoeListScreen(it) }
            saveButton.setOnClickListener {
                // TODO: add data
                navigateToShoeListScreen(it)
            }
        }
    }

    private fun addShoe(name: String, size: Double, company: String, description: String) {
        val shoe = Shoe(name, size, company, description)

    }

    private fun navigateToShoeListScreen(view: View) {
        view.findNavController().navigate(
            ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
        )
    }
}
package com.udacity.shoestore.shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: ShoeDetailFragmentBinding

    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ShoeDetailFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]

        viewModel.resetShoe()

        with(binding) {
            shoeViewModel = viewModel
            cancelButton.setOnClickListener { it.findNavController().navigateUp() }
            saveButton.setOnClickListener {
                viewModel.addShoe()
                it.findNavController().navigateUp()
            }
        }
    }
}
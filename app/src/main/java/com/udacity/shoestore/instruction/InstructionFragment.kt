package com.udacity.shoestore.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.InstructionFragmentBinding

class InstructionFragment : Fragment() {

    private lateinit var binding: InstructionFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = InstructionFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.instructionGetStartedButton.setOnClickListener { navigateToShoeListScreen(it) }
    }

    private fun navigateToShoeListScreen(view: View) {
        view.findNavController().navigate(
            InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment()
        )
    }
}
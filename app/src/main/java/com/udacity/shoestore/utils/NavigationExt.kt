package com.udacity.shoestore.utils

import android.view.View
import androidx.navigation.findNavController
import com.udacity.shoestore.instruction.InstructionFragmentDirections
import com.udacity.shoestore.login.LoginFragmentDirections
import com.udacity.shoestore.shoe.ShoeListFragmentDirections
import com.udacity.shoestore.welcome.WelcomeFragmentDirections

internal fun View.navigateToInstructionScreen() = findNavController().navigate(
    WelcomeFragmentDirections.actionWelcomeDestinationToInstructionFragment()
)

internal fun View.navigateToShoeDetailScreen() = findNavController().navigate(
    ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
)

internal fun View.navigateToShoeListScreen() = findNavController().navigate(
    InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment()
)

internal fun View.navigateToWelcomeScreen() = findNavController().navigate(
    LoginFragmentDirections.actionLoginDestinationToWelcomeDestination()
)
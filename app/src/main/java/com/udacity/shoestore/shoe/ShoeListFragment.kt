package com.udacity.shoestore.shoe

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeItemLayoutBinding
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.shoe.models.Shoe
import com.udacity.shoestore.utils.navigateToShoeDetailScreen
import java.util.*

class ShoeListFragment : Fragment() {

    private lateinit var binding: ShoeListFragmentBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ShoeListFragmentBinding.inflate(inflater)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.shoeItemDetailButton.setOnClickListener { it.navigateToShoeDetailScreen() }

        viewModel.shoes.observe(viewLifecycleOwner) { addShoesToView(it) }
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> onLogout()
        }
        return super.onOptionsItemSelected(item)
    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shoe_list_menu, menu)
    }

    private fun onLogout() {
        viewModel.resetShoeList()
        requireView().findNavController().popBackStack(R.id.login_destination, false)
    }

    private fun addShoesToView(shoes: List<Shoe>) {
        shoes.forEach { shoe ->
            addShoeToView(shoe)
        }
    }

    private fun addShoeToView(shoe: Shoe) {
        val shoeItemBinding = ShoeItemLayoutBinding.inflate(layoutInflater)

        shoeItemBinding.shoeItemName.text = shoe.name
        shoeItemBinding.shoeItemCompany.text = shoe.company
        shoeItemBinding.shoeItemSize.text = shoe.size.toString()
        shoeItemBinding.shoeItemDescription.text = shoe.description

        binding.shoeItemListLayout.addView(shoeItemBinding.root)
    }
}
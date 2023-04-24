package com.udacity.shoestore.shoe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.shoe.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>> get() = _shoes

    private val _shoe = MutableLiveData<Shoe>()
    val shoe: LiveData<Shoe> get() = _shoe

    init {
        resetShoeList()
        resetShoe()
    }

    fun resetShoeList() {
        _shoes.value = mutableListOf()
    }

    fun resetShoe() {
        _shoe.value = Shoe("", 0.0, "", "")
    }

    fun addShoe() {
        _shoe.value?.let { _shoes.value?.add(it) }
    }
}
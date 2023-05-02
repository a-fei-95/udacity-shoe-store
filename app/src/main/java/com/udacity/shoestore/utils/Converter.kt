package com.udacity.shoestore.utils

import androidx.databinding.InverseMethod

internal object Converter {
    @InverseMethod("stringToDouble")
    @JvmStatic fun doubleToString(value: Double): String {
        return value.toString()
    }

    @JvmStatic fun stringToDouble(value: String): Double {
        return value.toDouble()
    }
}
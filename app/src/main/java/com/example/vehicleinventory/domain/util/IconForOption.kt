package com.example.vehicleinventory.domain.util

import androidx.annotation.DrawableRes
import com.example.vehicleinventory.R

@DrawableRes
fun getIconForOption(option: String): Int?{
    return when(option.lowercase()){
        "tata" -> R.drawable.ic_tata
        "yamaha" -> R.drawable.ic_yamaha
        "bajaj" -> R.drawable.ic_bajaj
        "honda"-> R.drawable.ic_honda
        "hero" -> R.drawable.ic_hero
        else -> { null}
    }
}
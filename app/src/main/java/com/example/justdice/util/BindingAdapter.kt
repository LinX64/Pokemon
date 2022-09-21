package com.example.justdice.util

import android.widget.ImageView
import com.bumptech.glide.Glide

object BindingAdapter {

    @JvmStatic
    @androidx.databinding.BindingAdapter("setImage")
    fun ImageView.setImage(image: String) {
        Glide.with(context).load(image).into(this)
    }

}
package com.example.tvshowcase.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.tvshowcase.R

@BindingAdapter("app:loadImage")
fun ImageView.loadImage(url: String) {
    Glide.with(this).load(url).placeholder(R.drawable.image_palce_holder).into(this)
}
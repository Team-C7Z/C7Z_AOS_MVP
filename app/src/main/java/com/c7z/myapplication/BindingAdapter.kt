package com.c7z.myapplication

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("Common_setCircleImage")
fun ImageView.setCircleImage(path : Any) {
    Glide.with(this).load(path).circleCrop().into(this)
}
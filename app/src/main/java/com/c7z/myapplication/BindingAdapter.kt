package com.c7z.myapplication

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.c7z.myapplication.home.adpter.CalendarAdapter


@BindingAdapter("Common_setCircleImage")
fun ImageView.setCircleImage(path : Any) {
    Glide.with(this).load(path).circleCrop().into(this)
}

@BindingAdapter("Common_setImage")
fun ImageView.setImage(path : Any) {
    Glide.with(this).load(path).into(this)
}

@BindingAdapter("Home_Calendar")
fun RecyclerView.setCalendar(adapter : CalendarAdapter) {
    this.adapter = adapter
}
package com.c7z.myapplication

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.c7z.myapplication.home.adpter.CalendarAdapter
import com.c7z.myapplication.todo.adapter.TodoTabAdapter


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

@BindingAdapter("Todo_Pager2")
fun ViewPager2.setPager2(adapter : TodoTabAdapter) {
    this.adapter = adapter
}
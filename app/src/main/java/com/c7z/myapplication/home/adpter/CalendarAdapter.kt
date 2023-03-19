package com.c7z.myapplication.home.adpter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.c7z.myapplication.databinding.ItemHomeRvCalendarBinding
import com.c7z.myapplication.home.model.CalendarItem


class CalendarAdapter : RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder>() {
    private var dateList = mutableListOf<CalendarItem>()
    private var height: Int? = null

    inner class CalendarViewHolder(val binding: ItemHomeRvCalendarBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CalendarItem) {
            binding.calendar = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        return CalendarViewHolder(ItemHomeRvCalendarBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = 35

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        height?.let {
            holder.binding.root.layoutParams.height = it
        }
        holder.bind(dateList[position])
    }

    fun setCalendarList(newList: MutableList<CalendarItem>) {
        dateList = newList
        notifyDataSetChanged()
    }

    fun setHeight(height: Int) {
        this.height = height
    }
}
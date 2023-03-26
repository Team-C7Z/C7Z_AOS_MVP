package com.c7z.myapplication.group.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.c7z.myapplication.databinding.ItemGroupRvAttendingGroupBinding
import com.c7z.myapplication.group.model.GroupItem

class GroupAdapter : RecyclerView.Adapter<GroupAdapter.GroupViewHolder>() {
    private var groupList = mutableListOf<GroupItem>()

    inner class GroupViewHolder(val binding: ItemGroupRvAttendingGroupBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GroupItem) {
            binding.attendingGroup = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        return GroupViewHolder(ItemGroupRvAttendingGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = groupList.size

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.bind(groupList[position])
    }

    fun setAttendingGroupList(newList: MutableList<GroupItem>) {
        groupList = newList
        notifyDataSetChanged()
    }
}
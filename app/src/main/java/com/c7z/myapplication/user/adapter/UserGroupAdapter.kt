package com.c7z.myapplication.user.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.c7z.myapplication.databinding.ItemUserRvUserGroupBinding

class UserGroupAdapter(private val groupData : List<String>) : RecyclerView.Adapter<UserGroupAdapter.UserGroupViewHolder>() {

    inner class UserGroupViewHolder(private val binding : ItemUserRvUserGroupBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : String) {
            binding.groupTitle = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserGroupViewHolder {
        return UserGroupViewHolder(ItemUserRvUserGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = groupData.size

    override fun onBindViewHolder(holder: UserGroupViewHolder, position: Int) {
        holder.bind(groupData[position])
    }
}
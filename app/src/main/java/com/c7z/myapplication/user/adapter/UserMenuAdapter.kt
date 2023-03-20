package com.c7z.myapplication.user.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.c7z.myapplication.databinding.ItemUserRvUserMenuBinding
import com.c7z.myapplication.user.model.UserMenuItem

class UserMenuAdapter(private val menuItems : List<UserMenuItem>, val onClick : (String) -> Unit) : RecyclerView.Adapter<UserMenuAdapter.UserMenuViewHolder>() {

    inner class UserMenuViewHolder(private val binding : ItemUserRvUserMenuBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : UserMenuItem) {
            binding.menuItem = item
            binding.root.setOnClickListener {
                onClick(item.menuTitle)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserMenuViewHolder {
        return UserMenuViewHolder(ItemUserRvUserMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = menuItems.size

    override fun onBindViewHolder(holder: UserMenuViewHolder, position: Int) {
        holder.bind(menuItems[position])
    }
}
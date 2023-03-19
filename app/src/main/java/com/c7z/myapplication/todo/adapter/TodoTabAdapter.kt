package com.c7z.myapplication.todo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.c7z.myapplication.databinding.ItemTodoRvContainerBinding
import com.c7z.myapplication.databinding.ItemTodoRvWithTitleBinding
import com.c7z.myapplication.todo.model.TodoWithTitleItem

class TodoTabAdapter : RecyclerView.Adapter<TodoTabAdapter.TodoTabViewHolder>() {
    private val personalAdapter = TodoAdapter(true)
    private val groupAdapter = TodoAdapter(false)

    inner class TodoTabViewHolder(val binding : ItemTodoRvContainerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            when(adapterPosition) {
                0 -> binding.itemTodoRvContainer.adapter = personalAdapter
                1 -> binding.itemTodoRvContainer.adapter = groupAdapter
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoTabViewHolder {
        return TodoTabViewHolder(ItemTodoRvContainerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = 2

    override fun onBindViewHolder(holder: TodoTabViewHolder, position: Int) {
        holder.bind()
    }

    fun setPersonalTodo(todo : List<TodoWithTitleItem>) = personalAdapter.setPersonalTodo(todo)
    fun setGroupTodo(todo : List<TodoWithTitleItem>) = groupAdapter.setGroupTodo(todo)
}
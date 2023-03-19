package com.c7z.myapplication.todo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.c7z.myapplication.databinding.ItemTodoRvItemTodoCheckboxBinding
import com.c7z.myapplication.databinding.ItemTodoRvWithoutTitleBinding
import com.c7z.myapplication.todo.model.Todo

class TodoItemAdapter(private val todo : MutableList<Todo>) : RecyclerView.Adapter<TodoItemAdapter.TodoItemViewHolder>() {

    inner class TodoItemViewHolder(private val binding : ItemTodoRvItemTodoCheckboxBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Todo) {
            binding.todo = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder {
        return TodoItemViewHolder(ItemTodoRvItemTodoCheckboxBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = todo.size

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        holder.bind(todo[position])
    }
}
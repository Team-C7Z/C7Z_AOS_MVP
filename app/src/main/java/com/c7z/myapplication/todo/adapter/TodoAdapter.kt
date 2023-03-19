package com.c7z.myapplication.todo.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.c7z.myapplication.databinding.ItemTodoRvWithTitleBinding
import com.c7z.myapplication.databinding.ItemTodoRvWithoutTitleBinding
import com.c7z.myapplication.todo.model.TodoWithTitleItem

class TodoAdapter(private val isPersonal : Boolean) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var personalTodo = mutableListOf<TodoWithTitleItem>()
    private var groupTodo = mutableListOf<TodoWithTitleItem>()

    inner class TodoWithTitleViewHolder(val binding : ItemTodoRvWithTitleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : TodoWithTitleItem) {
            binding.todoItem = item
            binding.itemTodoRvCardItem.strokeColor = Color.GRAY
            binding.itemTodoRvRvTodo.adapter = TodoItemAdapter(item.todoList as MutableList)
        }
    }

    inner class TodoWithoutTitleViewHolder(val binding : ItemTodoRvWithoutTitleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : TodoWithTitleItem) {
            binding.todoItem = item
            binding.itemTodoRvCardItem.strokeColor = Color.GRAY
            binding.itemTodoRvRvTodo.adapter = TodoItemAdapter(item.todoList as MutableList)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            0 -> TodoWithoutTitleViewHolder(ItemTodoRvWithoutTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> TodoWithTitleViewHolder(ItemTodoRvWithTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int = if(isPersonal && personalTodo[position].title == null) 0 else 1

    override fun getItemCount(): Int = if(isPersonal) personalTodo.size else groupTodo.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(isPersonal) {
            when(holder) {
                is TodoWithTitleViewHolder -> holder.bind(personalTodo[position])
                is TodoWithoutTitleViewHolder -> holder.bind(personalTodo[position])
            }
        } else {
            when(holder) {
                is TodoWithTitleViewHolder -> holder.bind(groupTodo[position])
                is TodoWithoutTitleViewHolder -> holder.bind(groupTodo[position])
            }
        }
    }

    fun setPersonalTodo(newList : List<TodoWithTitleItem>) {
        personalTodo = newList as MutableList
        notifyDataSetChanged()
    }

    fun setGroupTodo(newList : List<TodoWithTitleItem>) {
        groupTodo = newList as MutableList
        notifyDataSetChanged()
    }
}
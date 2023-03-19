package com.c7z.myapplication.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.c7z.myapplication.R
import com.c7z.myapplication.databinding.FragmentTodoBinding
import com.c7z.myapplication.todo.adapter.TodoTabAdapter
import com.c7z.myapplication.todo.model.Todo
import com.c7z.myapplication.todo.model.TodoWithTitleItem
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TodoFragment : Fragment() {
    private lateinit var binding : FragmentTodoBinding
    private val todoTabAdapter by lazy {
        TodoTabAdapter()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_todo, container, false)

        initTabLayout()
        initRV()

        return binding.root
    }

    private fun initTabLayout() {
        binding.fgTodoVpContainer.apply {
            this.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            this.adapter = todoTabAdapter
            TabLayoutMediator(binding.fgTodoTabPersonalOrGroup, this) { mTab, position ->
                mTab.text = returnTabTitle()[position]
            }.attach()
        }
    }

    private fun initRV() {
        todoTabAdapter.setGroupTodo(returnGroupTodo())
        todoTabAdapter.setPersonalTodo(returnPersonalTodo())
    }

    /** Dummy */
    private fun returnTabTitle() : List<String> = listOf("개인", "모임")

    private fun returnPersonalTodo() : List<TodoWithTitleItem> =
        listOf<TodoWithTitleItem>(TodoWithTitleItem("매일 할 일", true, null, returnTodo()), TodoWithTitleItem(null, null, null, returnTodo()))

    private fun returnGroupTodo() : List<TodoWithTitleItem> =
        listOf(TodoWithTitleItem("학교모임", true, "2023/03/20(월)", returnTodo()), TodoWithTitleItem("운동모임", false, "2023/03/20(월)", returnTodo()))



    private fun returnTodo() : List<Todo> =
        mutableListOf<Todo>().apply {
            for(i in 0 until 3) {
                this.add(Todo(false, "Todo$i"))
            }
        }
}
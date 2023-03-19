package com.c7z.myapplication.todo.model

data class TodoWithTitleItem (
    val title : String?,
    val isPined : Boolean?,
    val targetTime : String?,
    val todoList : List<Todo>
        )
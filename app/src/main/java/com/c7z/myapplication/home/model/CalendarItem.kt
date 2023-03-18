package com.c7z.myapplication.home.model

data class CalendarItem (

    val monthType : Int, // 0 : P / 1 : C / 2 : N -> Past Current Next
    val monthDay : String
        )
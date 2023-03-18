package com.c7z.myapplication.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.c7z.myapplication.R
import com.c7z.myapplication.databinding.FragmentHomeBinding
import com.c7z.myapplication.home.adpter.CalendarAdapter
import com.c7z.myapplication.home.model.CalendarItem
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var calendarAdapter: CalendarAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        initBinding()

        return binding.root
    }

    fun calendarAdapter() = CalendarAdapter().also {
        calendarAdapter = it
        initRv()
    }

    private fun initRv() {
        binding.fgHomeRvCalendar.viewTreeObserver
            .addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    val height: Int = binding.fgHomeRvCalendar.height / 5
                    calendarAdapter.setHeight(height)
                    calendarAdapter.notifyDataSetChanged()
                    binding.root.viewTreeObserver.removeOnGlobalLayoutListener(this)
                }
            })

        calendarAdapter.setCalendarList(
            getCalendarDates(
                getCurrentYear().toInt(),
                getCurrentMonth().toInt()
            ) as MutableList
        )
    }

    private fun initBinding() {
        binding.home = this
    }

    fun returnCurrentYearMonth(): String = "${getCurrentYear()}년 ${getCurrentMonth()}월"

    private fun getCurrentYear(): String {
        return SimpleDateFormat("yyyy", Locale.KOREA).format(Date(System.currentTimeMillis()))
    }

    private fun getCurrentMonth(): String {
        return SimpleDateFormat("MM", Locale.KOREA).format(Date(System.currentTimeMillis()))
    }

    private fun getCalendarDates(calendarYear: Int, calendarMonth: Int): List<CalendarItem> {
        val mCal = Calendar.getInstance()
        mCal.set(calendarYear, calendarMonth - 1, 1)

        val startDay = mCal.get(Calendar.DAY_OF_WEEK) - 1
        val lastDate = mCal.getActualMaximum(Calendar.DAY_OF_MONTH)

        return getActualCalendarDates(startDay, lastDate)
    }

    private fun getActualCalendarDates(startDay: Int, lastDate: Int): List<CalendarItem> {
        return mutableListOf<CalendarItem>().apply {
            getLastMonthDates(startDay).forEach {
                this.add(it)
            }
            for (i in 1 until lastDate + 1) {
                this.add(CalendarItem(1, i.toString()))
            }
            getNextMonthDates(this.size).forEach {
                this.add(it)
            }
        }
    }

    private fun getLastMonthDates(range: Int): List<CalendarItem> {
        val mCal = Calendar.getInstance()
        if (getCurrentMonth().toInt() == 1) {
            mCal.set(getCurrentYear().toInt() - 1, getCurrentMonth().toInt() - 3, 1)
        } else {
            mCal.set(getCurrentYear().toInt(), getCurrentMonth().toInt() - 2, 1)
        }
        val lastDate = mCal.getActualMaximum(Calendar.DAY_OF_MONTH)
        return mapToCalendarList(0, lastDate, range)
    }

    private fun mapToCalendarList(type: Int, date: Int, range: Int): List<CalendarItem> {
        return mutableListOf<CalendarItem>().apply {
            for (i in date - range + 1..date) {
                this.add(CalendarItem(type, i.toString()))
            }
        }
    }
}

private fun getNextMonthDates(size: Int): List<CalendarItem> {
    return mutableListOf<CalendarItem>().apply {
        for (i in size until 35) {
            this.add(CalendarItem(2, (i + 1 - size).toString()))
        }
    }
}
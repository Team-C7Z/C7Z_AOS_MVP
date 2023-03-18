package com.c7z.myapplication.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.c7z.myapplication.R
import com.c7z.myapplication.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        initBinding()

        return binding.root
    }

    private fun initBinding() {
        binding.home = this
    }

    fun returnCurrentYearMonth() : String = "${getCurrentYear()}년 ${getCurrentMonth()}월"

    private fun getCurrentYear(): String {
        return SimpleDateFormat("yyyy", Locale.KOREA).format(Date(System.currentTimeMillis()))
    }

    private fun getCurrentMonth(): String {
        return SimpleDateFormat("MM", Locale.KOREA).format(Date(System.currentTimeMillis()))
    }
}
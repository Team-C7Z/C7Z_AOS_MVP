package com.c7z.myapplication.group

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.fragment.app.Fragment
import com.c7z.myapplication.R
import com.c7z.myapplication.databinding.FragmentGroupBinding
import com.c7z.myapplication.group.adapter.GroupAdapter
import com.c7z.myapplication.group.model.GroupItem

class GroupFragment : Fragment() {
    private lateinit var binding : FragmentGroupBinding
    private val groupAdapter by lazy {
        GroupAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGroupBinding.inflate(inflater, container, false)

        initBinding()
        initRv()

        return binding.root
    }

    private fun initBinding() {
        binding.group = this
        binding.fgGroupRvGroup.adapter = groupAdapter
    }

    /*fun groupAdapter() = GroupAdapter().also {
        groupAdapter = it
        initRv()
    }
*/
    private fun initRv() {
        binding.fgGroupRvGroup.viewTreeObserver
            .addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
                @SuppressLint("NotifyDataSetChanged")
                override fun onGlobalLayout() {
                    groupAdapter.notifyDataSetChanged()
                    binding.root.viewTreeObserver.removeOnGlobalLayoutListener(this)
                }
            })

        groupAdapter.setAttendingGroupList(returnAttendingGroupList())
    }

    fun returnGroupCount(): String = groupAdapter.itemCount.toString()

    private fun returnAttendingGroupList() : MutableList<GroupItem> =
        mutableListOf(GroupItem(null, "스터디", "춘칠즈", null, "7"), GroupItem(null, "스터디", "춘칠즈", null, "7"), GroupItem(null, "스터디", "춘칠즈", null, "7"))

}
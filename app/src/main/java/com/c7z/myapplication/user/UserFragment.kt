package com.c7z.myapplication.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.c7z.myapplication.R
import com.c7z.myapplication.databinding.FragmentUserBinding
import com.c7z.myapplication.user.adapter.UserMenuAdapter
import com.c7z.myapplication.user.model.User
import com.c7z.myapplication.user.model.UserMenuItem

class UserFragment : Fragment() {
    private lateinit var binding : FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false)

        initBinding()

        return binding.root
    }

    fun menuAdapter() = UserMenuAdapter(returnUserMenuData(), ::onMenuClicked)

    private fun onMenuClicked(menuTitle : String) = Toast.makeText(requireContext(), "$menuTitle 클릭됨!", Toast.LENGTH_SHORT).show()

    private fun initBinding() {
        binding.user = returnUserData()
        binding.fragment = this
    }


    /** Dummy */
    private fun returnUserData() : User = User(R.drawable.ic_launcher_background, "김춘배")

    private fun returnUserMenuData() : List<UserMenuItem> =
        listOf(
            UserMenuItem(R.drawable.ic_user_friends, "친구"),
            UserMenuItem(R.drawable.ic_common_heart, "좋아요한 추억"),
            UserMenuItem(R.drawable.ic_user_notion, "공지사항"),
            UserMenuItem(R.drawable.ic_user_setting, "설정")
        )
}
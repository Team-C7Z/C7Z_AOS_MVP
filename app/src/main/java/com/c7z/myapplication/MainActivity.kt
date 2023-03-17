package com.c7z.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.c7z.myapplication.databinding.ActivityMainBinding
import com.c7z.myapplication.group.GroupFragment
import com.c7z.myapplication.home.HomeFragment
import com.c7z.myapplication.map.MapFragment
import com.c7z.myapplication.setting.SettingFragment
import com.c7z.myapplication.todo.TodoFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        binding.mainLayoutBottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.main_bottom_nav_btn_home -> setFragment(HomeFragment())
                R.id.main_bottom_nav_btn_group -> setFragment(GroupFragment())
                R.id.main_bottom_nav_btn_map -> setFragment(MapFragment())
                R.id.main_bottom_nav_btn_todo -> setFragment(TodoFragment())
                R.id.main_bottom_nav_btn_setting -> setFragment(SettingFragment())
            }
            false
        }

        binding.mainLayoutBottomNav.selectedItemId = R.id.main_bottom_nav_btn_home
    }

    private fun setFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.main_layout_container, fragment).commit()
    }
}
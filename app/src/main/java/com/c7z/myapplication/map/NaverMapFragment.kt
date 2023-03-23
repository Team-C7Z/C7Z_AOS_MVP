package com.c7z.myapplication.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.c7z.myapplication.R
import com.c7z.myapplication.databinding.FragmentNaverMapBinding
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback

class NaverMapFragment : Fragment(), OnMapReadyCallback {
    private lateinit var binding : FragmentNaverMapBinding
    private lateinit var map: NaverMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNaverMapBinding.inflate(inflater, container, false)

        val fm = childFragmentManager
        val mapFragment = fm.findFragmentById(R.id.fg_map_layout_map) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.fg_map_layout_map, it).commit()
            }
        mapFragment.getMapAsync(this)

        return binding.root
    }

    override fun onMapReady(map: NaverMap) {
        this.map = map
    }
}
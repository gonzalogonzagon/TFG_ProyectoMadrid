package com.example.tfg_proyectomadrid.view.maps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tfg_proyectomadrid.databinding.FragmentCityMapBinding

class CityMapFragment : Fragment() {

    private var _binding: FragmentCityMapBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using ViewBinding
        _binding = FragmentCityMapBinding.inflate(inflater, container, false)
        return binding.root
    }
}
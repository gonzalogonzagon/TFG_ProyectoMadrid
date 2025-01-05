package com.example.tfg_proyectomadrid.view.list_pi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tfg_proyectomadrid.databinding.FragmentListPiBinding
import com.example.tfg_proyectomadrid.model.list_pi.PointOfInterestProvider
import com.example.tfg_proyectomadrid.viewmodel.list_pi.PointOfInterestAdapter

class ListPiFragment : Fragment() {

    private var _binding: FragmentListPiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflar el layout usando ViewBinding
        _binding = FragmentListPiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Inicializar el RecyclerView
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = PointOfInterestAdapter(PointOfInterestProvider.pointOfInterestList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
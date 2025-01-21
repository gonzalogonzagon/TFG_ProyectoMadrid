package com.example.tfg_proyectomadrid.view.list_pi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tfg_proyectomadrid.databinding.FragmentListPiBinding
import com.example.tfg_proyectomadrid.model.list_pi.PointOfInterestProvider
import com.example.tfg_proyectomadrid.viewmodel.list_pi.PointOfInterestAdapter

class ListPiFragment : Fragment() {

    private var _binding: FragmentListPiBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapterPI: PointOfInterestAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListPiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    // (Made by user) Function to initialize the RecyclerView
    private fun initRecyclerView() {
        adapterPI = PointOfInterestAdapter(PointOfInterestProvider.pointOfInterestList) { pointOfInterest ->
            // Navegar al fragmento en detalle
            val action = ListPiFragmentDirections.actionListPiFragmentToDetailPiFragment(pointOfInterest.title)
            findNavController().navigate(action)
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterPI
        }
        //Log.d("ListPiFragment", "RecyclerView initialized with ${adapterPI.itemCount} items")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
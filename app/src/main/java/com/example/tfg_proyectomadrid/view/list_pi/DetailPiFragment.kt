package com.example.tfg_proyectomadrid.view.list_pi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tfg_proyectomadrid.databinding.FragmentDetailPiBinding


class DetailPiFragment : Fragment() {

    private var _binding: FragmentDetailPiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailPiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Aquí puedes obtener los argumentos y mostrar la información detallada
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
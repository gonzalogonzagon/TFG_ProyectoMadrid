package com.example.tfg_proyectomadrid.view.list_pi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tfg_proyectomadrid.databinding.FragmentDetailPiBinding
import com.example.tfg_proyectomadrid.model.list_pi.PointOfInterest
import com.example.tfg_proyectomadrid.model.list_pi.PointOfInterestProvider


class DetailPiFragment : Fragment() {

    private var _binding: FragmentDetailPiBinding? = null
    private val binding get() = _binding!!
    private val args: DetailPiFragmentArgs by navArgs()

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
        val pointOfInterestTitle = args.pointOfInterestId
        val pointOfInterest = PointOfInterestProvider.pointOfInterestList.find {
            it.title == pointOfInterestTitle
        }

        initUI(pointOfInterest)
    }

    private fun initUI(pointOfInterest: PointOfInterest?) {
        pointOfInterest?.let {
            binding.tvTitle.setText(it.title)
            binding.tvDescription.setText(it.description)
            binding.image.setImageResource(it.image)
            // Actualiza otras vistas según sea necesario
        }

        // Configurar el FloatingActionButton para navegar hacia atrás
        binding.fabBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
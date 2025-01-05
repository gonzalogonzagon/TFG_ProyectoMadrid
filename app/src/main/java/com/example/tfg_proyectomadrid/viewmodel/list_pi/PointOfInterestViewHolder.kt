package com.example.tfg_proyectomadrid.viewmodel.list_pi

import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.tfg_proyectomadrid.databinding.ItemListPiBinding
import com.example.tfg_proyectomadrid.model.list_pi.PointOfInterest
import com.example.tfg_proyectomadrid.view.list_pi.ListPiFragmentDirections

class PointOfInterestViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemListPiBinding.bind(view)

    fun bind(pointOfInterest: PointOfInterest) {
        binding.tvTitle.setText(pointOfInterest.title)
        binding.tvDescription.setText(pointOfInterest.description)
        binding.image.setImageResource(pointOfInterest.image)

        binding.root.setOnClickListener {
            // Aquí puedes navegar a la pantalla de detalle
            val action = ListPiFragmentDirections.actionListPiFragmentToDetailPiFragment()
            it.findNavController().navigate(action)
        }
    }
}
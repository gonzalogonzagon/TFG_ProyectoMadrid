package com.example.tfg_proyectomadrid.viewmodel.list_pi

import android.view.View
import android.widget.Toast
//import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.tfg_proyectomadrid.databinding.ItemListPiBinding
import com.example.tfg_proyectomadrid.model.list_pi.PointOfInterest
//import com.example.tfg_proyectomadrid.view.list_pi.ListPiFragmentDirections

class PointOfInterestViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemListPiBinding.bind(view)

    fun bind(pointOfInterest: PointOfInterest) {
        binding.tvTitle.setText(pointOfInterest.title)
        binding.tvDescription.setText(pointOfInterest.description)
        binding.image.setImageResource(pointOfInterest.image)

        // Establecer OnClickListener para los botones
        binding.button1.setOnClickListener {
            // Manejar el clic del botón 1
            Toast.makeText(it.context, "Botón 1", Toast.LENGTH_SHORT).show()
        }

        binding.button2.setOnClickListener {
            // Manejar el clic del botón 2
            Toast.makeText(it.context, "Botón 2", Toast.LENGTH_SHORT).show()
        }

//        binding.root.setOnClickListener {
//            // Aquí puedes navegar a la pantalla de detalle
//            val action = ListPiFragmentDirections.actionListPiFragmentToDetailPiFragment()
//            it.findNavController().navigate(action)
//        }
    }
}
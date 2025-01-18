package com.example.tfg_proyectomadrid.viewmodel.list_pi

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tfg_proyectomadrid.databinding.ItemListPiBinding
import com.example.tfg_proyectomadrid.model.list_pi.PointOfInterest

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

    }
}
package com.example.tfg_proyectomadrid.viewmodel.list_pi

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.tfg_proyectomadrid.databinding.ItemListPiBinding
import com.example.tfg_proyectomadrid.model.list_pi.PointOfInterest

class PointOfInterestViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemListPiBinding.bind(view)

    fun render(pointOfInterest: PointOfInterest) {
        binding.tvTitle.setText(pointOfInterest.title)
        binding.tvDescription.setText(pointOfInterest.description)
        binding.image.setImageResource(pointOfInterest.image)
    }
}
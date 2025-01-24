package com.example.tfg_proyectomadrid.view.maps

import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import com.example.tfg_proyectomadrid.R
import com.example.tfg_proyectomadrid.databinding.ItemListPiBinding
import com.example.tfg_proyectomadrid.model.list_pi.PointOfInterest
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.infowindow.InfoWindow

class CustomInfoWindow(mapView: MapView, private val pointOfInterest: PointOfInterest) :
    InfoWindow(R.layout.item_list_pi, mapView) {

    private val binding: ItemListPiBinding = ItemListPiBinding.bind(mView)

    override fun onClose() {
        // Nothing to do here
    }

    override fun onOpen(item: Any) {
        val marker = item as Marker

        // Set the title and description
        binding.tvTitle.text = marker.title
        binding.tvDescription.text = marker.snippet

        // Set the image (you can customize this as needed)
        binding.image.setImageDrawable(
            ContextCompat.getDrawable(
                binding.root.context,
                R.drawable.ic_launcher_foreground
            )
        )


        binding.root.setOnClickListener {
            val action =
                CityMapFragmentDirections.actionCityMapFragmentToDetailPiFragment(pointOfInterest.title)
            it.findNavController().navigate(action)
        }

        // Set button actions if needed
        binding.button1.setOnClickListener {
            // Handle button 1 click
        }

        binding.button2.setOnClickListener {
            // Handle button 2 click
        }
    }
}
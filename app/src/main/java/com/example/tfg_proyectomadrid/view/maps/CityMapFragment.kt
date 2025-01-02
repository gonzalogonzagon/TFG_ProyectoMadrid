package com.example.tfg_proyectomadrid.view.maps

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tfg_proyectomadrid.BuildConfig
import com.example.tfg_proyectomadrid.databinding.FragmentCityMapBinding
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.BoundingBox
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class CityMapFragment : Fragment() {

    private var _binding: FragmentCityMapBinding? = null
    private val binding get() = _binding!!
    private lateinit var map: MapView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Load/initialize the osmdroid configuration
        Configuration.getInstance()
            .load(context, context.getSharedPreferences("osmdroid", Context.MODE_PRIVATE))
        //   Set the User-Agent value
        Configuration.getInstance().userAgentValue = BuildConfig.APPLICATION_ID
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using ViewBinding
        _binding = FragmentCityMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initialize and configure UI components here
        setupMap()
        addMarker(40.416775, -3.703790, "Madrid", "Capital of Spain")
    }

    private fun setupMap() {
        // Initialize the map
        map = binding.map
        map.setTileSource(TileSourceFactory.MAPNIK) // Set the tile source explicitly
        map.setMultiTouchControls(true)
        map.minZoomLevel = 13.0 // Set minimum zoom level
        map.maxZoomLevel = 20.5 // Set maximum zoom level
        map.controller.setZoom(15.0)
        val startPoint = GeoPoint(40.416775, -3.703790) // Coordinates for Madrid
        map.controller.setCenter(startPoint)

        // Define the bounding box for the Comunidad de Madrid
        val boundingBox = BoundingBox(
            40.5,
            -3.6,
            40.3,
            -3.8
        )
        // Set the scrollable area limit
        map.setScrollableAreaLimitDouble(boundingBox)
    }

    private fun addMarker(latitude: Double, longitude: Double, title: String, description: String) {
        val marker = Marker(map)
        marker.position = GeoPoint(latitude, longitude)
        marker.title = title
        marker.snippet = description
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        map.overlays.add(marker)
        map.invalidate() // Refresh the map to show the marker
    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
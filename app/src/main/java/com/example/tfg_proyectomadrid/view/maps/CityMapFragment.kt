package com.example.tfg_proyectomadrid.view.maps

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
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
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.Overlay

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

        // Set the tile source explicitly
        map.setTileSource(TileSourceFactory.MAPNIK)

        map.setMultiTouchControls(true)
        // Disable zoom buttons
        map.zoomController.setVisibility(CustomZoomButtonsController.Visibility.NEVER)

        // Set minimum and maximum zoom levels
        map.minZoomLevel = 13.0
        map.maxZoomLevel = 20.5

        // Set initial zoom level and center point
        map.controller.setZoom(15.8)
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

        // Add OpenStreetMap credit overlay
        addCreditOverlay()
    }

    private fun addCreditOverlay() {
        val paint = Paint().apply {
            color = Color.BLACK
            textSize = 28f
            isAntiAlias = true
        }
        val backgroundPaint = Paint().apply {
            color = Color.WHITE
        }

        val textOverlay = object : Overlay() {
            override fun draw(c: Canvas, osmv: MapView, shadow: Boolean) {
                if (!shadow) {
                    val x = 10f
                    val y = osmv.height - 10f
                    val text = "© OpenStreetMap contributors, ODbL"
                    val textWidth = paint.measureText(text)
                    val textHeight = paint.textSize

                    // Dibujar el fondo blanco
                    c.drawRect(x, y - textHeight, x + textWidth, y, backgroundPaint)

                    // Dibujar el texto
                    c.drawText(text, x, y, paint)
                }
            }
        }

        map.overlays.add(textOverlay)
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
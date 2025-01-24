package com.example.tfg_proyectomadrid.view.maps

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.tfg_proyectomadrid.BuildConfig
import com.example.tfg_proyectomadrid.databinding.FragmentCityMapBinding
import com.example.tfg_proyectomadrid.model.list_pi.PointOfInterest
import com.example.tfg_proyectomadrid.model.list_pi.PointOfInterestProvider
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.BoundingBox
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.CopyrightOverlay
import org.osmdroid.views.overlay.Marker
import kotlin.math.cos
import kotlin.math.sin

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
        //addMarker(40.416775, -3.703790, "Madrid", "Capital of Spain")
        addMarkers(PointOfInterestProvider.pointOfInterestList)
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
        val copyrightNotice = map.tileProvider.tileSource.copyrightNotice
        val copyrightOverlay = CopyrightOverlay(context)
        copyrightOverlay.setCopyrightNotice(copyrightNotice)
        map.overlays.add(copyrightOverlay)
    }


    private fun addMarkers(pointsOfInterest: List<PointOfInterest>) {
        val centerLatitude = 40.416775
        val centerLongitude = -3.703790
        val radius = 0.01
        val angleStep = 360.0 / pointsOfInterest.size

        for ((index, poi) in pointsOfInterest.withIndex()) {
            val angle = Math.toRadians(index * angleStep)
            val latitude = centerLatitude + radius * cos(angle)
            val longitude = centerLongitude + radius * sin(angle)
            addMarker(latitude, longitude, poi)
        }
    }

    private fun addMarker(latitude: Double, longitude: Double, pointOfInterest: PointOfInterest) {
        val marker = Marker(map)
        marker.position = GeoPoint(latitude, longitude)
        marker.title = getString(pointOfInterest.title)
        marker.snippet = getString(pointOfInterest.description)
        marker.icon = ContextCompat.getDrawable(requireContext(), android.R.drawable.star_big_on)
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        marker.infoWindow = CustomInfoWindow(map, pointOfInterest)
        map.overlays.add(marker)
        map.invalidate()
    }

//    private fun addCreditOverlay() {
//        val paint = Paint().apply {
//            color = Color.BLACK
//            textSize = 28f
//            isAntiAlias = true
//        }
//        val backgroundPaint = Paint().apply {
//            color = Color.WHITE
//        }
//
//        val textOverlay = object : Overlay() {
//            override fun draw(c: Canvas, osmv: MapView, shadow: Boolean) {
//                if (!shadow) {
//                    val x = 10f
//                    val y = osmv.height - 10f
//                    val text = "© OpenStreetMap contributors, ODbL"
//                    val textWidth = paint.measureText(text)
//                    val textHeight = paint.textSize
//
//                    // Dibujar el fondo blanco
//                    c.drawRect(x, y - textHeight, x + textWidth, y, backgroundPaint)
//
//                    // Dibujar el texto
//                    c.drawText(text, x, y, paint)
//                }
//            }
//        }
//
//        map.overlays.add(textOverlay)
//    }

//    private fun addMarkers(pointsOfInterest: List<PointOfInterest>) {
//        val centerLatitude = 40.416775
//        val centerLongitude = -3.703790
//        val radius = 0.01 // Radio del círculo en grados
//
//        val angleStep = 360.0 / pointsOfInterest.size
//
//        for ((index, poi) in pointsOfInterest.withIndex()) {
//            val angle = Math.toRadians(index * angleStep)
//            val latitude = centerLatitude + radius * cos(angle)
//            val longitude = centerLongitude + radius * sin(angle)
//            addMarker(latitude, longitude, getString(poi.title), getString(poi.description))
//        }
//    }
//
//    private fun addMarker(latitude: Double, longitude: Double, title: String, description: String) {
//        val marker = Marker(map)
//        marker.position = GeoPoint(latitude, longitude)
//        marker.title = title
//        marker.snippet = description
//        marker.icon = ContextCompat.getDrawable(requireContext(), android.R.drawable.star_big_on)
//        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
//
////        // Set custom info window
////        marker.infoWindow = CustomInfoWindow(map)
//
//        // Set custom info window
////        marker.setOnMarkerClickListener { _, _ ->
////            //showInfoWindow(title, description)
////            showInfoWindow()
////            true
////        }
//
//        map.overlays.add(marker)
//        map.invalidate() // Refresh the map to show the marker
//    }
//
//    private fun showInfoWindow() {
////        infoWindowBinding.tvTitle.text = title
////        infoWindowBinding.tvDescription.text = description
//        infoWindowBinding.root.visibility = View.VISIBLE
//    }
//
//    private fun hideInfoWindow() {
//        infoWindowBinding.root.visibility = View.GONE
//    }
//

//    private fun addMarker(latitude: Double, longitude: Double, title: String, description: String) {
//        val marker = Marker(map)
//        marker.position = GeoPoint(latitude, longitude)
//        marker.title = title
//        marker.snippet = description
//        marker.icon = ContextCompat.getDrawable(requireContext(), android.R.drawable.star_big_on)
//        //marker.icon = resources.getDrawable(android.R.drawable.star_big_on)
//        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
//        map.overlays.add(marker)
//        map.invalidate() // Refresh the map to show the marker
//    }

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
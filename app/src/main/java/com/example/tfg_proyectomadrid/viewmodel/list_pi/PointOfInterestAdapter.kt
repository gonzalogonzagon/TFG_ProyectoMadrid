package com.example.tfg_proyectomadrid.viewmodel.list_pi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tfg_proyectomadrid.R
import com.example.tfg_proyectomadrid.model.list_pi.PointOfInterest

class PointOfInterestAdapter(private val pointOfInterestList: List<PointOfInterest>) :
    RecyclerView.Adapter<PointOfInterestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointOfInterestViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PointOfInterestViewHolder(
            layoutInflater.inflate(
                R.layout.item_list_pi,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = pointOfInterestList.size

    override fun onBindViewHolder(holder: PointOfInterestViewHolder, position: Int) {
        holder.bind(pointOfInterestList[position])
    }
}
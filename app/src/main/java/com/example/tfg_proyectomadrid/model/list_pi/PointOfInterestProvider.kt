package com.example.tfg_proyectomadrid.model.list_pi

import com.example.tfg_proyectomadrid.R

object PointOfInterestProvider {
    val pointOfInterestList: List<PointOfInterest> = listOf(
        PointOfInterest(
            title = R.string.plaza_mayor_title,
            description = R.string.plaza_mayor_description,
            category = R.color.yellow,
            image = R.drawable.ic_launcher_foreground
        ),

        PointOfInterest(
            title = R.string.puerta_sol_title,
            description = R.string.puerta_sol_description,
            category = R.color.blue,
            image = R.drawable.ic_launcher_foreground
        ),

        PointOfInterest(
            title = R.string.parque_retiro_title,
            description = R.string.parque_retiro_description,
            category = R.color.gray,
            image = R.drawable.ic_launcher_foreground
        ),

        PointOfInterest(
            title = R.string.palacio_real_title,
            description = R.string.palacio_real_description,
            category = R.color.green,
            image = R.drawable.ic_launcher_foreground
        ),

        PointOfInterest(
            title = R.string.gran_via_title,
            description = R.string.gran_via_description,
            category = R.color.cyan,
            image = R.drawable.ic_launcher_foreground
        ),

        PointOfInterest(
            title = R.string.templo_debod_title,
            description = R.string.templo_debod_description,
            category = R.color.magenta,
            image = R.drawable.ic_launcher_foreground
        )
    )
}
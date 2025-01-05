package com.example.tfg_proyectomadrid.model.list_pi

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.tfg_proyectomadrid.R

sealed class PointOfInterest(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
) {
    data object PlazaMayor : PointOfInterest(
        title = R.string.plaza_mayor_title,
        description = R.string.plaza_mayor_description,
        image = R.drawable.ic_launcher_foreground
    )

    data object PuertaDelSol : PointOfInterest(
        title = R.string.puerta_sol_title,
        description = R.string.puerta_sol_description,
        image = R.drawable.ic_launcher_foreground
    )

    data object ParqueDelRetiro : PointOfInterest(
        title = R.string.parque_retiro_title,
        description = R.string.parque_retiro_description,
        image = R.drawable.ic_launcher_foreground
    )

    data object PalacioReal : PointOfInterest(
        title = R.string.palacio_real_title,
        description = R.string.palacio_real_description,
        image = R.drawable.ic_launcher_foreground
    )

    data object GranVia : PointOfInterest(
        title = R.string.gran_via_title,
        description = R.string.gran_via_description,
        image = R.drawable.ic_launcher_foreground
    )

    data object TemploDeDebod : PointOfInterest(
        title = R.string.templo_debod_title,
        description = R.string.templo_debod_description,
        image = R.drawable.ic_launcher_foreground
    )
}

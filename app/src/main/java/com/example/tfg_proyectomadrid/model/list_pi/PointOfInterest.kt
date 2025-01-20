package com.example.tfg_proyectomadrid.model.list_pi

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PointOfInterest(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @ColorRes val category: Int,
    @DrawableRes val image: Int
)

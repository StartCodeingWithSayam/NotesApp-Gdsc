package com.gdsc.notesapp.ui.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.gdsc.notesapp.R

sealed class NavItems(
    val route:String,
    @StringRes val tittle:Int,
    @DrawableRes val icon:Int){
    object Home : NavItems(
        route = "home",
        tittle = R.string.Home,
        icon = R.drawable.ic_baseline_home
    )
    object Education : NavItems(
        route = "education",
        tittle = R.string.Education,
        icon = R.drawable.icons8_student_center_24
    )
    object Profile : NavItems(
        route = "profile",
        tittle = R.string.Profile,
        icon = R.drawable.ic_baseline_person_24
    )
    object Settings : NavItems(
        route = "settings",
        tittle = R.string.Settings,
        icon = R.drawable.ic_baseline_settings_24
    )
}

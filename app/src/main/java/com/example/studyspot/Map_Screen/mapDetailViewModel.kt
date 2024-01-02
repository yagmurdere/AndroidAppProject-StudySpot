package com.example.studyspot.Map_Screen

import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

class mapDetailViewModel : ViewModel() {
    val places = arrayOf(
        "Kubbe",
        "Güzel Sanatlar Fakültesi",
        "Mühendislik Fakültesi",
        "Kafein Zone",
        "Depo",
        "Duppo",
        "Öteki",
        "Top Roastry",
        "Headquarters Coffee"
    )
    val xcor= arrayOf(
        300,
        200,
        100,
        200,
        100,
        200,
        100,
        200,
        100
    )
    val ycor= arrayOf(
        300,
        100,
        200,
        100,
        200,
        100,
        200,
        100,
        200
    )
}
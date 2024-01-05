package com.example.studyspot.modules.Map_Screen

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
        210,
        320,
        150,
        115,
        240,
        130,
        190,
        350,
        250



    )
    val ycor= arrayOf(
        250,
        485,
        320,
        30,
        30,
        5,
        30,
        100,
        80
    )
}
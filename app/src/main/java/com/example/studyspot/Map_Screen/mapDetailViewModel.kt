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
        100,
        200,
        300,
        400,
        500,
        600,/**/
        500,
        500,
        500
    )
    val ycor= arrayOf(
        100,
        100,
        100,
        100,
        100,
        300,
        300,
        300,
        100
    )
}
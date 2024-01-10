package com.example.studyspot.modules.Map_Screen

import android.util.Log
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.studyspot.entities.RestaurantModel
import com.example.studyspot.managers.FireBaseManager

class mapDetailViewModel : ViewModel() {

    val fireBaseManager = FireBaseManager()

    fun fetchRestaurant() {
        fireBaseManager.readRestaurants {
            if (it != null) {
                for(item in it) {
                    Log.d("DoHa", item.restaurantName!!)
                }
            }
        }
    }

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
package com.example.studyspot.modules.Map_Screen

import android.util.Log
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.studyspot.entities.RestaurantModel
import com.example.studyspot.managers.FireBaseManager

class mapDetailViewModel : ViewModel() {

    val fireBaseManager = FireBaseManager()
    var restaurantNameArray = mutableListOf<RestaurantModel>()
    fun fetchRestaurant() :MutableList<RestaurantModel> {
        fireBaseManager.readRestaurants { restaurants->
            if (restaurants != null) {
                for(item in restaurants) {
                    restaurantNameArray.add(
                        RestaurantModel(restaurantName = item.restaurantName!!,
                            restaurantHours = item.restaurantHours!!,
                            restaurantAddress = item.restaurantAddress!!,
                            wifi = item.wifi!!,
                            electric = item.electric!!,
                            hotDrink = item.hotDrink!!
                        ))

                    Log.d("Dymr1", restaurantNameArray.toString())
                }

            }
        }
        Log.d("Dymr2", restaurantNameArray.toString())
        return restaurantNameArray
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
    val wifi = arrayOf(
        true,
        false,
        true,
        false,
        true,
        false,
        true,
        false,
        true
    )
    val coffe = arrayOf(
        true,
        false,
        false,
        true,
        true,
        true,
        true,
        true,
        true
    )
    val plug = arrayOf(
        true,
        true,
        true,
        false,
        false,
        true,
        false,
        true,
        true
    )
    val yogun= arrayOf(
        10,
        20,
        30,
        40,
        50,
        60,
        70,
        80,
        90
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
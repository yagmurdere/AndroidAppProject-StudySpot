package com.example.studyspot.modules.Map_Screen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.studyspot.entities.DataSetRes
import com.example.studyspot.entities.RestaurantModel
import com.example.studyspot.managers.FireBaseManager
import com.google.firebase.auth.FirebaseAuth

class mapDetailViewModel : ViewModel() {
    private val fireBaseManager = FireBaseManager()
    private val _restaurant=MutableLiveData<List<RestaurantModel>>()
    val restaurants : LiveData<List<RestaurantModel>> get()=_restaurant
    fun fetchRestaurant() {
        fireBaseManager.readRestaurants {
            data -> _restaurant.postValue(data)
        }
    }
        /*{ restaurants->}}*/
    /*
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
    }*/



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
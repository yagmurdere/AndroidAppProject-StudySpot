package com.example.studyspot.entities

data class RestaurantModel (
    val restaurantName: String,
    val restaurantHours: String,
    val restaurantAddress: String,
    val wifi: Boolean,
    val electric: Boolean,
    val hotDrink: Boolean
)

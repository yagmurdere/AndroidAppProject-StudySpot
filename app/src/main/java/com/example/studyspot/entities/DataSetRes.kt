package com.example.studyspot.entities

sealed class DataSetRes {
    class Success(val data : MutableList<RestaurantModel>) : DataSetRes()
    class Failure(val message : String) : DataSetRes()
    object Loading:DataSetRes()
    object Empyt:DataSetRes()
}
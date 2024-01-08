package com.example.studyspot.modules.mapdetail

import androidx.lifecycle.ViewModel
import com.example.studyspot.entities.CommentModel
import com.example.studyspot.entities.RestaurantModel
import com.example.studyspot.entities.UserModel
import com.example.studyspot.managers.FireBaseManager

class MapDetailViewModel: ViewModel() {
    val fireBaseManager = FireBaseManager()
    fun fetchComments(restaurantID: String): List<CommentModel> {

        return listOf(
            CommentModel(
                "123",
                "123",
                "123",
                "Müzik çok yüksekti ama kahve inanılmaz"
            )
        )
    }

    fun fetchUser(): List<UserModel> {

        return listOf(
            UserModel(
                "Ezgi",
                "Erdem",
                "ezgierdem@gmail.com",
                "123",
                "123"
            )
        )
    }


}
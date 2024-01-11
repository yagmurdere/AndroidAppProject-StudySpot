package com.example.studyspot.modules.mapdetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studyspot.entities.CommentModel
import com.example.studyspot.entities.RestaurantModel
import com.example.studyspot.entities.UserModel
import com.example.studyspot.managers.FireBaseManager
import kotlinx.coroutines.launch

class MapDetailViewModel: ViewModel() {
    val fireBaseManager = FireBaseManager()
    private val _comments = MutableLiveData<List<CommentModel>>()
    val comments: LiveData<List<CommentModel>> get() = _comments

    fun fetchComments(restaurantID: String): List<CommentModel> {
        return listOf(
            CommentModel(
                "123",
                "123",
                "Müzik çok yüksekti ama kahve inanılmaz",
                4
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

    fun observeFirebaseData() {
        fireBaseManager.fetchComment { data ->
            _comments.postValue(data)
        }
    }
}
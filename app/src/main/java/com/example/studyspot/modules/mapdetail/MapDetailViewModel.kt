package com.example.studyspot.modules.mapdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studyspot.entities.BookMarkModel
import com.example.studyspot.entities.CommentModel
import com.example.studyspot.entities.CrawdedModel
import com.example.studyspot.entities.UserModel
import com.example.studyspot.managers.FireBaseManager

class MapDetailViewModel: ViewModel() {
    private val fireBaseManager = FireBaseManager()
    private val _comments = MutableLiveData<List<CommentModel>>()
    val comments: LiveData<List<CommentModel>> get() = _comments
    private val _users = MutableLiveData<List<UserModel>>()
    val users: LiveData<List<UserModel>> get() = _users

    private var _isHere = MutableLiveData<Boolean>(false)
    var isHere : LiveData<Boolean> = _isHere
    private var _isBookMarkChecked = MutableLiveData<Boolean>(false)
    var isBookMarkChecked : LiveData<Boolean> = _isBookMarkChecked

    fun fetchComments(restaurantID: String) {
        var list = mutableListOf<CommentModel>()
        fireBaseManager.fetchComment { data ->
            list = data.filter { it.restaurantID == restaurantID }.toMutableList()
            _comments.value = list
        }
    }

    fun fetchUsers() {
        fireBaseManager.fetchUsers { data ->
            _users.postValue(data)
        }
    }

    fun addCrawded(restaurantID: String, userId: String) {
        fireBaseManager.addCrawded(CrawdedModel(restaurantID, userId))
    }

    fun isHere(userId: String) {
        fireBaseManager.fetchCreawdedData {crawded ->
            crawded.map {
                if(it.userId == userId) {
                    _isHere.value = true
                }
            }
        }
    }

    fun leaveHere(userId: String) {
        fireBaseManager.removeCreawdedData(userId)
    }

    fun addBookMark(restaurantId: String, userId: String) {
        fireBaseManager.addBookMark(BookMarkModel(restaurantId, userId))
    }

    fun isBookMarkChecked(userId: String) {
        fireBaseManager.fetchBookMark {bookMark ->
            bookMark.map {
                if(it.userId == userId) {
                    _isBookMarkChecked.value = true
                }
            }
        }
    }
    fun removeBookMark(userId: String) {
        fireBaseManager.removeBookMark(userId)
    }
}
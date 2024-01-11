package com.example.studyspot.modules.mapdetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studyspot.entities.CommentModel
import com.example.studyspot.entities.UserModel
import com.example.studyspot.managers.FireBaseManager

class MapDetailViewModel: ViewModel() {
    private val fireBaseManager = FireBaseManager()
    private val _comments = MutableLiveData<List<CommentModel>>()
    val comments: LiveData<List<CommentModel>> get() = _comments
    private val _users = MutableLiveData<List<UserModel>>()
    val users: LiveData<List<UserModel>> get() = _users

    fun fetchComments() {
        fireBaseManager.fetchComment { data ->
            _comments.postValue(data)
        }
    }
    fun fetchUsers() {
        fireBaseManager.fetchUsers { data ->
            _users.postValue(data)
        }
    }

}
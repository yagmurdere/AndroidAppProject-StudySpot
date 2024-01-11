package com.example.studyspot.modules.commentscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.studyspot.entities.CommentModel
import com.example.studyspot.managers.FireBaseManager

class CommentViewModel: ViewModel() {
    private val fireBaseManager = FireBaseManager()
    fun createComment(
        restaurantId: String,
        userId: String,
        comment: String,
        star: Int,
        name: String
        ) {
        fireBaseManager.createComment(
            CommentModel(
                userId,
                restaurantId,
                comment,
                star,
                name
            ))
    }
}
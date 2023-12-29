package com.example.studyspot.modules.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.studyspot.entities.UserModel
import com.example.studyspot.managers.FireBaseManager

class SignUpViewModel: ViewModel() {
    private val fireBaseManager = FireBaseManager()

    fun createUser(
        name: String,
        surname: String,
        eMail: String,
        password: String,
        confirmPassword: String
    ) {
        Log.d("pas", password)
        Log.d("pas2", confirmPassword)
        if(password == confirmPassword) {
            val user = UserModel(name, surname, eMail, password)
            fireBaseManager.createAUser(user)
        } else {

        }
    }
}
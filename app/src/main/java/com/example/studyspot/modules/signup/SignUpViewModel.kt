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
        if(password == confirmPassword) {
            val user = UserModel(
                name.lowercase(),
                surname.lowercase(),
                eMail.lowercase(),
                password,
                ""
            )
            fireBaseManager.createAUser(user)
        } else {

        }
    }
}
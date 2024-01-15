package com.example.studyspot.modules.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.studyspot.entities.UserModel
import com.example.studyspot.managers.FireBaseManager
import com.example.studyspot.utilities.errors.FireBaseError

class SignUpViewModel: ViewModel() {
    private val fireBaseManager = FireBaseManager()

    fun createUser(
        name: String,
        surname: String,
        eMail: String,
        password: String,
        confirmPassword: String,
        isCheked: Boolean
    ): FireBaseError {
        if(isCheked) {
            if(password == confirmPassword) {
                val user = UserModel(
                    name.lowercase(),
                    surname.lowercase(),
                    eMail.lowercase(),
                    password,
                    ""
                )
                return fireBaseManager.createAUser(user)
            } else {
                return FireBaseError.PasswordNotEqual
            }
        } else {
            return FireBaseError.NoChecked
        }
    }
}
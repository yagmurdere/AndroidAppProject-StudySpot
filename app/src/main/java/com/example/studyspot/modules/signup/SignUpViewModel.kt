package com.example.studyspot.modules.signup

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
            val user = UserModel(name, surname, eMail, password)
            println(user)
        } else {

        }

    }
}
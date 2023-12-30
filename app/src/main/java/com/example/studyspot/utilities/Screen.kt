package com.example.studyspot.utilities

sealed class Screen(val route: String) {
    object SignUp: Screen(route = "signUpScreen")
    object MapDetail: Screen(route = "mapDetail")
}
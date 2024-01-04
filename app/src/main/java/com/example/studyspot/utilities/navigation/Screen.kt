package com.example.studyspot.utilities.navigation

sealed class Screen(val route: String) {
    object SignUp: Screen(route = "signUpScreen")
    object MapDetail: Screen(route = "mapDetail")
    object Login: Screen(route = "loginScreen")

}
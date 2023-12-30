package com.example.studyspot.utilities.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.studyspot.modules.login.Login
import com.example.studyspot.modules.mapdetail.MapDetail
import com.example.studyspot.modules.signup.SignUp

@Composable
fun NavigationSetup(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.MapDetail.route
    ) {
        composable(
            route = Screen.SignUp.route
        ) {
            SignUp(navController = navController)
        }
        composable(
            route = Screen.MapDetail.route
        ) {
            MapDetail(navController = navController)
        }
        composable(
            route = Screen.Login.route
        ) {
            Login(navController = navController)
        }
    }
}
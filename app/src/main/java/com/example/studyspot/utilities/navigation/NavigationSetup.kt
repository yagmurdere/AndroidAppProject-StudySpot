package com.example.studyspot.utilities.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.studyspot.entities.RestaurantModel
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
            val dummyRestaurant = RestaurantModel(
                "Top Reastary",
                "10:00-24:00",
                "Yeni Çamlıca, M, Reşit Paşa Cd. No: 6, 34779 Ataşehir/İstanbul",
                true,
                true,
                true
            )
            MapDetail(navController = navController, restaurant = dummyRestaurant)
        }
        composable(
            route = Screen.Login.route
        ) {
            Login(navController = navController)
        }
    }
}
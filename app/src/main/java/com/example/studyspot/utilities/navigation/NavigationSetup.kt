package com.example.studyspot.utilities.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.studyspot.modules.contactusscreen.ContactUs
import com.example.studyspot.modules.privacyandpolicyscreen.PrivacyPolicy
import com.example.studyspot.modules.profileeditscreen.ProfilEditSayfasi
import com.example.studyspot.modules.profilescreen.ProfilSayfasi
import com.example.studyspot.modules.settingsscreen.AyarlarSayfasi
import com.example.studyspot.modules.login.Login
import com.example.studyspot.modules.mapdetail.MapDetail
import com.example.studyspot.modules.signup.SignUp

@Composable
fun NavigationSetup(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "profile"
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
            "mapdetail"
        ) {
            MapDetail(navController = navController)
        }
        composable(
            route = Screen.Login.route
        ) {
            Login(navController = navController)
        }
        composable(
            "profile"
        ){
            ProfilSayfasi(navController = navController)
        }
        composable(
            "profileedit"){
            ProfilEditSayfasi(navController = navController)

        }
        composable(
            "settings"){
            AyarlarSayfasi(navController = navController)

        }
        composable(
            "privacyandpolicy"){
            PrivacyPolicy(navController = navController)

        }
        composable(
            "contactus"){
            ContactUs(navController = navController)

        }

    }
}
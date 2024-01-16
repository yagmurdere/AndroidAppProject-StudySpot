package com.example.studyspot.utilities.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.studyspot.modules.Focus_Screen.pageController
import com.example.studyspot.modules.Map_Screen.MapMain
import com.example.studyspot.modules.Map_Screen.mapDetailViewModel
import com.example.studyspot.modules.contactusscreen.ContactUs
import com.example.studyspot.modules.privacyandpolicyscreen.PrivacyPolicy
import com.example.studyspot.modules.profileeditscreen.ProfilEditSayfasi
import com.example.studyspot.modules.profilescreen.ProfilSayfasi
import com.example.studyspot.modules.settingsscreen.AyarlarSayfasi
import com.example.studyspot.modules.login.Login
import com.example.studyspot.modules.mapdetail.MapDetail
import com.example.studyspot.modules.signup.SignUp
import com.example.studyspot.entities.RestaurantModel
import com.example.studyspot.modules.commentscreen.CommentScreen
import com.example.studyspot.modules.profilescreen.profileViewModel

@Composable
fun NavigationSetup(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
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
            MapDetail(
                navController = navController,
                restaurant = dummyRestaurant,
                "NnVIj0khJ64xrrxholu",
                "NnuQNKv7nTmCRZzRALM"
            )
        }

        composable(
            route = Screen.Login.route
        ) {
            Login(navController = navController)
        }
        composable(
            "profile"
        ){
            ProfilSayfasi(navController = navController, viewModel = profileViewModel())
        }
        composable(
            "profileedit"
        ){
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
        composable("focus"){
            pageController()
        }

        composable("map"){
            MapMain(mapDetailViewModel = mapDetailViewModel(), navController)
        }
        composable(Screen.Comment.route) {
            CommentScreen(navController = navController, "", "NnVIj0khJ64xrrxholu")
        }

    }

}

package com.example.studyspot.Focus_Screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun pageController(exerciseViewModel: exerciseViewModel= viewModel()){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "MainScreen" ){
        composable("MainScreen"){
            mainScreen(exercisesData = exerciseViewModel, navController =navController )
        }
        composable("DetailScreen/{index}",
            arguments = listOf(
                navArgument(name="index"){
                    type= NavType.IntType
                }
            )
        ){index->
            DetailScreen(exerciseViewModel,
                itemIndex = index.arguments?.getInt("index") ,
                navController=navController
            )
        }

    }

}
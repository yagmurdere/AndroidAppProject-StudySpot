package com.example.studyspot.FocusPage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun exercisesData() {
    val exerciseClass = remember { exerciseDataClass() }
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination =  "MainScreen"){
        composable("MainScreen"){
            myApp(exerciseClass,navController)
        }
        composable("DetailScreen/{index}",
            arguments = listOf(
                navArgument(name="index"){
                    type= NavType.IntType
                }
            )
        ){index->
            DetailScreen(photos = exerciseClass.imageId,
                names = exerciseClass.exerciseNames,
                definition = exerciseClass.definitons,
                itemIndex = index.arguments?.getInt("index") ,
                navController=navController
            )
        }


    }
}
package com.example.studyspot

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.studyspot.modules.navbar.BottomNavBar
import com.example.studyspot.modules.navbar.BottomNavItem
import com.example.studyspot.ui.theme.StudySpotTheme
import com.example.studyspot.utilities.navigation.NavigationSetup
import com.example.studyspot.utilities.navigation.Screen
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            StudySpotTheme {
                val navController = rememberNavController()

                StudySpotTheme {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            BottomNavBar(
                                items = listOf(
                                    BottomNavItem(
                                        name = "Focus",
                                        route = "focus",
                                        iconResId = R.drawable.focusicon
                                    ),
                                    BottomNavItem(
                                        name = "Mapmain",
                                        route = "map",
                                        iconResId = R.drawable.mapicon
                                    ),
                                    BottomNavItem(
                                        name = "Profile",
                                        route = "profile",
                                        iconResId = R.drawable.personicon
                                    )
                                ),
                                onItemClick = { navController.navigate(it.route) }
                            )
                        }
                    ) {
                        NavigationSetup(navController = navController)
                    }
                }
                }
            }
        }
        }




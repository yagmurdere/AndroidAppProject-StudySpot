package com.example.studyspot

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.studyspot.modules.contactusscreen.BottomNavBar
import com.example.studyspot.modules.contactusscreen.BottomNavItem
import com.example.studyspot.ui.theme.StudySpotTheme
import com.example.studyspot.utilities.navigation.NavigationSetup

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudySpotTheme {
                // A surface container using the 'background' color from the theme )
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationSetup(navController = rememberNavController())
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            BottomNavBar(items = listOf(
                                BottomNavItem(
                                    name = "ContactUs",
                                    route = "contactus",
                                    iconResId = R.drawable.focusicon
                                ),
                                BottomNavItem(
                                    name = "Mapdetail",
                                    route = "mapdetail",
                                    iconResId = R.drawable.mapicon
                                ),
                                BottomNavItem(
                                    name = "Profile",
                                    route = "profile",
                                    iconResId = R.drawable.personicon
                                )


                            ),
                                navController = navController,
                                onItemClick = {
                                    navController.navigate(it.route)
                                }
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
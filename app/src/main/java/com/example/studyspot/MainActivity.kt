package com.example.studyspot

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.rememberNavController
import com.example.studyspot.modules.bottomnavbar.BottomNav
import com.example.studyspot.ui.theme.StudySpotTheme


class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StudySpotTheme {
                val navController = rememberNavController()

                StudySpotTheme {
                    BottomNav()
                }
                }
            }
        }
        }




package com.example.studyspot.modules.bottomnavbar

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.studyspot.R
import com.example.studyspot.utilities.navigation.NavigationSetup
import com.example.studyspot.utilities.navigation.Screen

val semiTransparentColor = Color.White.copy(alpha = 0.3f)

sealed class BottomNavItem(
    val route: String,
    val icon: Int
){
    object pageController: BottomNavItem(
        route= "focus",
        icon= R.drawable.focusicon
    )
    object MapMain: BottomNavItem(
        route= "map",
        icon= R.drawable.mapicon
    )
    object ProfilSayfasi: BottomNavItem(
        route= "profile",
        icon= R.drawable.personicon
    )


}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNav(){
    val navController= rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController = navController) }
    ) {
        NavigationSetup(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController){
    val screens= listOf(
        BottomNavItem.pageController,
        BottomNavItem.MapMain,
        BottomNavItem.ProfilSayfasi,
    )

    val backstackEntryState = navController.currentBackStackEntryAsState()
    val backstackEntry = backstackEntryState.value

    val currentDestination = backstackEntry?.destination

    if (currentDestination?.route !in listOf(Screen.Login.route, Screen.SignUp.route)) {
        Row {
            Spacer(modifier = Modifier.size(50.dp))
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(semiTransparentColor)
                    .size(300.dp, 70.dp)
            ) {
                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(Color.Transparent)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){

                    screens.forEach{ screen ->
                        if (currentDestination != null) {
                            AddItem(screen = screen,
                                currentDestination = currentDestination,
                                navController = navController)
                        }
                    }
                }
            }
        }
    }






}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem,
    currentDestination: NavDestination,
    navController: NavHostController
){
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.Transparent)
            .clickable(onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            })
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .background(Color.Transparent),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(painter = painterResource(id = screen.icon),
                contentDescription = "",
                modifier = Modifier.size(30.dp),
                tint = Color.Unspecified
            )

        }

    }

}














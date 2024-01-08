package com.example.studyspot.modules.navbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.studyspot.ui.theme.navbarIconColor

data class BottomNavItem (
    val name: String,
    val route: String,
    val iconResId: Int
)
val semiTransparentColor = Color.White.copy(alpha = 0.3f)
@Composable
fun BottomNavBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit,

    ) {
    val backstackentery = navController.currentBackStackEntryAsState()


    Row() {
        Spacer(modifier = Modifier.size(50.dp))
        Box(
            modifier = Modifier
                .background(color = semiTransparentColor, shape = RoundedCornerShape(50.dp))
                .size(300.dp, 80.dp)
        ) {
            NavigationBar(
                modifier = Modifier
                    .size(250.dp, 60.dp)
                    .align(Alignment.Center),
                containerColor = Color.Transparent,
                tonalElevation = 5.dp
            ) {
                items.forEach { item ->
                    val selected = item.route == backstackentery.value?.destination?.route
                    NavigationBarItem(

                        selected = selected,
                        onClick = { onItemClick(item) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = navbarIconColor,
                            unselectedIconColor = navbarIconColor
                        ),
                        icon = {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Box() {
                                    val alpha = if (selected) 1f else 0.6f
                                    Icon(
                                        painter = painterResource(id = item.iconResId),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .alpha(alpha)
                                            .size(20.dp)
                                    )
                                }
                            }
                        })
                }
            }
        }

    }
}

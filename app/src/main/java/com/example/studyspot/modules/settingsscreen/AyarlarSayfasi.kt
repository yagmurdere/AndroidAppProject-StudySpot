package com.example.studyspot.modules.settingsscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.studyspot.R
import com.example.studyspot.modules.navbar.BottomNavBar
import com.example.studyspot.modules.navbar.BottomNavItem
import com.example.studyspot.ui.theme.newfontfamily
import com.example.studyspot.utilities.navigation.Screen


@Composable
fun AyarlarSayfasi(navController: NavController) {
    

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.settings_background),
                contentScale = ContentScale.FillBounds
            )

    ) {

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(onClick = { navController.navigate("profile") }) {
                            Icon(
                                painter = painterResource(id = R.drawable.backicon),
                                contentDescription = "back to profile", tint = Color.White
                            )
                        }
                    }
                    Spacer(modifier = Modifier.padding(35.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        Text(
                            text = "Settings",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 40.sp,
                            fontFamily = newfontfamily
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.padding(20.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(50.dp)
                    .padding(start = 26.dp, end = 26.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                colorResource(id = R.color.focusCardBG2).copy(alpha = 0.5f),
                                colorResource(id = R.color.focusCardBG1).copy(alpha = 0.5f)
                            )
                        ),
                        shape = RoundedCornerShape(6.dp)
                    )
                    .border(
                        0.5.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(6.dp)
                    ))
            {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 10.dp,
                                top = 10.dp,
                                bottom = 15.dp,
                                end = 10.dp
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {


                        Text(
                            text = "Light Mode",
                            color = colorResource(id = R.color.ProfileTextColor),
                            fontSize = 15.sp,
                            textAlign = TextAlign.Left,
                            fontFamily = newfontfamily,
                            fontWeight = FontWeight.Bold

                        )
                        /**/
                        @Composable
                        fun ModesIconToggle() {
                            val checkState = remember { mutableStateOf(false) }
                            IconToggleButton(checked = checkState.value, onCheckedChange = {
                                checkState.value = !checkState.value

                            }) {
                                Icon(
                                    painter = if (checkState.value) {
                                        painterResource(id = R.drawable.toggle_on_button)
                                    } else {
                                        painterResource(id = R.drawable.toggle_off_button)
                                    }, contentDescription = " ", tint = colorResource(id = R.color.buttoncolor)
                                )

                            }
                        }
                        ModesIconToggle()

                    }

                }

            }


            Spacer(modifier = Modifier.padding(15.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(50.dp)
                    .padding(start = 26.dp, end = 26.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                colorResource(id = R.color.focusCardBG2).copy(alpha = 0.5f),
                                colorResource(id = R.color.focusCardBG1).copy(alpha = 0.5f)
                            )
                        ),
                        shape = RoundedCornerShape(6.dp)
                    )
                    .border(
                        0.5.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(6.dp)
                    )
                    .clickable { navController.navigate("privacyandpolicy") }

            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 10.dp,
                                top = 10.dp,
                                bottom = 15.dp,
                                end = 10.dp
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "Privacy & Policy",
                            color = colorResource(id = R.color.ProfileTextColor),
                            fontSize = 15.sp,
                            textAlign = TextAlign.Left,
                            fontFamily = newfontfamily,
                            fontWeight = FontWeight.Bold

                        )


                    }
                }
            }

            Spacer(modifier = Modifier.padding(15.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(50.dp)
                    .padding(start = 26.dp, end = 26.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                colorResource(id = R.color.focusCardBG2).copy(alpha = 0.5f),
                                colorResource(id = R.color.focusCardBG1).copy(alpha = 0.5f)
                            )
                        ),
                        shape = RoundedCornerShape(6.dp)
                    )
                    .border(
                        0.5.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(6.dp)
                    )
                    .clickable { navController.navigate("contactus") }
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 10.dp,
                                top = 10.dp,
                                bottom = 15.dp,
                                end = 10.dp
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "Contact Us",
                            color = colorResource(id = R.color.ProfileTextColor),
                            fontSize = 15.sp,
                            textAlign = TextAlign.Left,
                            fontFamily = newfontfamily,
                            fontWeight = FontWeight.Bold
                        )

                    }

                }
            }
            Spacer(modifier = Modifier.padding(15.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(50.dp)
                    .padding(start = 26.dp, end = 26.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                colorResource(id = R.color.focusCardBG2).copy(alpha = 0.5f),
                                colorResource(id = R.color.focusCardBG1).copy(alpha = 0.5f)
                            )
                        ),
                        shape = RoundedCornerShape(6.dp)
                    )
                    .border(
                        0.5.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(6.dp)
                    )
                    .clickable { navController.navigate(Screen.Login.route)}
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 10.dp,
                                top = 10.dp,
                                bottom = 15.dp,
                                end = 10.dp
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "Log Out",
                            color = colorResource(id = R.color.ProfileTextColor),
                            fontSize = 15.sp,
                            textAlign = TextAlign.Left,
                            fontFamily = newfontfamily,
                            fontWeight = FontWeight.Bold

                        )

                    }

                }
            }
        }


    }


}
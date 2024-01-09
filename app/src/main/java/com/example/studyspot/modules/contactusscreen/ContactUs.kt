package com.example.studyspot.modules.contactusscreen

import  android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studyspot.R
import com.example.studyspot.modules.navbar.BottomNavBar
import com.example.studyspot.modules.navbar.BottomNavItem
import com.example.studyspot.ui.theme.text1


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactUs(navController: NavController) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.contactusbackground),
            contentDescription = "",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.size(20.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    IconButton(onClick = {navController.navigate("settings") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.backicon),
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(30.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Contact Us",
                        fontSize = 30.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                }
                Spacer(modifier = Modifier.padding(55.dp))

            }

            Spacer(modifier = Modifier.size(10.dp))

            Box(
                modifier = Modifier.size(400.dp, 60.dp),
                Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.contactusbox),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
                Text(
                    text = "studyspot@gmail.com",
                    modifier = Modifier.padding(bottom = 10.dp),
                    color = text1
                )
            }

            Spacer(modifier = Modifier.size(10.dp))

            Box(
                modifier = Modifier.size(400.dp, 60.dp),
                Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.contactusbox),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
                Text(
                    text = "+05439876521",
                    modifier = Modifier.padding(bottom = 10.dp),
                    color = text1
                )
            }

            Spacer(modifier = Modifier.size(10.dp))

            Box(
                modifier = Modifier.size(400.dp, 60.dp),
                Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.contactusbox),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
                Text(
                    text = "New York, Central Park, No:123",
                    modifier = Modifier.padding(bottom = 10.dp),
                    color = text1
                )
            }
//bu column u alıp sayfanızdaki column un en altına koyabilirsiniz
            Column(modifier = Modifier.fillMaxWidth()
                .weight(1f), //alta gitmesi için aradaki boşluğu dolduruyor
                verticalArrangement = Arrangement.Bottom) {
                BottomNavBar(items =listOf(
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
                )
                    ,
                    navController = navController,
                    onItemClick = {navController.navigate(it.route)})
                //bu son iki kısımda hata alırsanız silip aynılarını kendiniz yazmayı deneyin oluyor
            }



        }

    }
   

    




}






package com.example.studyspot.SettingsPage

import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studyspot.ProfilePage.SayfaGecisleri
import com.example.studyspot.R
import com.example.studyspot.ui.theme.StudySpotTheme

@Composable
fun AyarlarSayfasi(navController: NavController){
    Column(modifier = Modifier
        .paint(
            painterResource(id = R.drawable.settings_page_background),
            contentScale = ContentScale.FillBounds
        )
        .fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                Column() {
                    IconButton(onClick = { navController.navigate("profile") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.back_icon),
                            contentDescription = "back to profile",tint = Color.White)
                    }

                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Settings",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp
                    )
                }


            }
        }






        Spacer(modifier = Modifier.padding(20.dp))

        Column(horizontalAlignment =Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween) {


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(50.dp)
                    .padding(start = 26.dp, end = 26.dp)
                    .background(
                        colorResource(id = R.color.boxcolor).copy(alpha = 0.3f),
                        shape = MaterialTheme.shapes.medium
                    )

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
                            text = "Light Mode",
                            color = colorResource(id = R.color.maincolor_text),
                            fontSize = 15.sp,
                            textAlign = TextAlign.Left

                        )

                        ModesIconToggle()

                    }

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
                    colorResource(id = R.color.boxcolor).copy(alpha = 0.3f),
                    shape = MaterialTheme.shapes.medium
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
                        color = colorResource(id = R.color.maincolor_text),
                        fontSize = 15.sp,
                        textAlign = TextAlign.Left

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
                    colorResource(id = R.color.boxcolor).copy(alpha = 0.3f),
                    shape = MaterialTheme.shapes.medium
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
                        color = colorResource(id = R.color.maincolor_text),
                        fontSize = 15.sp,
                        textAlign = TextAlign.Left

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
                    colorResource(id = R.color.boxcolor).copy(alpha = 0.3f),
                    shape = MaterialTheme.shapes.medium
                )
                .clickable { navController.navigate("logout") }
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
                        color = colorResource(id = R.color.maincolor_text),
                        fontSize = 15.sp,
                        textAlign = TextAlign.Left

                    )

                }

            }
        }
    }




}



@Composable
fun ModesIconToggle(){
    val checkState= remember{ mutableStateOf(false) }
    IconToggleButton(checked = checkState.value, onCheckedChange = {
        checkState.value = !checkState.value

    }) {
        Icon(painter = if (checkState.value){
            painterResource(id = R.drawable.toggle_on)} else {
            painterResource(id = R.drawable.toggle_off)}, contentDescription =" " , tint = Color.White )

    }
}



@Composable
fun AyarlarSayfasiPreview(){
    StudySpotTheme {
        SayfaGecisleri()
    }

}
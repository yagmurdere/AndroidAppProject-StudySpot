package com.example.studyspot.modules.profilescreen

import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.studyspot.R
import com.example.studyspot.ui.theme.StudySpotTheme
import com.example.studyspot.utilities.navigation.NavigationSetup




@Composable
fun ProfilSayfasi(navController: NavController) {

    Column(Modifier.paint(painterResource(id = R.drawable.profile_background), contentScale = ContentScale.FillBounds))
    {
        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.End) {
            IconButton(onClick = {navController.navigate("settings")

                Log.d("Navigation", "Settings button clicked")
            }) {
                Icon(painter = painterResource(id = R.drawable.icon_settings), contentDescription = "goto settings page ")
            }
        }
        Column(
            Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_img),
                contentDescription = "Profile Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .border(3.dp, Color.Blue, CircleShape)
            )
            Text(text = "John Doe", modifier = Modifier.padding(all = 10.dp), fontSize = 40.sp, color=Color.White)
            TextButton(onClick = { navController.navigate("profileedit") }) {
                Text(text = "Edit Profile")
            }
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 26.dp, end = 26.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(
                        brush = Brush
                            .verticalGradient(
                                colors = listOf(
                                    colorResource(id = R.color.focusCardBG2).copy(alpha = 0.5f),
                                    colorResource(id = R.color.focusCardBG1).copy(alpha = 0.5f)
                                )
                            )
                    )
                    .border(0.5.dp, color = Color.White, shape = RoundedCornerShape(15.dp)

                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, top = 10.dp, bottom = 10.dp)
                    ) {
                        Text(
                            text = "Fav Places",
                            color = colorResource(id = R.color.ProfileTextColor),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, top = 30.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Depo", color = Color.Black, fontSize = 13.sp)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, top = 48.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Kafein", color = Color.Black, fontSize = 13.sp)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, top = 66.dp, bottom = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Fine Arts Building", color = Color.Black, fontSize = 13.sp)
                }
            }
            /***********************************************************************/
            Column(
                Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, top = 15.dp, bottom = 15.dp)
                ) {
                    Text(
                        text = "Comment History",
                        color = colorResource(id = R.color.ProfileTextColor),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            val itemList=(1..4).map {}
            //boxList olusturdum
            LazyColumn(modifier= Modifier
                .fillMaxSize()
                .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {items(itemList) { item ->

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(
                            brush = Brush
                                .verticalGradient(
                                    colors = listOf(
                                        colorResource(id = R.color.focusCardBG2).copy(alpha = 0.5f),
                                        colorResource(id = R.color.focusCardBG1).copy(alpha = 0.5f)
                                    )
                                )
                        )
                        .border(0.5.dp, color = Color.White, shape = RoundedCornerShape(15.dp)))

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
                                text = "John Doe",
                                color = colorResource(id = R.color.ProfileTextColor),
                                fontSize = 13.sp,
                                textAlign = TextAlign.Left

                            )

                            var myRating by remember { mutableStateOf(2) }
                            @Composable
                            fun RatingBar(
                                maxRating: Int=5,
                                currentRating:Int,
                                onRatingChanged: (Int) -> Unit,

                                ) {

                                Row() {
                                    for (i in 1..5) {
                                        Icon(
                                            imageVector = if (i <= currentRating) Icons.Filled.Star
                                            else Icons.Outlined.Star,
                                            contentDescription = null,
                                            tint = if (i <= currentRating) Color.Yellow
                                            else Color.Unspecified,
                                            modifier = Modifier
                                                .clickable { onRatingChanged(i) }
                                                .padding(4.dp)

                                        )
                                    }
                                }
                            }

                            RatingBar(
                                currentRating = myRating,
                                onRatingChanged = { myRating = it }
                            )
                        }
                        Box(modifier = Modifier.fillMaxWidth()) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp, end = 10.dp, bottom = 15.dp)
                            ) {
                                Text(
                                    text = "Müzik çok yüksekti ama kahve inanılmazdı.",
                                    fontSize = 13.sp
                                )
                            }

                        }
                    }
                }
                Spacer(modifier = Modifier.size(10.dp))




            }


            }


        }





    }
}














@Composable
@Preview(showBackground = true)
fun ProfilSayfasiPreview() {
    StudySpotTheme {
        NavigationSetup(navController = rememberNavController())}}












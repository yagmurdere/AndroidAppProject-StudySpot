package com.example.studyspot.ProfilePage

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.studyspot.ContactUsPage.ContactUs
import com.example.studyspot.PrivacyAndPolicyPage.PrivacyPolicy
import com.example.studyspot.R
import com.example.studyspot.SettingsPage.AyarlarSayfasi
import com.example.studyspot.ui.theme.StudySpotTheme



@Composable
fun SayfaGecisleri(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination ="profile") {
        composable("profile") {
            ProfilSayfasi(navController = navController)
        }
        composable("settings"){
            AyarlarSayfasi(navController = navController)
        }
        composable("privacyandpolicy"){
            PrivacyPolicy(navController = navController)
        }
        composable("contactus"){
            ContactUs(navController = navController)
        }
    }

    }



@Composable
fun ProfilSayfasi(navController: NavController) {

    Column(Modifier.paint(painterResource(id = R.drawable.profile_page_background), contentScale = ContentScale.FillBounds))
    {
        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.End) {
            IconButton(onClick = {navController.navigate("settings")
                Log.d("Navigation", "Settings button clicked") }) {
                Icon(painter = painterResource(id = R.drawable.settings_icon), contentDescription = "goto settings page ", tint = Color.White)
            }
        }
        Column(
            Modifier
                .fillMaxWidth()
                .padding(30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_image),
                contentDescription = "Profile Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .border(3.dp, Color.Blue, CircleShape)
            )
            Text(text = "John Doe", modifier = Modifier.padding(all = 10.dp), fontSize = 40.sp, color=Color.White)
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 26.dp, end = 26.dp)
                    .background(
                        colorResource(id = R.color.boxcolor).copy(alpha = 0.3f),
                        shape = MaterialTheme.shapes.medium
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
                            text = "Favorite Places",
                            color = colorResource(id = R.color.maincolor_text),
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
                    Text(text = "Fine Arts Building", color = Black, fontSize = 13.sp)
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
                        color = colorResource(id = R.color.maincolor_text),
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
                        .background(
                            colorResource(id = R.color.boxcolor).copy(alpha = 0.3f),
                            shape = MaterialTheme.shapes.medium
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
                                text = "John Doe",
                                color = colorResource(id = R.color.maincolor_text),
                                fontSize = 13.sp,
                                textAlign = TextAlign.Left

                            )
                            var myRating by remember { mutableStateOf(2) }
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
fun RatingBar(
    maxRating: Int = 5,
    currentRating: Int,
    onRatingChanged: (Int) -> Unit,
    starsColor: Color = Color.Yellow
) {
    Row() {
        for (i in 1..maxRating) {
            Icon(
                imageVector = if (i <= currentRating) Icons.Filled.Star
                else Icons.Outlined.Star,
                contentDescription = null,
                tint = if (i <= currentRating) starsColor
                else Color.Unspecified,
                modifier = Modifier
                    .clickable { onRatingChanged(i) }
                    .padding(4.dp)

            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProfilePreview() {

    StudySpotTheme {
        SayfaGecisleri()

    }
}

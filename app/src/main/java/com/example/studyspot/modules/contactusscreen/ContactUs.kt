package com.example.studyspot.modules.contactusscreen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.studyspot.ui.theme.text1


@Composable
fun ContactUs(name: String, modifier: Modifier = Modifier,
              navController: NavController) {
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

        }
    }
}

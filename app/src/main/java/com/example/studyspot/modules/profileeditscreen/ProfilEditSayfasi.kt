package com.example.studyspot.modules.profileeditscreen

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.studyspot.R
import com.example.studyspot.ui.theme.StudySpotTheme
import com.example.studyspot.utilities.navigation.NavigationSetup

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilEditSayfasi(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.profile_edit_background),
                contentScale = ContentScale.FillBounds
            ))
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),

                horizontalAlignment = Alignment.End
            ) {
                IconButton(onClick = {
                    navController.navigate("settings")
                    Log.d("Navigation", "Settings button clicked")
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_settings),
                        contentDescription = "goto settings page ",
                        tint = Color.White
                    )
                }
            }
        }

        var isEditing by remember { mutableStateOf(true) }


        Column(
            Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .clickable { isEditing = !isEditing }) {
                if (isEditing) {
                    Icon(
                        painter = painterResource(id = R.drawable.profileimgedit),
                        contentDescription = " ",
                        modifier = Modifier
                            .size(40.dp)
                            .padding(4.dp)
                            .align(Alignment.Center)

                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.profile_img),
                    contentDescription = "Profile Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .border(
                            width = 4.dp,
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    colorResource(id = R.color.Profileimgbordercolor),
                                    Color.Blue
                                ), // You can customize the gradient colors
                                start = Offset(0f, 170f),
                                end = Offset(170f, 480f)
                            ),
                            shape = CircleShape

                        )
                )

            }


            var name by remember {
                mutableStateOf("John Doe")
            }


            BasicTextField(
                value = name,
                onValueChange = {
                    name = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp, start = 26.dp, end = 26.dp),
                textStyle = TextStyle(
                    color = Color.White,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ),
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier
                            .background(
                                color = Color.Transparent,
                                shape = RoundedCornerShape(6.dp)
                            )
                            .border(
                                1.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(6.dp)
                            )
                            .height(60.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        innerTextField()
                    }
                },
                cursorBrush = SolidColor(Color.White)
            )
        }

        Column (modifier = Modifier
            .background(color = Color.Transparent)
            .border(
                1.dp,
                color = Color.White,
                shape = RoundedCornerShape(6.dp)
            )){


            Column(
                modifier = Modifier.padding(start = 40.dp, end = 40.dp, bottom = 15.dp)
            )
            {
                Row {
                    Text(
                        text = "E-mail", color = colorResource(id = R.color.ProfileTextColor),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                var email by remember {
                    mutableStateOf("john.doe@gmail.com")
                }

                BasicTextField(
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    textStyle = TextStyle(color = Color.Black),
                    decorationBox = { innerTextField ->
                        Row(
                            modifier = Modifier
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
                                    0.dp,
                                    color = Color.White,
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .height(50.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Spacer(modifier = Modifier.width(width = 5.dp))
                            innerTextField()
                        }
                    },
                    cursorBrush = SolidColor(Color.White)
                )

                Row {
                    Text(
                        text = "Change Password",
                        color = colorResource(id = R.color.ProfileTextColor),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row {
                    Text(
                        text = "Old Passsword", color = Color.Black,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )

                }

                var oldpassword by remember {
                    mutableStateOf("**********")
                }
                BasicTextField(
                    value = oldpassword,
                    onValueChange = {
                        oldpassword = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    textStyle = TextStyle(color = Color.Black),
                    decorationBox = { innerTextField ->
                        Row(
                            modifier = Modifier
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
                                    0.dp,
                                    color = Color.White,
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .height(50.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Spacer(modifier = Modifier.width(width = 5.dp))
                            innerTextField()
                        }
                    },
                    cursorBrush = SolidColor(Color.White)
                )

                Row {
                    Text(
                        text = "New Passsword", color = Color.Black,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                BasicTextField(
                    value = " ",
                    onValueChange = {

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    textStyle = TextStyle(color = Color.Black),
                    decorationBox = { innerTextField ->
                        Row(
                            modifier = Modifier
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
                                    0.dp,
                                    color = Color.White,
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .height(50.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Spacer(modifier = Modifier.width(width = 5.dp))
                            innerTextField()
                        }
                    },
                    cursorBrush = SolidColor(Color.White)
                )
                Row {
                    Text(
                        text = "New Passsword", color = Color.Black,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                BasicTextField(
                    value = " ",
                    onValueChange = {

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    textStyle = TextStyle(color = Color.Black),
                    decorationBox = { innerTextField ->
                        Row(
                            modifier = Modifier
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
                                    0.dp,
                                    color = Color.White,
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .height(50.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {

                            innerTextField()
                        }
                    },
                    cursorBrush = SolidColor(Color.White)
                )

                Button(onClick = { /*TODO*/ }, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                colorResource(id = R.color.profileeditbuttoncolor).copy(alpha = 0.3f),

                                ),

                            ),

                        shape = RoundedCornerShape(6.dp)
                    ),
                ) {
                    Text(text = "Save")

                }

            }
        }
    }

}

@Composable
fun ProfilEditPreview(){
    StudySpotTheme {
        NavigationSetup(navController = rememberNavController())
    }
}




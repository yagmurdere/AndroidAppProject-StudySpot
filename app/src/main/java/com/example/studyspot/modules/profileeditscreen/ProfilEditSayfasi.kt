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
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.studyspot.R
import com.example.studyspot.modules.login.GradientButton
import com.example.studyspot.ui.theme.StudySpotTheme
import com.example.studyspot.ui.theme.color1
import com.example.studyspot.ui.theme.color2
import com.example.studyspot.ui.theme.newfontfamily
import com.example.studyspot.utilities.navigation.NavigationSetup

@Composable

fun ProfilEditSayfasi(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.profile_edit_background),
                contentScale = ContentScale.FillBounds
            )
    )
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

        val backgroundBrush = Brush.verticalGradient(
            colors = listOf(
                colorResource(id = R.color.boxblurr).copy(alpha = 0.3f),
                colorResource(id = R.color.boxblurr2).copy(alpha = 0.3f)
            )
        )



        var name by remember {
            mutableStateOf("John Doe")
        }
        var email by remember {
            mutableStateOf("john.doe@gmail.com")
        }
        var oldpassword by remember {
            mutableStateOf("**********")
        }
        var isEditing by remember { mutableStateOf(true) }

        var lastSelectedAvatar by remember { mutableStateOf(R.drawable.avatar_man) }


        LaunchedEffect(isEditing) {
            lastSelectedAvatar = if (isEditing) {
                R.drawable.avatar_man
            } else {
                R.drawable.avatar_women
            }
        }



        Column(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp, horizontal = 15.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .clickable { isEditing = !isEditing }) {
                if (isEditing) {
                    Image(
                        painter = painterResource(id = lastSelectedAvatar),
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
                                    ),
                                    start = Offset(0f, 170f),
                                    end = Offset(170f, 480f)
                                ),
                                shape = CircleShape

                            )
                    )

                }
                    else{
                    Image(
                        painter = painterResource(id = R.drawable.avatar_women),
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
                                    ),
                                    start = Offset(0f, 170f),
                                    end = Offset(170f, 480f)
                                ),
                                shape = CircleShape

                            )
                    )

                    }




            }


            BasicTextField(
                value = name,
                onValueChange = {
                    name = it
                },
                modifier = Modifier
                    .padding(top = 15.dp, bottom=15.dp),
                textStyle = TextStyle(
                    color = Color.White,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = newfontfamily,

                ),
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier
                            .background(
                                brush = backgroundBrush, shape = RoundedCornerShape(6.dp)
                            )
                            .border(
                                1.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(6.dp)
                            )

                            .height(45.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly

                    ) {

                        innerTextField()
                    }
                },
                cursorBrush = SolidColor(Color.White),

            )
        }




        Column( modifier = Modifier
            .fillMaxHeight()
            .padding(0.dp)
            .border(1.dp, color = Color.White, shape = RoundedCornerShape(20.dp))
            .background(
                brush = backgroundBrush, shape = RoundedCornerShape(20.dp)
            )
        ) {

            Column(
                modifier = Modifier.padding(horizontal = 35.dp, vertical = 10.dp),
                horizontalAlignment = Alignment.Start
            ) {


                Row {
                    Text(
                        text = "E-mail", color = colorResource(id = R.color.ProfileTextColor),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = newfontfamily,
                    )
                }


                BasicTextField(
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    textStyle = TextStyle(color = Color.Black, fontFamily = newfontfamily),
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
                                .height(40.dp),
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
                        modifier = Modifier.padding(top = 15.dp),
                        text = "Change Password",
                        color = colorResource(id = R.color.ProfileTextColor),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = newfontfamily,
                    )
                }
                Row {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "Old Passsword", color = Color.Black,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = newfontfamily
                    )

                }

                BasicTextField(
                    value = oldpassword,
                    onValueChange = {
                        oldpassword = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    textStyle = TextStyle(color = Color.Black, fontFamily = newfontfamily),
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
                                .height(35.dp),
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
                        modifier = Modifier.padding(5.dp),
                        text = "New Passsword", color = Color.Black,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = newfontfamily,
                    )
                }

                BasicTextField(
                    value = " ",
                    onValueChange = {

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    textStyle = TextStyle(color = Color.Black, fontFamily = newfontfamily),
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
                                .height(35.dp),
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
                        modifier = Modifier.padding(5.dp),
                        text = "New Passsword", color = Color.Black,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = newfontfamily,
                    )
                }

                BasicTextField(
                    value = " ",
                    onValueChange = {

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    textStyle = TextStyle(color = Color.Black, fontFamily = newfontfamily,),
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
                                .height(35.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {

                            innerTextField()
                        }
                    },
                    cursorBrush = SolidColor(Color.White)
                )

            }
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GradientButton(
                    text = "Save",
                    textColor = Color.White,
                    gradient = Brush.verticalGradient(
                        colors = listOf(
                            color2,
                            color1,
                            color1
                        )
                    ),
                    navController =  navController
                )

            }
        }

    }

    }


@Composable
fun ButtonGradient(
    text: String,
    textColor: Color,
    gradient: Brush,
    onClick: () -> Unit
){
    Button(onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        )
    ) {
        Box(modifier = Modifier
            .background(gradient, shape = MaterialTheme.shapes.extraLarge)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .size(80.dp, 30.dp)
        )
        {
            Text(text = text, color= textColor,
                fontFamily = newfontfamily,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.align(alignment = Alignment.Center)
            )
        }
    }
}





@Preview(showBackground = true)
@Composable
fun ProfilEditSayfasi(){
    StudySpotTheme {
        NavigationSetup(navController = rememberNavController())
    }
}




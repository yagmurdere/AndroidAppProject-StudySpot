package com.example.studyspot.modules.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studyspot.R
import com.example.studyspot.ui.theme.color1
import com.example.studyspot.ui.theme.color2
import com.example.studyspot.ui.theme.newfontfamily
import com.example.studyspot.ui.theme.signupcolor
import com.example.studyspot.utilities.navigation.Screen

val semiTransparentColor = Color.White.copy(alpha = 0.3f)

@Composable
fun GradientButton(
    text: String,
    textColor: Color,
    gradient: Brush,
    navController: NavController
){
    Button(onClick = {},
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
@Composable
fun Login(navController: NavController) {
    var emailText by remember { mutableStateOf(TextFieldValue("")) }
    var passwordText by remember { mutableStateOf(TextFieldValue("")) }
    val customSpacerHeight = LocalConfiguration.current.screenHeightDp * 0.20

    Box {
        Image(
            painter = painterResource(id = R.drawable.backgroundlogin),
            contentDescription = "",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(modifier = Modifier.size(30.dp))

            Text(
                text = "Welcome!",
                fontSize = 50.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontFamily = newfontfamily,
                modifier = Modifier.padding(10.dp)
            )
            Column(horizontalAlignment = Alignment.Start)

            {
                Text(
                    text = "E-mail", fontSize = 18.sp,
                    color = Color.White,
                    fontFamily = newfontfamily,
                    modifier = Modifier.padding(10.dp)
                )

                BasicTextField(
                    value = emailText,
                    onValueChange = { newText ->
                        emailText = newText
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 4.dp),
                    textStyle = TextStyle(color = Color.White),
                    decorationBox = { innerTextField ->
                        Row(
                            modifier = Modifier
                                .background(
                                    semiTransparentColor,
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
                            Spacer(modifier = Modifier.width(width = 16.dp))
                            innerTextField()
                        }
                    },
                    cursorBrush = SolidColor(Color.White)
                )
            }

            Spacer(modifier = Modifier.size(10.dp))

            Column {

                Text(
                    text = "Password", fontSize = 18.sp,
                    color = Color.White,
                    fontFamily = newfontfamily,
                    modifier = Modifier.padding(10.dp)
                )

                BasicTextField(
                    value = passwordText,
                    onValueChange = { newText ->
                        passwordText = newText
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 4.dp),
                    textStyle = TextStyle(color = Color.White),
                    decorationBox = { innerTextField ->
                        Row(
                            modifier = Modifier
                                .background(
                                    semiTransparentColor,
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

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Not a member?", fontSize = 14.sp,
                        fontFamily = newfontfamily,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                    )
                    Surface(
                        modifier = Modifier.clickable{navController.navigate(Screen.SignUp.route) },
                        color = Color.Transparent
                    ) {
                        Text(
                            text = "Sign up!",
                            color = signupcolor,
                            fontSize = 14.sp,
                            fontFamily = newfontfamily
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.size(10.dp))

            GradientButton(
                text = "Sign In",
                textColor = Color.White,
                gradient = Brush.verticalGradient(
                    colors = listOf(
                        color2,
                        color1,
                        color1
                    )
                ),
                navController = navController
            )
            Spacer(modifier = Modifier.size(40.dp))

            Spacer(modifier = Modifier.height(customSpacerHeight.dp))
            Image(
                painter = painterResource(id = R.drawable.studyspotlogo),
                contentDescription = "LogoImage",
                modifier = Modifier
                    .width(89.dp)
                    .height(22.dp),
            )
        }







    }

}

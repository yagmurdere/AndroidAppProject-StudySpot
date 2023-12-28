package com.example.studyspot.modules.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyspot.R
import com.example.studyspot.ui.theme.StudySpotTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import org.w3c.dom.Text
import java.time.format.TextStyle

@OptIn(ExperimentalMaterial3Api::class, ExperimentalTextApi::class)
@Composable
fun SignUp() {
    val customScreenWidth = LocalConfiguration.current.screenWidthDp * 0.75


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.signupbackgoud),
            contentDescription = "BackgorundImage",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                createText(
                    fontSize = 45,
                    text = "Let's Start.",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 50.dp)
                )
                Column(
                    modifier = Modifier.width(customScreenWidth.dp)
                ) {
                    inputComponent()
                }
            }

        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun inputComponent() {
    var nameText by remember { mutableStateOf(TextFieldValue("")) }
    var surnameText by remember { mutableStateOf(TextFieldValue("")) }
    var eMailText by remember { mutableStateOf(TextFieldValue("")) }
    var passwordText by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPasswordText by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    createText(
        fontSize = 15,
        text = "Name",
        fontWeight = FontWeight.Medium,
        modifier = Modifier
    )
    TextField(
        value = nameText,
        onValueChange = { newText ->
            nameText = newText
        },
        modifier = Modifier.height(40.dp),
        textStyle = androidx.compose.ui.text.TextStyle().copy(
            fontSize = 14.sp
        )
    )

    createText(
        fontSize = 15,
        text = "Surname",
        fontWeight = FontWeight.Medium,
        modifier = Modifier
    )

    TextField(
        value = surnameText,
        onValueChange = { newText ->
            surnameText = newText
        }
    )

    createText(
        fontSize = 15,
        text = "E-mail",
        fontWeight = FontWeight.Medium,
        modifier = Modifier
    )

    TextField(
        value = eMailText,
        onValueChange = { newText ->
            eMailText = newText
        }
    )

    createText(
        fontSize = 15,
        text = "Password",
        fontWeight = FontWeight.Medium,
        modifier = Modifier
    )

    TextField(
        value = passwordText,
        onValueChange = { newText ->
            passwordText = newText
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )

    createText(
        fontSize = 15,
        text = "Confirm Password",
        fontWeight = FontWeight.Medium,
        modifier = Modifier
    )

    TextField(
        value = confirmPasswordText,
        onValueChange = { newText ->
            confirmPasswordText = newText
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )

    Button(onClick = {

    }) {
        Text("Sign Up")
    }
}
@Composable
fun createText(
    fontSize: Int,
    text: String,
    fontWeight: FontWeight,
    modifier: Modifier
) {
     Text(
        text = text,
        color = Color.White,
        fontSize = fontSize.sp,
        fontWeight = fontWeight,
        modifier = modifier
    )
}

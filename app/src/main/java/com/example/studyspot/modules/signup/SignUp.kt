package com.example.studyspot.modules.signup

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.studyspot.R
import com.example.studyspot.utilities.errors.FireBaseError
import com.example.studyspot.utilities.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(navController: NavController) {
    val customScreenWidth = LocalConfiguration.current.screenWidthDp * 0.75
    val context = LocalContext.current
    val navController = rememberNavController()
    val currentDestination = navController.currentDestination?.route

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
                    modifier = Modifier.padding(vertical = 50.dp),
                    color = Color.White
                )
                Column(
                    modifier = Modifier.width(customScreenWidth.dp)
                ) {
                    inputComponent(navController, context)
                }
            }

        }
    }
}
val semiTransparentColor = Color.White.copy(alpha = 0.3f)

@ExperimentalMaterial3Api
@Composable
fun inputComponent(navController: NavController, context: Context) {
    var nameText by remember { mutableStateOf(TextFieldValue("")) }
    var surnameText by remember { mutableStateOf(TextFieldValue("")) }
    var eMailText by remember { mutableStateOf(TextFieldValue("")) }
    var passwordText by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPasswordText by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val viewModel: SignUpViewModel = SignUpViewModel()
    var checkBoxState by remember { mutableStateOf(false) }
    val customSpacerHeight = LocalConfiguration.current.screenHeightDp * 0.20

    createText(
        fontSize = 15,
        text = "Name",
        fontWeight = FontWeight.Medium,
        modifier = Modifier,
        color = Color.White
    )

    BasicTextField(
        value = nameText,
        onValueChange = { newText ->
            nameText = newText
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 4.dp),
        textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .background(
                        semiTransparentColor,
                        shape = RoundedCornerShape(6.dp)
                    )
                    .border(0.dp, color = Color.White, shape = RoundedCornerShape(6.dp))
                    .height(42.dp),
            verticalAlignment = Alignment.CenterVertically,
            ) {
            Spacer(modifier = Modifier.width(width = 16.dp))
            innerTextField()
        }
        },
        cursorBrush = SolidColor(Color.White)
    )

    createText(
        fontSize = 15,
        text = "Surname",
        fontWeight = FontWeight.Medium,
        modifier = Modifier,
        color = Color.White
    )

    BasicTextField(
        value = surnameText,
        onValueChange = { newText ->
            surnameText = newText
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 4.dp),
        textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .background(
                        semiTransparentColor,
                        shape = RoundedCornerShape(6.dp)
                    )
                    .border(0.dp, color = Color.White, shape = RoundedCornerShape(6.dp))
                    .height(42.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Spacer(modifier = Modifier.width(width = 16.dp))
                innerTextField()
            }
        },
        cursorBrush = SolidColor(Color.White)
    )

    createText(
        fontSize = 15,
        text = "E-mail",
        fontWeight = FontWeight.Medium,
        modifier = Modifier,
        color = Color.White
    )

    BasicTextField(
        value = eMailText,
        onValueChange = { newText ->
            eMailText = newText
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 4.dp),
        textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .background(
                        semiTransparentColor,
                        shape = RoundedCornerShape(6.dp)
                    )
                    .border(0.dp, color = Color.White, shape = RoundedCornerShape(6.dp))
                    .height(42.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Spacer(modifier = Modifier.width(width = 16.dp))
                innerTextField()
            }
        },
        cursorBrush = SolidColor(Color.White)
    )

    createText(
        fontSize = 15,
        text = "Password",
        fontWeight = FontWeight.Medium,
        modifier = Modifier,
        color = Color.White
    )

    BasicTextField(
        value = passwordText,
        onValueChange = { newText ->
            passwordText = newText
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 4.dp),
        textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .background(
                        semiTransparentColor,
                        shape = RoundedCornerShape(6.dp)
                    )
                    .border(0.dp, color = Color.White, shape = RoundedCornerShape(6.dp))
                    .height(42.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Spacer(modifier = Modifier.width(width = 16.dp))
                innerTextField()
            }
        },
        cursorBrush = SolidColor(Color.White)
    )

    createText(
        fontSize = 15,
        text = "Confirm Password",
        fontWeight = FontWeight.Medium,
        modifier = Modifier,
        color = Color.White
    )

    BasicTextField(
        value = confirmPasswordText,
        onValueChange = { newText ->
            confirmPasswordText = newText
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 8.dp),
        textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .background(
                        semiTransparentColor,
                        shape = RoundedCornerShape(6.dp)
                    )
                    .border(0.dp, color = Color.White, shape = RoundedCornerShape(6.dp))
                    .height(42.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Spacer(modifier = Modifier.width(width = 16.dp))
                innerTextField()
            }
        },
        cursorBrush = SolidColor(Color.White)
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Checkbox(checked = checkBoxState, onCheckedChange = {
            checkBoxState = it
        },
            modifier = Modifier
                .width(8.dp)
                .height(8.dp)
                .padding(8.dp, 0.dp, 0.dp, 0.dp),
            colors = CheckboxDefaults.colors(checkedColor = Color.White, checkmarkColor = Color.LightGray, uncheckedColor = Color.White)
        )
        createText(
            fontSize = 15,
            text = "Accept",
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(12.dp,0.dp,0.dp,0.dp),
            color = Color.White
        )
        createText(
            fontSize = 15,
            text = "Privacy Policy.",
            fontWeight = FontWeight.Normal,
            modifier = Modifier,
            color = Color(android.graphics.Color.parseColor("#" + "FFE352"))
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier
                .width(146.dp)
                .height(52.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(),
            onClick = {
                val returnFromFireBase = viewModel.createUser(
                    nameText.text,
                    surnameText.text,
                    eMailText.text,
                    passwordText.text,
                    confirmPasswordText.text,
                    checkBoxState
                )

                when(returnFromFireBase) {
                    FireBaseError.Sucess -> navController.navigate(Screen.Login.route)
                    FireBaseError.ConnectionError -> Toast.makeText(context, "There is a connection error.", Toast.LENGTH_LONG).show()
                    FireBaseError.PasswordNotEqual -> Toast.makeText(context, "Passwords are not equal.", Toast.LENGTH_LONG).show()
                    FireBaseError.UndifiendError -> Toast.makeText(context, "Undifiend error.", Toast.LENGTH_LONG).show()
                    FireBaseError.NoChecked -> Toast.makeText(context, "Checked the privacy.", Toast.LENGTH_LONG).show()
                }
            },
            shape = RoundedCornerShape(20.dp),
        ) {
            Box(
                modifier = Modifier
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color(android.graphics.Color.parseColor("#" + "8080F2")),
                                Color(android.graphics.Color.parseColor("#" + "050091"))
                            )
                        )
                    )
                    .fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                createText(
                    fontSize = 16,
                    text = "Sign Up",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier,
                    color = Color.White
                )
            }
        }
        Spacer(modifier = Modifier.height(customSpacerHeight.dp))
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "LogoImage",
            modifier = Modifier
                .width(89.dp)
                .height(22.dp),
        )
    }
}
@Composable
fun createText(
    fontSize: Int,
    text: String,
    fontWeight: FontWeight,
    modifier: Modifier,
    color: Color
) {
     Text(
        text = text,
        color = color,
        fontSize = fontSize.sp,
        fontWeight = fontWeight,
        modifier = modifier
    )
}

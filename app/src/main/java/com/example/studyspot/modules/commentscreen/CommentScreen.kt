package com.example.studyspot.modules.commentscreen

import android.view.KeyEvent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studyspot.R
import com.example.studyspot.utilities.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun CommentScreen(navController: NavController) {
    val height = LocalConfiguration.current.screenHeightDp
    var commentText by remember { mutableStateOf(TextFieldValue(""))}
    val viewModel = CommentViewModel()
    var painterResource by remember { mutableStateOf(R.drawable.empty_star) }
    var isClicked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.messagebacground),
            contentDescription = "MessageScreenbacground",
            modifier = Modifier
                .fillMaxWidth()
                .height((height * 0.45).dp),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .background(Color(android.graphics.Color.parseColor("#" + "5E44FF")))
                .height((height * 0.55).dp)
                .fillMaxWidth()
        ) {
            TextField(singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {
                        navController.navigate(Screen.MapDetail.route)
                    }
                ),
                modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 10.dp)
                .onKeyEvent {
                    if (it.nativeKeyEvent.keyCode == KeyEvent.KEYCODE_ENTER){
                        navController.navigate(Screen.MapDetail.route)
                        true
                    }
                    false
                },
                placeholder = {
                Text(text = "Add comment...")
            },
                value = commentText,
                onValueChange = { newText ->
                commentText = newText
            },
              shape = RoundedCornerShape(14.dp)
            )
            Row(
                modifier = Modifier
                    .padding(0.dp, 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                createText(
                    fontSize = 20,
                    text = "Rate the Place",
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier,
                    color = Color.White)
                Spacer(Modifier.width(58.dp))
                for (i in 0..4) {
                    IconButton(
                        modifier = Modifier
                            .size(19.dp),
                        onClick = {
                            isClicked = !isClicked
                            if(isClicked) {
                                painterResource = R.drawable.fill_star
                            } else {
                                painterResource = R.drawable.empty_star
                            }
                        }
                    ) {
                        Image(painter = painterResource(painterResource), contentDescription = "emptyStar")
                    }
                }
            }
        }
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

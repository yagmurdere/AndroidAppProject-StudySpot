package com.example.studyspot.ProfileEditScreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.studyspot.R

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
            IconButton(onClick = {
                navController.navigate("settings")
                Log.d("Navigation", "Settings button clicked")
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.settings_iconn),
                    contentDescription = "goto settings page ",
                    tint = Color.White
                )
            }
        }

        var isEditing by remember { mutableStateOf(true) }


        Column(
            Modifier
                .fillMaxWidth()
                .padding(10.dp),
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
                        .border(3.dp, Color.Blue, CircleShape)
                )

            }


            var name by remember {
                mutableStateOf("John Doe")
            }
            var email by remember {
                mutableStateOf("john.doe@gmail.com")
            }
            var oldpassword by remember {
                mutableStateOf("**********")
            }

            TextField(
                value = name, onValueChange = { name = it },
                modifier = Modifier.padding(top = 3.dp)
                    .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)

            )


            Column {
                Row {
                    Text(text = "E-mail")
                }
                TextField(
                    value = email, onValueChange = { email = it },
                    modifier = Modifier
                        .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)

                )

                Row {
                    Text(text = "Change Password")
                }
                TextField(
                    value = oldpassword, onValueChange = { oldpassword = it },
                    modifier = Modifier
                        .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)

                )
                Row {
                    Text(text = "New Passsword")
                }
                TextField(
                    value = " ", onValueChange = {},
                    modifier = Modifier
                        .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)

                )
                Row {
                    Text(text = "New Password")
                }
                TextField(
                    value = " ", onValueChange = {},
                    modifier = Modifier
                        .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)

                )

            }

        }
    }}



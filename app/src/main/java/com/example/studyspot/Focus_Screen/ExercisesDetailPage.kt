package com.example.studyspot.Focus_Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studyspot.R

@Composable
fun DetailScreen(
    photos:Array<Int>,
    names:Array<String>,
    definition: Array<String>,
    itemIndex:Int?,
    modifier: Modifier = Modifier,
    navController: NavController
){
    Column(
        modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp))
    {
        Row (verticalAlignment = Alignment.CenterVertically)
        {
            Column {
                IconButton({navController.navigate("MainScreen")})  {
                    Icon(painter = painterResource(id = R.drawable.back_icon), contentDescription =" ", tint = Color.Red )

                }
            }
        }
        Box(modifier.fillMaxSize(),
            contentAlignment = Alignment.Center)
        {
            Image(painter = painterResource(id = photos[itemIndex!!]), contentDescription =" " )
        }
        Text(text = names[itemIndex!!], fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text(text = definition[itemIndex], fontSize = 18.sp)
    }
}
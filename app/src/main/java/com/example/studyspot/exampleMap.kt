package com.example.studyspot

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.studyspot.ui.theme.StudySpotTheme

@Composable
fun map(){
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.map), contentDescription = " ",
            modifier = Modifier.size(300.dp,700.dp),
            contentScale = ContentScale.FillBounds)
        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .offset(100.dp, 300.dp)
                .size(50.dp, 50.dp)) {
        }
    }
}
@Preview(showBackground = true)
@Composable
fun examplePreview(){
    StudySpotTheme {
        map()
    }
}
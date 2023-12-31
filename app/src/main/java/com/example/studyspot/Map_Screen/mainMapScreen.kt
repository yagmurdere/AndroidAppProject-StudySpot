package com.example.studyspot.Map_Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.studyspot.R
import com.example.studyspot.ui.theme.StudySpotTheme


@Composable
fun mapMain(){
    Column (modifier=Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.map), contentDescription =" " )
    }
}
@Composable
@Preview
fun mapPreview(){
    StudySpotTheme {
        mapMain()
    }
}
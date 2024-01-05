package com.example.studyspot.modules.Map_Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.studyspot.R
import com.example.studyspot.ui.theme.StudySpotTheme

@Composable
fun MapMain(mapDetailViewModel: mapDetailViewModel){
    Column(modifier = Modifier.fillMaxSize())
    {
        Image(painter = painterResource(id = R.drawable.map_bg),
            contentDescription = " ",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds)
    }
    Row (modifier = Modifier
        .fillMaxSize()
        .padding(top = 54.dp),
        horizontalArrangement = Arrangement.Center
    ){
        Image(painter = painterResource(id = R.drawable.logo), contentDescription =" " ,
            modifier = Modifier.size(147.dp,36.dp))
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Box{
            Image(painter = painterResource(id = R.drawable.map), contentDescription ="" ,
                modifier = Modifier.size(width = 393.dp, height = 650.dp),
                contentScale = ContentScale.FillBounds)
            repeat(mapDetailViewModel.places.size){
                    count->
                MapButtons(count = count,
                    places = mapDetailViewModel.places ,
                    xcor = mapDetailViewModel.xcor,
                    ycor = mapDetailViewModel.ycor )
            }

        }
    }
}

@Composable
fun MapButtons(
    count : Int,
    places:Array<String>,
    xcor:Array<Int>,
    ycor:Array<Int>)
{
    Button(onClick = { /*TODO*/ },
        modifier = Modifier
            .size(20.dp, 20.dp)
            .offset(x = xcor[count].dp, y = ycor[count].dp),
        colors = ButtonDefaults.buttonColors(Color.Red)) {
    }



}

@Preview(showBackground = true)
@Composable
fun MapPreview(){
    StudySpotTheme {
        MapMain(mapDetailViewModel = mapDetailViewModel())
    }
}
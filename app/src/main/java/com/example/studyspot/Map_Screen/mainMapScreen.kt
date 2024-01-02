package com.example.studyspot.Map_Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.studyspot.R
import com.example.studyspot.ui.theme.StudySpotTheme


@Composable
fun mapMain(mapDetailViewModel: mapDetailViewModel){
    Column(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.map_bg),
            contentDescription = " ",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds)


    }
    Row (modifier = Modifier
        .fillMaxSize()
        .padding(top = 54.dp),
        horizontalArrangement = Arrangement.Center){
        Image(painter = painterResource(id = R.drawable.logo), contentDescription =" " ,
            modifier = Modifier.size(147.dp,36.dp))
    }
    Column (modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.fillMaxWidth()){
            Image(painter = painterResource(id = R.drawable.map), contentDescription =" " ,
                modifier = Modifier.size(394.dp,640.dp),
                contentScale = ContentScale.FillBounds)
            LazyColumn(modifier = Modifier.background(Color.Red)){
                val itemCount=mapDetailViewModel.places.size
                items(itemCount){
                        count->
                    mapButtons(
                        count=count,
                        xcor = mapDetailViewModel.xcor,
                        ycor = mapDetailViewModel.ycor,
                        places = mapDetailViewModel.places
                    )
                }
            }


        }

    }

}
@Composable
fun mapButtons(
    count:Int,
    places:Array<String>,
    xcor:Array<Int>,
    ycor:Array<Int>){
    Box(modifier = Modifier
        .size(5.dp, 5.dp)
        .clip(shape = CircleShape)
        .offset(xcor[count!!].dp, ycor[count!!].dp)){
    }

}

@Preview(showBackground = true)
@Composable
fun mapPreview(){
    StudySpotTheme {
        mapMain(mapDetailViewModel = mapDetailViewModel())
    }
}
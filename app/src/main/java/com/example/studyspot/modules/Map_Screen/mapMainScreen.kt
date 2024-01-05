package com.example.studyspot.modules.Map_Screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyspot.R
import com.example.studyspot.ui.theme.StudySpotTheme

@Composable
fun MapMain(mapDetailViewModel: mapDetailViewModel){
    var selectedBoxIndex by remember { mutableStateOf(-1) }
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
                    ycor = mapDetailViewModel.ycor ,
                    isSelected = selectedBoxIndex == count,
                    onBoxClick = {
                        selectedBoxIndex = if (selectedBoxIndex == count) -1 else count
                    }
                )
            }
            Image(painter = painterResource(id = R.drawable.map_details), contentDescription ="" ,
                modifier = Modifier.size(169.dp,50.dp).offset(x=21.dp,y=500.dp))

        }
    }
}

@Composable
fun MapButtons(
    count : Int,
    places:Array<String>,
    xcor:Array<Int>,
    ycor:Array<Int>,
    isSelected: Boolean,
    onBoxClick: () -> Unit)
{
    Button(onClick = onBoxClick,
        modifier = Modifier
            .size(20.dp, 20.dp)
            .offset(x = xcor[count].dp, y = ycor[count].dp),
        colors = ButtonDefaults.buttonColors(Color.Red)) {
    }
    if (isSelected) {
        Box(
            modifier = Modifier
                .size(180.dp, 140.dp)
                .padding(16.dp)
                //.offset(x = 10.dp, y = 350.dp)
                .offset(x = (xcor[count] - 120).dp, y = ycor[count].dp)
                .clip(shape = RoundedCornerShape(15.dp))
                .background(
                    brush = Brush
                        .verticalGradient(
                            colors = listOf(
                                Color.White.copy(alpha = 0.9f),
                                colorResource(id = R.color.map_page_box_color).copy(alpha = 0.9f)
                            )
                        )
                )
                .border(
                    width = 5.dp,
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            colorResource(id = R.color.map_page_box_border_color).copy(alpha = 0.9f),
                            Color.White.copy(alpha = 0.9f)
                        )
                    ), shape = RoundedCornerShape(15.dp)
                )

        ) {

            Text("${places[count]}", color = colorResource(id = R.color.map_page_box_text_color),
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(15.dp)
                    .clickable { Log.e("msj", "buton çalışıyor") },
                )
        }
    }


}

@Preview(showBackground = true)
@Composable
fun MapPreview(){
    StudySpotTheme {
        MapMain(mapDetailViewModel = mapDetailViewModel())
    }
}
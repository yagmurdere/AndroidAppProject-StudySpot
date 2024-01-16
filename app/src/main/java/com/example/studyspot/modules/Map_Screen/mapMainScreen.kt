package com.example.studyspot.modules.Map_Screen

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.studyspot.R
import com.example.studyspot.entities.RestaurantModel
import com.example.studyspot.modules.mapdetail.MapDetailViewModel

import com.example.studyspot.ui.theme.StudySpotTheme
import com.example.studyspot.ui.theme.newfontfamily
import com.example.studyspot.utilities.navigation.NavigationSetup

@Composable
fun MapMain(mapDetailViewModel: mapDetailViewModel,navController: NavController){
    var selectedBoxIndex by remember { mutableStateOf(-1) }
    val viewModel = mapDetailViewModel()
    //val restaurantList = viewModel.restaurants.observeAsState(initial =  emptyList())
    LaunchedEffect(viewModel){
        viewModel.fetchRestaurant()
    }
    //Log.d("seco2", restaurantList.value[0].toString())
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
                    },
                    plug=mapDetailViewModel.plug,
                    coffe=mapDetailViewModel.coffe,
                    wifi=mapDetailViewModel.wifi,
                    yogun=mapDetailViewModel.yogun
                )
            }
            Image(painter = painterResource(id = R.drawable.map_details), contentDescription ="" ,
                modifier = Modifier
                    .size(169.dp, 50.dp)
                    .offset(x = 21.dp, y = 500.dp))
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
    onBoxClick: () -> Unit,
    plug : Array<Boolean>,
    coffe : Array<Boolean>,
    wifi : Array<Boolean>,
    yogun : Array<Int>,
)
{
    Box {
        Button(onClick = onBoxClick,
            modifier = Modifier
                .size(20.dp, 20.dp)
                .offset(x = xcor[count].dp, y = ycor[count].dp),
            colors = ButtonDefaults.buttonColors(
                colorResource(id =
                if(yogun[count]<=30) R.color.green_box_border_color
                else if(yogun[count]<=60) R.color.yellow_box_border_color
                else R.color.red_box_border_color)
            )) {
        }

        if (isSelected) {
            Box(
                modifier = Modifier
                    .size(180.dp, 150.dp)
                    .padding(16.dp)
                    //.offset(x = 10.dp, y = 350.dp)
                    .offset(
                        x = if (count == 0) 210.dp else if (count == 4) 80.dp else if (count == 1) 160.dp else (xcor[count] - 130).dp,
                        y = if (count == 0) 140.dp else if (count == 4) 40.dp else if (count == 1) 370.dp else (ycor[count].dp)
                    )

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
                                colorResource(id =
                                if(yogun[count]<=40) R.color.green_box_border_color
                                else if(yogun[count]<=70) R.color.yellow_box_border_color
                                else R.color.red_box_border_color).copy(alpha = 0.9f),
                                Color.White.copy(alpha = 0.9f)
                            )
                        ), shape = RoundedCornerShape(15.dp)
                    )

            ) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 15.dp, top = 15.dp, end = 15.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text("${places[count]}",
                        color = colorResource(id = R.color.map_page_box_text_color),
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = newfontfamily,
                        fontSize = 13.sp,
                        modifier = Modifier

                            .clickable { Log.e("msj", "buton çalışıyor") },
                    )
                    RatingStarExample()
                    Text(text = "Features",
                        color = colorResource(id = R.color.map_page_box_text_color),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 13.sp,
                        fontFamily = newfontfamily)
                    Row {
                        if(wifi[count]){
                            Icon(painter = painterResource(id = R.drawable.wifi_icon), contentDescription =" ",
                                modifier = Modifier
                                    .size(15.dp)
                                    .padding(end = 2.dp))
                        }
                        if(plug[count]){
                            Icon(painter = painterResource(id = R.drawable.plug_icon), contentDescription =" ",
                                modifier = Modifier
                                    .size(15.dp)
                                    .padding(end = 2.dp))
                        }
                        if(coffe[count]){
                            Icon(painter = painterResource(id = R.drawable.coffe_icon), contentDescription =" ",
                                modifier = Modifier
                                    .size(15.dp)
                                    .padding(end = 2.dp))
                        }

                    }
                }

            }
        }
    }



}

@Preview(showBackground = true)
@Composable
fun MapPreview(){
    StudySpotTheme {
        MapMain(mapDetailViewModel = mapDetailViewModel(), navController = rememberNavController())
    }
}
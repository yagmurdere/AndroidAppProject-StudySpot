package com.example.studyspot.modules.Focus_Screen

import android.graphics.Paint.Style
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.studyspot.R
import com.example.studyspot.ui.theme.StudySpotTheme
import com.example.studyspot.ui.theme.newfontfamily
import com.example.studyspot.utilities.navigation.NavigationSetup

@Composable
fun mainScreen(exercisesData: exerciseViewModel,
               navController: NavController
){
    Column(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.image_2),
            contentDescription = " ",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds)


    }
    Row(modifier = Modifier.padding(start = 44.dp, top = 76.dp)) {
        Text(text = "Let's Focus",
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = newfontfamily,
            color = colorResource(id = R.color.FocusPagemaincolor))

    }

    LazyColumn(contentPadding = PaddingValues(top = 155.dp, start = 20.dp, end = 20.dp)){

        val itemCount=exercisesData.exerciseNames.size
        items(itemCount){ item->
            ColumnItem(
                itemIndex=item,
                title=exercisesData.exerciseNames,
                navController=navController,
            )

        }
    }

}

@Composable
fun ColumnItem(
    itemIndex: Int,
    title: Array<String>,
    navController: NavController
) {
    Box (modifier = Modifier
        .padding(10.dp)
        .fillMaxSize()
        .height(66.dp)
        .clip(shape = RoundedCornerShape(15.dp))
        .background(
            brush = Brush
                .verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.focusCardBG2).copy(alpha = 0.5f),
                        colorResource(id = R.color.focusCardBG1).copy(alpha = 0.5f)
                    )
                )
        )
        .border(0.5.dp, color = Color.White, shape = RoundedCornerShape(15.dp))
        .clickable { navController.navigate("DetailScreen/$itemIndex") })
    {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp),
            verticalAlignment = Alignment.CenterVertically)
        {
            Text(text = title[itemIndex],
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = newfontfamily,
                color = colorResource(id = R.color.FocusPagemaincolor)
            )
        }

    }
}
@Composable
@Preview(showBackground = true)
fun myAppPreview(){
    StudySpotTheme {
        NavigationSetup(navController = rememberNavController())
    }
}
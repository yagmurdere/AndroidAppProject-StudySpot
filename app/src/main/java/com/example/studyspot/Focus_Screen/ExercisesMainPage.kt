package com.example.studyspot.Focus_Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studyspot.R
import com.example.studyspot.ui.theme.StudySpotTheme

@Composable
fun mainScreen(exercisesData: exerciseViewModel,
               navController: NavController
){
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.image_2),
            contentDescription = " ",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds)
        Text(text = "Let's Focus")

    }
    LazyColumn(contentPadding = PaddingValues(16.dp)){

        val itemCount=exercisesData.exerciseNames.size
        items(itemCount){ item->
            ColumnItem(
                itemIndex=item,
                title=exercisesData.exerciseNames,
                navController=navController,
                definitons = exercisesData.definitons1
            )

        }
    }

}

@Composable
fun ColumnItem(
    itemIndex: Int,
    title: Array<String>,
    definitons: Array<String>,
    navController: NavController
) {
    Card (modifier = Modifier
        .padding(10.dp)
        .wrapContentSize()
        .clickable { navController.navigate("DetailScreen/$itemIndex") },
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.5f)
        ),
        elevation = CardDefaults.cardElevation(1.dp))
    {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp))
        {
            Text(text = title[itemIndex],
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }

    }
}
@Composable
@Preview(showBackground = true)
fun myAppPreview(){
    StudySpotTheme {
        pageController()
    }
}
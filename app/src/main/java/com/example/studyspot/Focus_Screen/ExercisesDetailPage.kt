package com.example.studyspot.Focus_Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studyspot.R
import com.example.studyspot.ui.theme.StudySpotTheme

@Composable
fun DetailScreen(
    exerciseViewModel: exerciseViewModel,
    itemIndex:Int?,
    navController: NavController
){
    val headLines = arrayOf(
        exerciseViewModel.headLine1,
        exerciseViewModel.headLine2,
        exerciseViewModel.headLine3,
        exerciseViewModel.headLine4,
        exerciseViewModel.headLine5,
        exerciseViewModel.headLine6,
        exerciseViewModel.headLine7,
        exerciseViewModel.headLine8
    )
    val definitions = arrayOf(
        exerciseViewModel.definitons1,
        exerciseViewModel.definitons2,
        exerciseViewModel.definitons3,
        exerciseViewModel.definitons4,
        exerciseViewModel.definitons5,
        exerciseViewModel.definitons6,
        exerciseViewModel.definitons7,
        exerciseViewModel.definitons8
    )

    
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.focus_page_bg_2),
            contentDescription = " ",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds)
    }

    
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(25.dp)){
        item{
            Row (modifier = Modifier.fillMaxWidth()
                .padding(top = 20.dp))
            {
                IconButton({navController.navigate("MainScreen")})  {
                    Icon(painter = painterResource(id = R.drawable.back_icon), contentDescription =" ", tint = colorResource(
                        id = R.color.FocusPagemaincolor) )

                }
                Text(text = exerciseViewModel.exerciseNames[itemIndex!!], fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp),
                    color = colorResource(id = R.color.FocusPagemaincolor)
                )
            }
            Column (horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()){

                if(exerciseViewModel.exerciseNames[itemIndex!!]=="POMODORO TECHNIQUE"){
                    mainSurface()
                }
                else{
                    Image(painter = painterResource(id = exerciseViewModel.imageId[itemIndex!!]), contentDescription =" ",
                        modifier = Modifier
                            .size(250.dp, 250.dp)
                            .padding(top = 15.dp, bottom = 25.dp))
                }


            }
            }

        items(8){
                i->
            Text(text = headLines[i][itemIndex!!], fontSize = 18.sp,
                color = colorResource(id = R.color.FocusPagemaincolor),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 5.dp))
            Text(text = definitions[i][itemIndex!!], fontSize = 16.sp)
            Spacer(modifier = Modifier.padding(bottom = 15.dp))
        }
    }

}


package com.example.studyspot.modules.mapdetail

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studyspot.R
import com.example.studyspot.entities.CommentModel
import com.example.studyspot.entities.RestaurantModel
import com.example.studyspot.entities.UserModel
import com.example.studyspot.modules.signup.createText
import com.example.studyspot.utilities.errors.FireBaseError
import com.example.studyspot.utilities.navigation.Screen

@Composable
fun MapDetail(navController: NavController, restaurant: RestaurantModel) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val screenHeight = LocalConfiguration.current.screenWidthDp
    val mapDetailViewModel = MapDetailViewModel()
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.mapdetailbackground),
            contentDescription = "MapDetailBackgorund",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .matchParentSize()
                .padding(0.dp, 10.dp)
                .width((screenWidth * 0.80).dp)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .width((screenWidth * 0.80).dp)
                    .height((screenHeight * .30).dp),
                painter = painterResource(id = R.drawable.restaurantimage),
                contentDescription = "RestourantImage",
                contentScale = ContentScale.FillBounds
            )
            createText(
                fontSize = 20,
                text = restaurant.restaurantName,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(0.dp, 16.dp),
                color = Color(android.graphics.Color.parseColor("#" + "5E44FF"))
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.width((screenWidth*0.80).dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    createText(
                        fontSize = 16,
                        text = "21",
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier,
                        color = Color.Black
                    )
                    for (i in 1..5) {
                        if (i < 3 ) {
                            Image(
                                painter = painterResource(
                                    id = R.drawable.fill_star),
                                contentDescription = "RateStar"
                            )
                        } else {
                            Image(
                                painter = painterResource(
                                    id = R.drawable.empty_star),
                                contentDescription = "RateStar"
                            )
                        }
                    }
                    createText(
                        fontSize = 16,
                        text = "(2.1)",
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier,
                        color = Color.Black
                    )
                    Spacer(Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.empyt_bookmark),
                        contentDescription = "Bookmark"

                    )
                }
            }
            Column(
                modifier = Modifier.width((screenWidth * 0.80).dp)
            ) {
                createText(
                    fontSize = 16,
                    text = "Hours",
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier,
                    color = Color(android.graphics.Color.parseColor("#" + "5E44FF"))
                )
                createText(
                    fontSize = 16,
                    text = restaurant.restaurantHours,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier,
                    color = Color.Black
                )
                createText(
                    fontSize = 16,
                    text = "Address",
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier,
                    color = Color(android.graphics.Color.parseColor("#" + "5E44FF"))
                )
                createText(
                    fontSize = 16,
                    text = restaurant.restaurantAddress,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier,
                    color = Color.Black
                )
                createText(
                    fontSize = 16,
                    text = "Features",
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier,
                    color = Color(android.graphics.Color.parseColor("#" + "5E44FF"))
                )
                Row {
                    if (restaurant.wifi) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.wifi),
                            contentDescription = "Wifi"
                        )
                    }
                    if(restaurant.electric) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.electric),
                            contentDescription = "Electric"
                        )
                    }
                    if(restaurant.hotDrink) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.hot),
                            contentDescription = "Hot"
                        )
                    }
                }
                createText(
                    fontSize = 16,
                    text = "Comments",
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier,
                    color = Color(android.graphics.Color.parseColor("#" + "5E44FF"))
                )
                val commentList = mapDetailViewModel
                    .fetchComments(
                        restaurantID = "restaurant.restaurantID"
                    )
                val userList = mapDetailViewModel.fetchUser()
                CommentsList(commentsList = commentList, userList = userList)
            }
            Button(
                modifier = Modifier
                    .width(34.dp)
                    .height(34.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues(),
                onClick = {

                },
                shape = RoundedCornerShape(20.dp),
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(
                                    Color(android.graphics.Color.parseColor("#" + "6779B9")),
                                    Color(android.graphics.Color.parseColor("#" + "E8F5FF"))
                                )
                            )
                        )
                        .width(34.dp)
                        .height(34.dp)
                        .border(1.dp, Color.White, CircleShape),
                    contentAlignment = Alignment.Center,
                ) {
                    createText(
                        fontSize = 24,
                        text = "+",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier,
                        color = Color(android.graphics.Color.parseColor("#" + "2652B2"))
                    )
                }
            }
            Button(
                modifier = Modifier
                    .width(146.dp)
                    .height(52.dp)
                    .padding(0.dp, 5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues(),
                onClick = {

                },
                shape = RoundedCornerShape(20.dp),
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(
                                    Color(android.graphics.Color.parseColor("#" + "8080F2")),
                                    Color(android.graphics.Color.parseColor("#" + "050091"))
                                )
                            )
                        )
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    if(false) {
                        createText(
                            fontSize = 16,
                            text = "I'm here!",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier,
                            color = Color.White
                        )
                    } else {
                        createText(
                            fontSize = 16,
                            text = "Leave!",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CreateText(
    fontSize: Int,
    text: String,
    fontWeight: FontWeight,
    modifier: Modifier,
    color: Color
) {
    Text(
        text = text,
        color = color,
        fontSize = fontSize.sp,
        fontWeight = fontWeight,
        modifier = modifier
    )
}

@Composable
fun CommentsList(commentsList: List<CommentModel>, userList: List<UserModel>) {
    val screenHeight = LocalConfiguration.current.screenHeightDp
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height((screenHeight * 0.40).dp)
    ) {
        items(commentsList.size) { commentIndex ->
            CommentCard(commentsList[commentIndex])
        }
    }
}

@Composable
fun CommentCard(comment: CommentModel) {
    Box() {
        Image(
            painter = painterResource(id = R.drawable.commentbackground),
            contentDescription = "CommentBackgound",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(66.dp)
                .padding(9.dp, 7.dp)
        ) {
            Row(

            ) {
                createText(
                    fontSize = 13,
                    text = "Erdem Ezgi",
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier,
                    color = Color(android.graphics.Color.parseColor("#" + "5E44FF"))
                )
                Spacer(Modifier.weight(1f))
                Row() {
                    for (i in 1..5) {
                        if (i < 3 ) {
                            Image(
                                painter = painterResource(
                                    id = R.drawable.fill_star),
                                contentDescription = "RateStar"
                            )
                        } else {
                            Image(
                                painter = painterResource(
                                    id = R.drawable.empty_star),
                                contentDescription = "RateStar"
                            )
                        }
                    }
                }
            }
            createText(
                fontSize = 12,
                text = comment.commet,
                fontWeight = FontWeight.Normal,
                modifier = Modifier,
                color = Color.Black
            )
        }
    }
}

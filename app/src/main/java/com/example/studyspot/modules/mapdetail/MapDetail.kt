package com.example.studyspot.modules.mapdetail

import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
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
import com.example.studyspot.modules.signup.createText

@Composable
fun MapDetail(navController: NavController) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val screenHeight = LocalConfiguration.current.screenWidthDp

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
                text = "Top Roastery",
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
                    text = "(10:00-24:00)",
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
                    text = "Yeni Çamlıca, M, Reşit Paşa Cd. No: 6, 34779 Ataşehir/İstanbul",
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
                    for (i in 1..3) {
                        Image(
                            painter = painterResource(id = R.drawable.empyt_bookmark),
                            contentDescription = "FeatureIcons"
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
                val comment1 = CommentModel(
                    "132",
                    "123",
                    "123",
                    "123"
                )
                val comment2 = CommentModel(
                    "132",
                    "123",
                    "123",
                    "123"
                )
                val commentList = listOf(comment1, comment2,comment1, comment2,comment1, comment2,comment1, comment2,comment1, comment2,comment1, comment2,comment1, comment2)
                commentsList(commentsList = commentList)
            }
            Image(
                painter = painterResource(id = R.drawable.addcommentbutton),
                contentDescription = "AddCommentButton",
                Modifier.clickable {

                }
                    .width(34.dp)
                    .height(34.dp)
            )
        }
    }
}

@Composable
fun createText(
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
fun commentsList(commentsList: List<CommentModel>) {
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
    val screenWidth = LocalConfiguration.current.screenWidthDp
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
                text = "Müzik çok yüksekti ama kahve inanılmaz.",
                fontWeight = FontWeight.Normal,
                modifier = Modifier,
                color = Color.Black
            )
        }
    }
}

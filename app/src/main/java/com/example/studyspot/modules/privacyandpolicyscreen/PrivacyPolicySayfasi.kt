package com.example.studyspot.modules.privacyandpolicyscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studyspot.R

@Composable
fun PrivacyPolicy(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.privacypolicy_background),
                contentScale = ContentScale.FillBounds
            )

    ) {

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {

                    IconButton(onClick = { navController.navigate("settings") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.back_icon),
                            contentDescription = "back to settings", tint = Color.White
                        )
                    }
                    Text(
                        text = "Privacy & Policy",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp
                    )
                }

                Box(
                    modifier = Modifier
                        .padding(30.dp)
                        .verticalScroll(rememberScrollState())
                ) {

                    Column {
                        Text(text = "Study Spot prioritizes user privacy. The information collected through our \"Study Spot\" application is used to enhance user experience and provide services more effectively. User personal information is protected within the scope of our privacy policy and is never shared or sold to third parties without their consent. ",)
                        Spacer(modifier = Modifier.padding(10.dp))
                        Text(text = "Our application may use geolocation information to assist users in finding and sharing study spots. However, this information is never shared without user permission and is not associated with their personal identity. Additionally, data collected regarding application usage is utilized to improve service quality, provide recommendations, and personalize the user experience.")
                        Spacer(modifier = Modifier.padding(10.dp))
                        Text(text = "Cookies and similar technologies may be used to remember user preferences and customize content. The use of these technologies aims to enhance the user experience and ensure the security of the application.")
                        Spacer(modifier = Modifier.padding(10.dp))
                        Text(text = "Our privacy policy may be updated periodically. Therefore, please review this page periodically to stay informed of any changes. For any questions or concerns regarding privacy and security, you can contact us through [Contact Information].")
                        Spacer(modifier = Modifier.padding(10.dp, bottom = 20.dp))
                        Text(text = "By using our \"Study Spot\" application, you are deemed to have accepted this privacy policy. We are here for a secure and effective learning experience. Thank you."
                        )
                    }
                }



            }
        }
    }}






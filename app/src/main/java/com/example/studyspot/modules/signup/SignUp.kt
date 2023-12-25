package com.example.studyspot.modules.signup

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.studyspot.Greeting
import com.example.studyspot.ui.theme.StudySpotTheme

@Composable
fun SignUp() {
    Text(text = "Let's Start")
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    StudySpotTheme {
        SignUp()
    }
}
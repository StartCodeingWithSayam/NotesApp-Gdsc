package com.gdsc.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdsc.notesapp.ui.theme.NotesAppTheme

class ForgotPassword : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ForgotUi()
                }
            }
        }
    }
}

@Composable
fun ForgotUi() {
    var name by remember { mutableStateOf("") }
    var studentId by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var conformPassword by remember { mutableStateOf("") }
    val checkIdClicked = remember { mutableStateOf(false) }
    val saveClicked = remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            Modifier
                .background(MaterialTheme.colors.background)
                .padding(top = 33.dp, start = 12.dp, end = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 34.dp),
                text = "New Password",
                fontSize = 36.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(400),
                color = Color.White,
                textAlign = TextAlign.Center
            )

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = {
                    Text(
                        text = "Name",
                        color = Color.White
                    )
                },
                shape = RoundedCornerShape(8.dp),
                leadingIcon = {
                    Icon(
                        Icons.Default.AccountBox,
                        contentDescription = "Person",
                        Modifier.padding(start = 23.dp, end = 23.dp),
                        tint = Color.White
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp)
            )
            OutlinedTextField(
                value = studentId,
                onValueChange = { studentId = it },
                label = {
                    Text(
                        text = "StudentId",
                        color = Color.White
                    )
                },
                shape = RoundedCornerShape(8.dp),
                leadingIcon = {
                    Icon(
                        Icons.Default.Info,
                        contentDescription = "Icon",
                        Modifier.padding(start = 23.dp, end = 23.dp),
                        tint = Color.White
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp),
                visualTransformation = PasswordVisualTransformation(),
            )
            OutlinedButton(
                onClick = {
                    checkIdClicked.value = !checkIdClicked.value
                },
                modifier = Modifier
                    .padding(top = 23.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "CheckId",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 23.sp,
                    fontFamily = FontFamily.SansSerif
                )
            }
            Divider(
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 53.dp, bottom = 53.dp),
                thickness = 1.dp,
                startIndent = 0.dp
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = {
                    Text(
                        text = "Password",
                        color = Color.White
                    )
                },
                shape = RoundedCornerShape(8.dp),
                leadingIcon = {
                    Icon(
                        Icons.Default.AccountBox,
                        contentDescription = "Person",
                        Modifier.padding(start = 23.dp, end = 23.dp),
                        tint = Color.White
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp)
            )
            OutlinedTextField(
                value = conformPassword,
                onValueChange = { conformPassword = it },
                label = {
                    Text(
                        text = "ConformPassword",
                        color = Color.White
                    )
                },
                shape = RoundedCornerShape(8.dp),
                leadingIcon = {
                    Icon(
                        Icons.Default.Info,
                        contentDescription = "Icon",
                        Modifier.padding(start = 23.dp, end = 23.dp),
                        tint = Color.White
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp),
                visualTransformation = PasswordVisualTransformation(),
            )
            OutlinedButton(
                onClick = {
                    saveClicked.value = !saveClicked.value
                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.padding(top = 23.dp)
            ) {
                Text(
                    text = "Save",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 23.sp,
                    fontFamily = FontFamily.SansSerif
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    NotesAppTheme {
        ForgotUi()
    }
}
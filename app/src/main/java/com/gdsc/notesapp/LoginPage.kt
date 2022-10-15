package com.gdsc.notesapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdsc.notesapp.ui.theme.NotesAppTheme

class LoginPage : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                ) {
                    LoginUi()
                }
            }
        }
    }
}



@Composable
fun LoginUi() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val loginClicked = remember { mutableStateOf(false) }
    val mContext = LocalContext.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Column(
            Modifier
                .background(MaterialTheme.colors.background)
                .padding(23.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 134.dp),
                text = "Login",
                fontSize = 56.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(500),
                color = Color.White,
                textAlign = TextAlign.Center
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    Text(
                        text = "Enter the Email",
                        color = Color.White
                    )
                },
                shape = RoundedCornerShape(8.dp),
                leadingIcon = {
                    Icon(
                        Icons.Default.Email,
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
                value = password,
                onValueChange = { password = it },
                label = {
                    Text(
                        text = "Enter Password",
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
                    loginClicked.value = !loginClicked.value
                },
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Login",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = 23.sp,
                    fontFamily = FontFamily.SansSerif
                )
            }
        }
            BottomPart(modifier = Modifier)
    }
    if (loginClicked.value)
        openMainPage(mContext)
}

@Composable
fun BottomPart(modifier: Modifier = Modifier) {
    val mContext = LocalContext.current
    val passCode = remember { mutableStateOf(false) }
    val signIn = remember { mutableStateOf(false) }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(2.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Forgot Password",
            modifier = modifier
                .clickable {
                    passCode.value = !passCode.value
                }
                .padding(2.dp),
            color = Color(0xFFFF6700),
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace,
            textDecoration = TextDecoration.Underline
        )
        Row {
            Text(
                text = "Don't have Account..",
                modifier = modifier
                    .padding(2.dp),
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = FontFamily.Monospace,
                textDecoration = TextDecoration.None
            )
            Text(
                text = "SignIn",
                modifier = modifier
                    .clickable {
                        signIn.value = !signIn.value
                    }
                    .padding(2.dp),
                color = Color(0xFFFF6700),
                fontSize = 20.sp,
                fontFamily = FontFamily.Monospace,
                textDecoration = TextDecoration.Underline
            )
        }
    }
    if (passCode.value) {
        openForgotPasswordPage(mContext)
    }
    if (signIn.value) {
        openSignInPasswordPage(mContext)
    }
}

fun openForgotPasswordPage(mContext: Context) {
    mContext.startActivity(Intent(mContext,ForgotPassword::class.java))
}

fun openSignInPasswordPage(mContext: Context) {
    mContext.startActivity(Intent(mContext,SignInPage::class.java))
}

fun openMainPage(mContext: Context) {
    mContext.startActivity(Intent(mContext,HomeScreen::class.java))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NotesAppTheme {
        LoginUi()
    }
}
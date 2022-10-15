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
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
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
class SignInPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SignInPageUi()
                }
            }
        }
    }
}

@Composable
fun SignInPageUi() {
    val mContext = LocalContext.current
    var nameSignUP by remember { mutableStateOf("") }
    var emailSignUP by remember { mutableStateOf("") }
    var studentId by remember { mutableStateOf("") }
    var passwordSignUp by remember { mutableStateOf("") }
    var conformPasswordSignUp by remember { mutableStateOf("") }
    val signInClicked = remember { mutableStateOf(false) }
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
                    .padding(top = 34.dp),
                text = "Sign In",
                fontSize = 56.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(500),
                color = Color.White,
                textAlign = TextAlign.Center
            )

            OutlinedTextField(
                value = nameSignUP,
                onValueChange = { nameSignUP = it },
                label = {
                    Text(
                        text = "Enter your Name",
                        color = Color.White
                    )
                },
                shape = RoundedCornerShape(8.dp),
                leadingIcon = {
                    Icon(
                        Icons.Default.AccountBox,
                        contentDescription = "name",
                        Modifier.padding(start = 23.dp,end=23.dp),
                        tint = Color.White
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp)
            )
            OutlinedTextField(
                value = emailSignUP,
                onValueChange = { emailSignUP = it },
                label = {
                    Text(
                        text = "Enter your mail",
                        color = Color.White
                    )
                },
                shape = RoundedCornerShape(8.dp),
                leadingIcon = {
                    Icon(
                        Icons.Default.Email,
                        contentDescription = "Email",
                        Modifier.padding(start = 23.dp,end=23.dp),
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
                        Icons.Default.Person,
                        contentDescription = "studentId",
                        Modifier.padding(start = 23.dp,end=23.dp),
                        tint = Color.White
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp)
            )
            OutlinedTextField(
                value = passwordSignUp,
                onValueChange = { passwordSignUp = it },
                label = {
                    Text(
                        text = "Enter your password",
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
            OutlinedTextField(
                value = conformPasswordSignUp,
                onValueChange = { conformPasswordSignUp = it },
                label = {
                    Text(
                        text = "Conform your password",
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
                    signInClicked.value = !signInClicked.value
                } ,
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "SignUp",
                    textAlign = TextAlign.Center,
                    color =Color.White,
                    fontSize = 23.sp,
                    fontFamily = FontFamily.SansSerif
                )
            }
        }
        SignUpBottomPart()
    }
    if (signInClicked.value)
        openMainPage(mContext)
}
@Composable
fun SignUpBottomPart(modifier: Modifier = Modifier){
    val mContext = LocalContext.current
    val signInClick = remember {
        mutableStateOf(false)
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(6.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text  = "Already have Account.." ,
            modifier = modifier
                .padding(4.dp),
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace,
            textDecoration = TextDecoration.None
        )
        Text(
            text  = "Login" ,
            modifier = modifier
                .clickable {
                    signInClick.value = !signInClick.value
                }
                .padding(2.dp),
            color = Color(0xFFFF6700),
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace,
            textDecoration = TextDecoration.Underline
        )
    }
    if (signInClick.value){
        openLoginPage(mContext)
    }
}
fun openLoginPage(mContext: Context){
    mContext.startActivity(Intent(mContext,LoginPage::class.java))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    NotesAppTheme {
    SignInPageUi()
    }
}
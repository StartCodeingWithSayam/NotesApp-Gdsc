package com.gdsc.notesapp

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gdsc.notesapp.models.Data
import com.gdsc.notesapp.models.DataViewModel
import com.gdsc.notesapp.models.SettingsModel
import com.gdsc.notesapp.models.SettingsViewModel
import com.gdsc.notesapp.ui.main.NavItems
import com.gdsc.notesapp.ui.theme.NotesAppTheme

class HomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colors.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun SetDataList(dataList:List<Data>){
    val context:Context = LocalContext.current
    LazyColumn {
        itemsIndexed(dataList) { dataIndex: Int, dataItem: Data ->
            OneRow(data = dataItem, onClick = {
                Toast.makeText(context, dataItem.imgDis, Toast.LENGTH_LONG).show()
            }
            )
        }
    }
}


@Composable
fun NavigationControler(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavItems.Home.route,
    ) {
        composable(route = NavItems.Home.route) {
            HomeUi()
        }
        composable(route = NavItems.Education.route) {
            EducationPage()
        }
        composable(route = NavItems.Profile.route) {
            AboutUi()
        }
        composable(route = NavItems.Settings.route) {
            SettingsPageUi()
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Navigation() {
    val item = listOf(NavItems.Home, NavItems.Education, NavItems.Profile, NavItems.Settings)
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.onBackground,
                elevation = 4.dp
            ) {
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentState = backStackEntry?.destination?.route
                item.forEach { it ->
                    val selected = it.route == currentState
                    BottomNavigationItem(selected = selected,
                        onClick = {
                            if (!selected) {
                                navController.graph.startDestinationRoute?.let {
                                    navController.popBackStack(it, true)
                                }
                            }
                            navController.navigate(it.route) {
                                launchSingleTop = true
                            }
                        },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.Gray,
                        label = {
                            Text(text = stringResource(id = it.tittle))
                        },
                        icon = {
                            Icon(painter = painterResource(id = it.icon), contentDescription = "")
                        }
                    )
                }
            }
        }
    ) {
        NavigationControler(navController = navController)
    }
}

// Top Bar
@Composable
fun TopBar(pgName: String, mode: String) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = pgName,
            fontSize = 50.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.White
        )
        Row {
            Text(
                text = mode,
                fontSize = 23.sp,
                color = Color(0xffFF6700),
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(top = 12.dp)
            )
            Icon(
                Icons.Default.ArrowDropDown,
                contentDescription = null,
                tint = Color(0xffFF6700),
                modifier = Modifier.padding(top = 13.dp)
            )
        }
    }
}

@Composable
fun SetSettingsData(settingsList: List<SettingsModel>) {
    val context:Context = LocalContext.current
    LazyColumn {
        itemsIndexed(settingsList) { settingsData: Int, SettingsItem: SettingsModel ->
            SettingsUi(settingsData = SettingsItem, onClick = {
                Toast.makeText(context, SettingsItem.imgDis, Toast.LENGTH_LONG).show()
            })
        }
    }
}

//BottomSettings
@Composable
fun BottomSetting() {
    val settingsViewModel = SettingsViewModel()
    val settingsData = settingsViewModel.settingsLists.value
    SetSettingsData(settingsList = settingsData!!)
}

// Settings
@Composable
fun SettingsPageUi() {
    val state = rememberScrollState()
    Surface(
        modifier = Modifier
            .scrollable(
                state = state,
                orientation = Orientation.Vertical,
                enabled = true,
                reverseDirection = true
            )
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.background),
                horizontalArrangement = Arrangement.Start,
            ) {
                Icon(
                    modifier = Modifier
                        .padding(top = 2.dp, start = 23.dp)
                        .size(70.dp),
                    imageVector = Icons.Default.Settings,
                    contentDescription = null,
                    tint = Color.White
                )
                Text(
                    modifier = Modifier.padding(
                        top = 2.dp,
                        start = 10.dp,
                        bottom = 0.dp,
                        end = 0.dp
                    ),
                    text = "Settings",
                    fontSize = 56.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Normal,
                    color = Color.White
                )
            }
            BottomSetting()
        }
    }
}

// Home Ui
@Composable
fun HomeUi() {
    val dataViewModel: DataViewModel = DataViewModel()
    val dataList = dataViewModel.dataLists.value
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Column (modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()){
            TopBar(pgName = "Hi UserName", mode = "Private Class Notes")
            SetDataList(dataList = dataList!!)
        }

    }
}

// Education
@Composable
fun EducationPage() {
    val dataViewModel = DataViewModel()
    val dataListing = dataViewModel.dataLists.value
    Column (modifier = Modifier.fillMaxWidth().wrapContentHeight()){
        TopBar(pgName = "Hi UserName", mode = "Public Class Notes")
        SetDataList(dataList = dataListing!!)
    }
}

// About
@Composable
fun AboutUi() {
    val dataViewModel = DataViewModel()
    val dataListing = dataViewModel.dataLists.value
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        // Top Part
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)
        ) {
            Text(
                text = "Hi UserName",
                fontSize = 50.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.White
            )
            Text(
                text = "About Me",
                fontSize = 23.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.White,
                modifier = Modifier.padding(start = 23.dp)
            )
        }
        //Bottom Part
        Column(modifier= Modifier
            .fillMaxWidth()
            .wrapContentHeight()) {
            SetDataList(dataList = dataListing!!)
        }
    }
}
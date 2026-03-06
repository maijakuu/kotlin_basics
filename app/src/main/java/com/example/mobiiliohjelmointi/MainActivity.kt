package com.example.mobiiliohjelmointi

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobiiliohjelmointiApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)

//YLÄKULMAN MENU
@Composable
fun MobiiliohjelmointiApp() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    var selectedItem by remember { mutableStateOf("Home") }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                val items = listOf(/*"Home", "Tehtävä 1.1", "Tehtävä 1.2",*/ "Tehtävä 1.3", "Tehtävä 1.4",
                    "Tehtävä 2.1", "Tehtävä 2.2", "Tehtävä 2.3", "Tehtävä 2.4", "Tehtävä 2.5", "Tehtävä 2.6",
                    "Tehtävä 3.1", "Tehtävä 3.2")

                Text("TEHTÄVÄT", modifier = Modifier.padding(5.dp), style = MaterialTheme.typography.titleSmall)
                items.forEach { item ->
                    NavigationDrawerItem(
                        label = { Text(item) },
                        selected = selectedItem == item,
                        onClick = {
                            selectedItem = item
                            navController.navigate(item) { launchSingleTop = true } // navigate
                            scope.launch { drawerState.close() }
                        }
                    )
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    modifier= Modifier.background(Transparent),
                    title = { Text("Mobiiliohjelmointi") },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                 )
                )
            }
        ) { padding ->

            val vm: kululaskuriViewModel = viewModel()
            NavHost(
                //modifier = Modifier.padding(padding),
                navController = navController,
                startDestination = "Tehtävä 3.2",)
                {
                    composable("Home") { Home() }
                    composable("Tehtävä 1.1") { Teht1() }
                    composable("Tehtävä 1.2") { Teht2() }
                    composable("Tehtävä 1.3") { Teht3() }
                    composable("Tehtävä 1.4") { Teht4() }
                    composable("Tehtävä 2.1") { Teht5() }
                    composable("Tehtävä 2.2") { Teht6() }
                    composable("Tehtävä 2.3") { Teht7() }
                    composable("Tehtävä 2.4") { Teht8() }
                    composable("Tehtävä 2.5") { Teht9() }
                    composable("Tehtävä 2.6") { Teht10()}
                    composable("Tehtävä 3.1") { Teht11(navController) }
                    composable("yhteenveto") { yhteenveto(navController) }
                    composable("Tehtävä 3.2") { Teht12a(navController) }
                    composable("Teht12b")     { Teht12b(navController, vm) }
                    composable("Teht12c")     { Teht12c(navController, vm) }
                    composable("Teht12d")     { Teht12d(navController, vm) }

                }
        }
    }
}


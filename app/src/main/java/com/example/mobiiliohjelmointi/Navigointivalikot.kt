package com.example.mobiiliohjelmointi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import kotlin.collections.contains

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun MobiiliohjelmointiApp() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    var selectedItem by remember { mutableStateOf("Home") }

//======================================SOVELLUKSEN VALIKKO========================================//

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                val items = listOf("Home", "Tehtävä 1.1", "Tehtävä 1.2","Tehtävä 1.3", "Tehtävä 1.4",
                    "Tehtävä 2.1", "Tehtävä 2.2", "Tehtävä 2.3", "Tehtävä 2.4", "Tehtävä 2.5", "Tehtävä 2.6",
                    "Tehtävä 3.1", "Tehtävä 3.2", "Tehtävä 3.3" )

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
    )
    {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

//=================================================================================================//

//======================================SOVELLUKSEN PERUSPALKIT====================================//

        Scaffold(
//___________________________________________YLÄPALKKI_____________________________________________//
            topBar = {
                TopAppBar(
                    modifier = Modifier
                        .background(
                            if (currentRoute == "Home")
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Black.copy(alpha = 0.99f),
                                        Color.Transparent
                                    ),
                                    startY = 10f,
                                    endY = 230f
                                )
                            else
                                Brush.verticalGradient(
                                    colors = listOf(Transparent, Transparent)
                                )
                        ),
                    title = {
                        Text(
                            "Mobiiliohjelmointi",
                            color = if (currentRoute == "Home") Color.White else Color.Black
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu",
                                tint = if (currentRoute == "Home") Color.White else Color.Black)
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Transparent
                    )
                )
            },


//_________________________________________________________________________________________________//

//____________________________________________ALAPALKKI____________________________________________//
            bottomBar = {
                val alapalkki = currentRoute in listOf("Tehtävä 3.3", "saannot", "tekija", "Teht13b", "Teht13c", "Teht13d") //näkyy vain näissä näytöissä
                val taakse = navController.previousBackStackEntry != null //katsoo backstackin, jos stackissa tavaraa, taaksepäin nuolta voi käyttää.

                if (alapalkki) {
                    BottomAppBar {
                        NavigationBarItem(
                            selected = false,
                            enabled = taakse,
                            onClick = { navController.popBackStack() },
                            icon = {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Takaisin",
                                    tint = if (taakse) Color.Black else Color.Gray
                                )
                            },
                            label = { Text("Takaisin") }
                        )
                        NavigationBarItem(
                            selected = currentRoute == "Tehtävä 3.3",
                            onClick = {
                                navController.navigate("Tehtävä 3.3")
                            },
                            icon = {
                                Icon(
                                    imageVector = Icons.Default.Create,
                                    contentDescription = "Pelaamaan!"
                                )
                            },
                            label = { Text("Pelaamaan!") }
                        )
                        NavigationBarItem(
                            selected = currentRoute == "tekija",
                            onClick = {
                                navController.navigate("tekija")
                            },
                            icon = {
                                Icon(
                                    imageVector = Icons.Default.Face,
                                    contentDescription = "Tekijä"
                                )
                            },
                            label = { Text("Tekijä") }
                        )
                        NavigationBarItem(
                            selected = currentRoute == "saannot",
                            onClick = {
                                navController.navigate("saannot")
                            },
                            icon = {
                                Icon(
                                    imageVector = Icons.Default.Info,
                                    contentDescription = "Säännöt"
                                )
                            },
                            label = { Text("Säännöt") }
                        )


                    }
                }
            }
        )

        { padding ->

//=======================================NAVIGOINTIREITIT=========================================//

            val vm: kululaskuriViewModel = viewModel()
            val vm1: tulosViewModel = viewModel()

            NavHost(
                //modifier = Modifier.padding(padding),
                navController = navController,
                startDestination = "Home",)
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
                composable("Tehtävä 3.2") { Teht12a(navController) }
                composable("Tehtävä 3.3") { Teht13a(navController) }
                composable("Teht12b")     { Teht12b(navController, vm) }
                composable("Teht12c")     { Teht12c(navController, vm) }
                composable("Teht12d")     { Teht12d(navController, vm) }
                composable("Teht13b")     { Teht13b(navController, vm1) }
                composable("Teht13c")     { Teht13c(navController, vm1) }
                composable("Teht13d")     { Teht13d(navController, vm1) }
                composable("yhteenveto") { yhteenveto(navController) }
                composable("saannot") {saannot(navController)}
                composable("tekija")  {tekija(navController)}
            }
        }
    }
}
//================================================================================================//

package com.example.mobiiliohjelmointi

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Teht12a(navController: NavHostController) {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("Valitse kulut") }

    val menuItems = listOf("Päivärahat", "Matkakulut")
    var paivat by remember { mutableIntStateOf(0)}
    var korvaus by remember { mutableFloatStateOf(0f)}
    var matka by remember { mutableFloatStateOf(0f)}
    var paivarahatot by remember { mutableFloatStateOf(0f) }
    var kmtot by remember { mutableFloatStateOf(0f) }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row() {
            Text(
                text = "Kululaskuri",
                textAlign = TextAlign.Center,
                fontSize = 40.sp
            )

        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color.LightGray)
                .clickable { expanded = true }
                .width(200.dp)
                .padding(5.dp)

        ) {
            Text(text = selectedItem)
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Dropdown arrow"
            )

            DropdownMenu(
                modifier = Modifier.width(200.dp),
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                menuItems.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(item) },
                        onClick = {
                            selectedItem = item
                            expanded = false
                        }
                    )
                }
            }
        }
        Row() {
            Button(
                onClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("paivat", paivat)
                    navController.currentBackStackEntry?.savedStateHandle?.set("korvaus", korvaus)

                    if (selectedItem == "Päivärahat")
                        { navController.navigate("Teht12b") }
                    else if (selectedItem == "Matkakulut")
                        { navController.navigate("Teht12c") }
                },
                modifier = Modifier
                    .padding(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
            )
            {
                Text(
                    text = "Jatka",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                )
            }
        }
        Row() {
            Button(
                onClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("paivat", paivat)
                    navController.currentBackStackEntry?.savedStateHandle?.set("korvaus", korvaus)
                    navController.navigate("Teht12d")
                },
                modifier = Modifier
                    .padding(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
            )
            {
                Text(
                    text = "Yhteenveto kuluista",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                )
            }
        }
    }
}
@Composable
fun Teht12b(navController: NavHostController)
{
    var paivat by remember { mutableStateOf("")}
    var korvaus by remember { mutableStateOf("")}

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Syötä päivärahat",
            textAlign = TextAlign.Center,
            fontSize = 40.sp
        )
        Spacer(modifier = Modifier.height(25.dp))

        TextField(
            modifier = Modifier.background(Color.LightGray),
            value = paivat,
            onValueChange = { paivat = it },
            label = { Text("Matkapäivien määrä") }
        )
        TextField(
            modifier = Modifier.background(Color.LightGray),
            value = korvaus,
            onValueChange = { korvaus = it },
            label = { Text("Korvaus per päivä (€)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row() {
                Button(onClick ={
                    navController.currentBackStackEntry?.savedStateHandle?.set("paivat", paivat)
                    navController.currentBackStackEntry?.savedStateHandle?.set("korvaus", korvaus)
                    navController.navigate("Teht12a")
                },
                    modifier = Modifier
                        .padding(20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow))
                {
                    Text(
                        text = "Tallenna",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                }

            }
        }
    }
}
@Composable
fun Teht12c(navController: NavHostController)
{
    var kilometrit by remember { mutableStateOf("")}

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Kilometrikorvaukset",
            textAlign = TextAlign.Center,
            fontSize = 40.sp
        )
        Spacer(modifier = Modifier.height(25.dp))

        TextField(
            modifier = Modifier.background(Color.LightGray),
            value = kilometrit,
            onValueChange = { kilometrit = it },
            label = { Text("Kilometrit") }
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row() {
                Button(onClick ={
                    navController.currentBackStackEntry?.savedStateHandle?.set("Kilometrit", kilometrit)
                    navController.navigate("Teht12a")
                },
                    modifier = Modifier
                        .padding(20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow))
                {
                    Text(
                        text = "Tallenna",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                }
            }
        }
    }
}
@Composable
fun Teht12d(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Text(text = "Yhteenveto kuluista", fontSize = 40.sp)

        Box(
            modifier = Modifier
                .background(Color.LightGray)
                .padding(10.dp)
        ) {
            Text(text = "Päivärahat: '$'", fontSize = 24.sp) // add score inside if needed
        }
        Box(
            modifier = Modifier
                .background(Color.LightGray)
                .padding(10.dp)
        ) {
            Text(text = "Kilometrit: '$'", fontSize = 24.sp) // add score inside if needed
        }
        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .padding(10.dp)
        ) {
            Text(text = "Yhteensä: '$'", fontSize = 24.sp) // add score inside if needed
        }
        Button(onClick = { }) {
            Text("Jatka")
        }
        Button(onClick = {}) {
            Text("Aloita alusta")
        }

    }
}
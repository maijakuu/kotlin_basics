package com.example.mobiiliohjelmointi

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Teht12a() {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("Valitse kulut") }

    val menuItems = listOf("Päivärahat", "Matkakulut")

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
                onClick = {},
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
                onClick = {},
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
/*
@Composable
fun total(navController: NavHostController)
{
    val tuotelista = navController.previousBackStackEntry
        ?.savedStateHandle?.get<List<Tuote>>("tuotelista") ?: emptyList()
    val hintatotal = navController.previousBackStackEntry
        ?.savedStateHandle?.get<Float>("hintatotal") ?: 0f

    Column(modifier = Modifier.fillMaxSize().padding(100.dp)) {
        Text("Tuotelistan tuotteet ja hinnat:", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))

        tuotelista.forEach { t ->
            Text("${t.name}: ${t.hours} €")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("Kokonaiskustannus: $hintatotal €", fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigateUp() }) {
            Text("Takaisin")
        }
    }
}
*/
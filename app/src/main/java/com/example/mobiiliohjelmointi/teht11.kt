package com.example.mobiiliohjelmointi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
data class Tuote(val name: String, val hours: Float)
@Composable
fun Teht11(navController: NavHostController)
{
    var tuote by remember { mutableStateOf("")}
    var hinta by remember { mutableStateOf("")}
    var tuotelista by remember { mutableStateOf<List<Tuote>>(emptyList()) }
    var hintatotal by remember { mutableFloatStateOf(0f) }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(5.dp, 50.dp, 5.dp, 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = "Tuotteen tiedot",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier
                .padding(16.dp, 50.dp, 16.dp, 16.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        TextField(
            modifier = Modifier.background(Color.LightGray),
            value = tuote,
            onValueChange = { tuote = it },
            label = { Text("Tuotteen nimi") }
        )
        TextField(
            modifier = Modifier.background(Color.LightGray),
            value = hinta,
            onValueChange = { hinta = it },
            label = { Text("Tuotteen hinta euroissa") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row() {
                Button(onClick ={
                        tuotelista = tuotelista + Tuote(tuote, hinta.toFloat())
                        hintatotal += hinta.toFloat()
                        tuote = ""
                        hinta = ""
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
                Button(onClick = {
                        navController.currentBackStackEntry?.savedStateHandle?.set("tuotelista", tuotelista)
                        navController.currentBackStackEntry?.savedStateHandle?.set("hintatotal", hintatotal)
                        navController.navigate("yhteenveto")
                    },
                    modifier = Modifier
                        .padding(20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow))
                        {
                        Text(
                            text = "Yhteenveto",
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
fun yhteenveto(navController: NavHostController)
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

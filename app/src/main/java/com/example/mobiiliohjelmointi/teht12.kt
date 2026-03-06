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
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

/*====================VIEWMODEL DATAN SÄILYTYKSEEN====================================*/
//ViewModel säilyttää ja muokkaa dataa erillään UI:sta.
//Jos käytetään remember:ia, data säilyy vain niin kauan kuin itse @Composable.
//Eli tässä tapauksessa aina kun siirryttiin 12a --> 12b --> 12c, niin data katosi.
data class plista(val paivat: String, val korvaus: Float)
data class kmlista(val kilometrit: Float)
class kululaskuriViewModel : ViewModel(){
    var paivarahalista by mutableStateOf<List<plista>>(emptyList())//Alustettu lista
    var kmkorvauslista by mutableStateOf<List<kmlista>>(emptyList())//Alustettu lista

    fun plistataytto(paivat: String, korvaus: Float)//Listan täyttö UI:sta saatavilla inputeilla
    {
        paivarahalista = paivarahalista + plista(paivat, korvaus)
    }
    fun kmlistataytto(kilometrit: Float)//Listan täyttö UI:sta saatavilla inputeilla
    {
        kmkorvauslista = kmkorvauslista + kmlista(kilometrit)
    }
    fun nollaa() {
        paivarahalista = emptyList()
        kmkorvauslista = emptyList()
    }
}
/*======================================================================================*/

//===================ALOITUSNÄYTTÖ=======================//
@Composable
fun Teht12a(navController: NavHostController) //Navcontroller ja navhost controller oltava navigoitaessa
{
    var expanded by remember { mutableStateOf(false) }  //Alasvetovalikkoa varten
    var selectedItem by remember { mutableStateOf("Valitse kulut") } //Alasvetovalikon valittu item
    val menuItems = listOf("Päivärahat", "Matkakulut") //lista valikkoitemeista


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
                    if (selectedItem == "Päivärahat")       //Jos listan valittu item ....
                        { navController.navigate("Teht12b") } //...mennään tänne.
                    else if (selectedItem == "Matkakulut")  //Jos listan valittu item ....
                        { navController.navigate("Teht12c") }//...niin sitten mennään tänne.
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
                    navController.navigate("Teht12d")//Yhteenvetosivu
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

//===================2. NÄYTTÖ=======================//
@Composable
fun Teht12b(navController: NavHostController, vm: kululaskuriViewModel) //Käytetään navigaatiota ja ViewModelia
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
                    vm.plistataytto(paivat, korvaus.toFloatOrNull()?: 0f) //Käytetään ViewModelia, täytetään listaa UI:n ulkopuolella
                    navController.popBackStack() //Poistaa nykyisen näytön navigaatiostackin päältä ja menee edelliseen näkymään (12a)
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

//===================3. NÄYTTÖ=======================//
@Composable
fun Teht12c(navController: NavHostController, vm: kululaskuriViewModel)//Käytetään navigaatiota ja ViewModelia
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
            label = { Text("kilometrit") }
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row() {
                Button(onClick ={
                    vm.kmlistataytto(kilometrit.toFloatOrNull()?:0f)
                    navController.popBackStack() //Poistaa nykyisen näytön navigaatiostackin päältä ja menee edelliseen näkymään (12a)
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

//===================YHTEENVETO=======================//
@Composable
fun Teht12d(navController: NavHostController, vm: kululaskuriViewModel) {

    /*=======================SAATUJEN ARVOJEN PROSESSOINTI========================*/
    val paivarahat = vm.paivarahalista.sumOf {
        (it.paivat.toFloatOrNull() ?: 0f) * it.korvaus.toDouble()
    }.toFloat()
    val kilometrikorvaus = vm.kmkorvauslista.sumOf {
        it.kilometrit.toDouble() * 0.5
    }.toFloat()
    val yhteensa = paivarahat + kilometrikorvaus
    /*=============================================================================*/

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Yhteenveto kuluista", fontSize = 40.sp)

        Box(
            modifier = Modifier
                .background(Color.LightGray)
                .padding(10.dp)
        ) {
            Text(text = "Päivärahat: $paivarahat €", fontSize = 24.sp)
            Box(
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(10.dp)
            ) {
                Text(
                    text = "Kilometrikorvaukset: $kilometrikorvaus €",
                    fontSize = 24.sp
                )
            }
            Box(
                modifier = Modifier
                    .background(Color.Green)
                    .padding(10.dp)
            ) {
                Text(text = "Yhteensä: $yhteensa €", fontSize = 24.sp)
            }

            Button(
                onClick = {
                    navController.navigate("Tehtävä 3.2")   //Palataan takaisin 12a
                    {
                        popUpTo("Tehtävä 3.2")  //Poista kaikki backstackista
                        { inclusive = true }
                    }           //Poista myös kohde itse, jotta saaadaan kokonaan alustettu stack.
                },
                modifier = Modifier
                    .padding(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
            )
            {
                Text(
                    text = "Jatka",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
            Button(
                onClick = {
                    vm.nollaa()
                    navController.navigate("Tehtävä 3.2")
                    { popUpTo("Tehtävä 3.2") { inclusive = true } }
                },
                modifier = Modifier.padding(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
            ) {
                Text(
                    text = "Aloita alusta",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
    }
}
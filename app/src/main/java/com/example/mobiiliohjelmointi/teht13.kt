package com.example.mobiiliohjelmointi

import android.content.Intent
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigator

class tulosViewModel : ViewModel()
{
    var ptulos by mutableIntStateOf(0)
    var mtulos by mutableIntStateOf(0)
    var rounds by mutableIntStateOf(0)
}
    @Composable
    fun Teht13a(navController: NavHostController) //Navcontroller ja navhost controller oltava navigoitaessa
    {
        var expanded by remember { mutableStateOf(false) }  //Alasvetovalikkoa varten
        var selectedItem by remember { mutableStateOf("Valitse laskettavat laskut") } //Alasvetovalikon valittu item
        val menuItems = listOf("Pluslaskut", "Miinuslaskut") //lista valikkoitemeista


        Column(
            modifier = Modifier.fillMaxSize(),
               // .padding(top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row() {
                Text(
                    text = "Matikkapeli",
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
                        if (selectedItem == "Pluslaskut")       //Jos listan valittu item ....
                        { navController.navigate("Teht13b") } //...mennään tänne.
                        else if (selectedItem == "Miinuslaskut")  //Jos listan valittu item ....
                        { navController.navigate("Teht13c") }//...niin sitten mennään tänne.
                    },
                    modifier = Modifier
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                )
                {
                    Text(
                        text = "Laskemaan!",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                    )
                }
            }
            Row() {
                Button(
                    onClick = {navController.navigate("Teht13d")
                    },
                    modifier = Modifier
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
                )
                {
                    Text(
                        text = "Kokonaistulokset",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                    )
                }
            }
        }
    }

@Composable
fun Teht13b(navController: NavHostController, vm1: tulosViewModel) { //PLUSLASKUT
    var numA by remember { mutableStateOf((1..10).random()) }
    var numB by remember { mutableStateOf((1..10).random()) }
    var userinput by remember { mutableStateOf("") }

        val sendbutton: () -> Unit =
            {
                val numguess = userinput.toIntOrNull()
                if (numguess == numA + numB) {
                    vm1.ptulos++}
                    vm1.rounds++
                    numA = (1..10).random()
                    numB = (1..10).random()
                    userinput = ""
                }

    Box(
        modifier = Modifier.fillMaxSize()
            .padding(0.dp, 100.dp),
        contentAlignment = Alignment.Center
    )
    {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Row(                                                        //OTSIKKO
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    text = "Pluslaskut",
                    fontSize = 40.sp
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            Row(                                                        //LASKURIVI
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            )

            {
                Text(text = "Laske:")

                Spacer(modifier = Modifier.width(5.dp))

                Box(
                    modifier = Modifier
                        .background(Color.Green)
                        .padding(10.dp)
                )

                { Text(text = "$numA") }

                Spacer(modifier = Modifier.width(5.dp))

                Text(text = "+")

                Spacer(modifier = Modifier.width(5.dp))

                Box(
                    modifier = Modifier
                        .background(Color.Green)
                        .padding(10.dp)
                )

                { Text(text = "$numB") }

                Spacer(modifier = Modifier.width(5.dp))

                Text(text = "=")

                Spacer(modifier = Modifier.width(5.dp))

                TextField(
                    modifier = Modifier.width(50.dp),
                    value = userinput,
                    onValueChange = { userinput = it },
                    label = { Text("") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(                                                     //TEHTÄVÄT
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                if (vm1.rounds < 10)
                    Text(text = "Exercise: ${vm1.rounds + 1}/10")
                else {
                    Text(text = "")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            if (vm1.rounds < 10) {                                       //TULOSLASKENTA
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Button(onClick = sendbutton)                    //LAMBDA
                    {
                        Text(text = "Vastaa!")
                    }
                }

            } else {
                Column()
                {
                    Button(onClick =
                        { navController.navigate("Teht13d") })
                    { Text(text = "Katso tulokset!") }
                }
            }
        }
    }
}

@Composable
fun Teht13c(navController: NavHostController, vm1: tulosViewModel) {
    var numA by remember { mutableStateOf((1..10).random()) }
    var numB by remember { mutableStateOf((1..10).random()) }
    var userinput by remember { mutableStateOf("") }

    val sendbutton: () -> Unit =
        {
            val numguess = userinput.toIntOrNull()
            if (numguess == numA - numB) {
                vm1.mtulos++
            }
            vm1.rounds++
            numA = (1..10).random()
            numB = (1..10).random()
            userinput = ""
        }

    Box(
        modifier = Modifier.fillMaxSize()
            .padding(0.dp, 100.dp),
        contentAlignment = Alignment.Center
    )
    {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Row(                                                        //OTSIKKO
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    text = "Miinuslaskut",
                    fontSize = 40.sp
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            Row(                                                        //LASKURIVI
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            )

            {
                Text(text = "Laske:")

                Spacer(modifier = Modifier.width(5.dp))

                Box(
                    modifier = Modifier
                        .background(Color.Green)
                        .padding(10.dp)
                )

                { Text(text = "$numA") }

                Spacer(modifier = Modifier.width(5.dp))

                Text(text = "-")

                Spacer(modifier = Modifier.width(5.dp))

                Box(
                    modifier = Modifier
                        .background(Color.Green)
                        .padding(10.dp)
                )

                { Text(text = "$numB") }

                Spacer(modifier = Modifier.width(5.dp))

                Text(text = "=")

                Spacer(modifier = Modifier.width(5.dp))

                TextField(
                    modifier = Modifier.width(50.dp),
                    value = userinput,
                    onValueChange = { userinput = it },
                    label = { Text("") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(                                                     //TEHTÄVÄT
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            )
                {
                    if (vm1.rounds < 10)
                        Text(text = "Exercise: ${vm1.rounds + 1}/10")
                    else {
                        Text(text = "")
                    }
                }

                if (vm1.rounds < 10) {                                       //TULOSLASKENTA
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        Button(onClick = sendbutton)                    //LAMBDA
                        {
                            Text(text = "Vastaa!")
                        }
                    }

                } else {
                    Column()
                    {
                        Button(
                            onClick =
                                { navController.navigate("Teht13d") })
                        { Text(text = "Katso tulokset!") }
                    }
                }
            }
        }
    }


@Composable
fun Teht13d(navController: NavHostController, vm1: tulosViewModel) {

    val resetbutton: () -> Unit = {
        vm1.mtulos = 0
        vm1.ptulos = 0
        navController.navigate("Tehtävä 3.3") {  //Palataan takaisin 13a
            popUpTo("Tehtävä 3.3")               //Poista kaikki backstackista
            {
                inclusive = true
            }                  //Poista myös kohde itse, jotta saadaan kokonaan alustettu stack.
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Laskujen tulokset:", fontSize = 40.sp)

        if (vm1.ptulos == 0 && vm1.mtulos == 0 && vm1.rounds == 0) //Ei tuloksia, näytetään viesti
        {
            Text(
                text = "Ei näytettäviä tuloksia, menehän laskemaan!",
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        }
        if (vm1.ptulos > 0) //Näytetään vain jos pluslaskuja on tehty
        {
            Text(
                text = "Pluslaskut: ${vm1.ptulos.toInt()} pistettä",
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        }
        if (vm1.mtulos > 0) //Näytetään vain jos miinuslaskuja on tehty
        {
            Text(
                text = "Miinuslaskut: ${vm1.mtulos.toInt()} pistettä",
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        }
        if (vm1.ptulos == 0 && vm1.mtulos == 0 && vm1.rounds == 10) {
            Text(
                text = "Voi ei, et saanut yhtään oikein :( ",
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        }

        Button(
            onClick = resetbutton,                //LAMBDA
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

@Composable
fun saannot(navController: NavHostController)
{
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        Text(
            text = "Säännöt:",
            style = MaterialTheme.typography.titleLarge,
            lineHeight = 30.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.width(30.dp))
        Text(
            text = "Laske annetut tehtävät. Tehtävien lopuksi näet tulokset.",
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun tekija(navController: NavHostController)
{
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        Text(
            text = "Tekijä:",
            style = MaterialTheme.typography.titleLarge,
            lineHeight = 30.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.width(30.dp))
        Text(
            text = "maijakuu (2026)",
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        "https://github.com/maijakuu".toUri()
                    )
                    context.startActivity(intent)
                }
        )
    }
}






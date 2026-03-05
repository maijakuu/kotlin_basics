package com.example.mobiiliohjelmointi

import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
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

@Composable
fun Teht10() {
    var rounds by remember { mutableStateOf(0) }
    var numA by remember { mutableStateOf((1..10).random()) }
    var numB by remember { mutableStateOf((1..10).random()) }
    var result by remember { mutableStateOf(0) }
    var userinput by remember { mutableStateOf("") }

    //Lambdan hyödyntäminen Button -logiikassa. En tässä hahmottanut,
    // että miten saisin nämä järkevästi omiin composableihin joten jätin tällä erää tähän.

    val sendbutton: () -> Unit =
        {
            val numguess = userinput.toIntOrNull()
            if (numguess == numA + numB)
            {result++}
            rounds++
            numA = (1..10).random()
            numB = (1..10).random()
            userinput = ""
        }
    val resetbutton: () -> Unit =
        {
            rounds = 0
            result = 0
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
                    text = "Math Quizzer",
                    fontSize = 40.sp
                )
            }

            Row(                                                        //APUOTSIKKO
                modifier = Modifier.padding(20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    text = "Welcome to the Math Quizzer! There will be five short tasks for you to calculate.",
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center
                )
            }


            Spacer(modifier = Modifier.height(20.dp))

            Row(                                                        //LASKURIVI
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            )

            {
                Text(text = "Calculate:")

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
                        .padding(10.dp))

                { Text(text = "$numB") }

                Spacer(modifier = Modifier.width(5.dp))

                Text(text = "=")

                Spacer(modifier = Modifier.width(5.dp))

                TextField(modifier = Modifier.width(50.dp),
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
                if (rounds < 5)
                    Text(text = "Exercise: ${rounds + 1}/5")
                else
                {
                    Text(text="")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            if (rounds < 5) {                                       //TULOSLASKENTA
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Button(onClick = sendbutton)                    //LAMBDA
                    {
                        Text(text = "Send!")
                    }
                }

            } else {
                Column(
                )
                {
                    Text(
                        text = "Your results: $result /5",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(onClick = resetbutton)                       //LAMBDA

                    {Text(text = "Play again!")}
                }
            }
        }
    }
}

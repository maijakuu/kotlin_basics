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
import androidx.compose.material3.Button
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
fun Teht9()
{
    var die1 by remember { mutableStateOf(0) }
    var die2 by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    var rounds by remember { mutableStateOf(0) }

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
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    text = "The Dice Game",
                    fontSize = 40.sp
                )
            }

            Row(
                modifier = Modifier.padding(20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    text = "You will throw two dice: the better number gets counted to the total score. " +
                            "\nIf you throw two of the same numbers, the sum of those will be counted. " +
                            "\nYou have three tries. Good luck! ",
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center
                )
            }

            if (rounds < 3) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Button(
                        onClick = {
                            rounds++
                            die1 = (1..6).random()
                            die2 = (1..6).random()
                            if (die1 == die2)
                                score += (die1 + die2)
                            else
                                score += maxOf(die1, die2)
                        })
                    { Text(text = "THROW!") }
                }
            }
            else
            {
                Text(text = " ")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(text = "POINTS:")

                Spacer(modifier = Modifier.width(5.dp))

                Box(
                    modifier = Modifier
                        .background(Color.Green)
                        .padding(10.dp)
                )

                { Text(text = "$score") }
            }

            Spacer(modifier = Modifier.height(20.dp))

            if (rounds < 3)
            {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Text(
                        text = " "
                    )
                }
            }
            else
            {
                Button(onClick = {
                    if (rounds == 3)
                        rounds = 0
                    score = 0
                })
                { Text(text = "RESTART") }
            }
        }
    }
}


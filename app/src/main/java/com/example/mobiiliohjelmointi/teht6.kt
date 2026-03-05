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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Teht6() {
    var draw1 by remember { mutableIntStateOf(0) }
    var draw2 by remember { mutableIntStateOf(0) }
    var draw3 by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Text(
            text = "Random Number Generator",
            textAlign = TextAlign.Center,
            fontSize = 40.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                draw1 = (0..10).random()
                draw2 = (0..10).filter {it != draw1 }.random()
                draw3 = (0..10).filter {it != draw1 && it != draw2}.random()
            }
        ) {
            Text(text = "DRAW")
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier.background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "$draw1",
                    color = Color.Black,
                    modifier = Modifier.padding(16.dp)
                )
            }
            Box(
                modifier = Modifier.background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "$draw2",
                    color = Color.Black,
                    modifier = Modifier.padding(16.dp)
                )
            }
            Box(
                modifier = Modifier.background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "$draw3",
                    color = Color.Black,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

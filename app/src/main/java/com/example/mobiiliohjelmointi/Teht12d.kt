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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Teht12d() {
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



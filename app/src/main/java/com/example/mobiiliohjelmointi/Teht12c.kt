package com.example.mobiiliohjelmointi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun Teht12c()
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

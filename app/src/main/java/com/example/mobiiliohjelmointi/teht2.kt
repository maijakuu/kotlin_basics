package com.example.mobiiliohjelmointi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Teht2()
{ //Ruutuun tehty Box, jonka sisällä Column.
// Columnin sisällä kolme riviä, joiden sisällä Box -elementtejä tarvittava määrä.
// Box -elementin sisällä Text -elementti.
// Nämä eroteltu toisistaan Spacerin avulla
    Box(            //Ruudun kattava container
        modifier = Modifier.fillMaxSize()
    ) {
        Column(     //Sarake
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(    //Rivi 1
                modifier = Modifier
                    .padding(25.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.Blue)
                        .size(100.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "BOX1",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))        //Välistäjä

                Box(
                    modifier = Modifier
                        .background(Color.Blue)
                        .size(100.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "BOX2",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
            }

            HorizontalDivider(      //Jakaja
                modifier = Modifier.padding(horizontal = 16.dp),
                thickness = 2.dp,
                color = Color.Black
            )

            Row(        //Rivi 2
                modifier = Modifier
                    .padding(25.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.LightGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "BOX3",
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))        //Välistäjä

                Box(
                    modifier = Modifier
                        .background(Color.LightGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "BOX4",
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp)) //Välistäjä

                Box(
                    modifier = Modifier
                        .background(Color.LightGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "BOX5",
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))       //Välistäjä

                Box(
                    modifier = Modifier
                        .background(Color.LightGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "BOX6",
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
            }

            HorizontalDivider(      //Jakaja
                modifier = Modifier.padding(horizontal = 16.dp),
                thickness = 2.dp,
                color = Color.Black
            )

            Row(        //Rivi 3
                modifier = Modifier
                    .padding(25.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.Red)
                        .size(100.dp),
                    contentAlignment = Alignment.Center

                ) {
                    Text(
                        text = "BOX7",
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))        //Välistäjä

                Box(
                    modifier = Modifier
                        .background(Color.Red)
                        .size(100.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "BOX8",
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}
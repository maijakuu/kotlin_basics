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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Teht8()
{
    var homescore by remember { mutableStateOf(0) }
    var homefoul by remember { mutableStateOf(0) }
    var guestscore by remember { mutableStateOf(0) }
    var guestfoul by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize()
            .padding(0.dp, 100.dp),
        contentAlignment = Alignment.TopCenter
    ){
        Row()
        {
            //==================================== HOME-SARAKE===========================================//

            Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) //Sarake1 HOME
            {
                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) //Virheet
                {
                    Text(text= "Virheet")

                    Spacer(modifier = Modifier.width(5.dp))

                    Box(modifier = Modifier.background(if (homefoul >= 3) Color.Red else Color.Green)
                        .padding(20.dp))
                    {Text(text = "$homefoul")}
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) //KOTI
                {
                    Text(text= "KOTI")
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) //SCORE
                {
                    Box(modifier = Modifier.background(Color.Yellow)
                        .padding(20.dp))
                    { Text(
                        text = "$homescore",
                        fontSize = 20.sp)}
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) //+1
                {
                    Button(
                        onClick = {homescore += 1})
                    {Text(text= "+1p")}
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) //+2
                {
                    Button(onClick ={homescore += 2})
                    {Text(text = "+2p")}
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) //+3
                {
                    Button(onClick ={
                        homescore += 3})
                    {Text(text= "+3p")}
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) //virhepiste
                {
                    Button(onClick ={
                        homefoul += 1
                        if (homescore > 0)
                            homescore -= 1})
                    {Text(text= "Virhe")}
                }
            }

            Spacer(modifier = Modifier.width(40.dp))

//====================================== GUEST-SARAKE=============================================//

            Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) //Sarake 2 GUEST
            {
                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) //virhe
                {
                    Text(text= "Virheet")

                    Spacer(modifier = Modifier.width(5.dp))

                    Box(modifier = Modifier
                        .background(if (guestfoul >= 3) Color.Red else Color.Green)
                        .padding(20.dp))

                    {Text(text = "$guestfoul")}
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) //vieras
                {Text(text= "VIERAS")}

                Spacer(modifier = Modifier.height(20.dp))

                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) //pisteet
                {
                    Box(modifier = Modifier.background(Color.Yellow)
                        .padding(20.dp))
                    {Text(text = "$guestscore", fontSize = 20.sp)}
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(horizontalArrangement = Arrangement.Center, //+1
                    verticalAlignment = Alignment.CenterVertically)
                {
                    Button(
                        onClick ={guestscore += 1})
                    { Text(text= "+1p")}
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) //+2
                {
                    Button(onClick ={guestscore += 2})
                    {Text(text= "+2p")}
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) //+3
                {
                    Button(onClick ={guestscore += 3})
                    {Text(text= "+3p")}
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) //virhepiste
                {
                    Button(onClick ={
                        guestfoul += 1
                        if (guestscore > 0)
                            guestscore -= 1})
                    {Text(text= "Virhe")}
                }
            }
        }
    }
}
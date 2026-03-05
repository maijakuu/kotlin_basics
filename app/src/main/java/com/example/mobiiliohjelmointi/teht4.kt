package com.example.mobiiliohjelmointi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Teht4() {
    Box(            //Ruudun kattava container
        modifier = Modifier.fillMaxSize()

    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        )
        {
            Row(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(40.dp)
            )
            {
                Button(
                    onClick = {})
                {
                    Text(
                        text = stringResource(R.string.personal_info),
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                    )
                }
            }
            Row(
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(20.dp)
            )
            {
                Text(
                    text = stringResource(R.string.sportapp),
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(30.dp)
                )
            }
            Row(
                modifier = Modifier
                    .padding(20.dp),
            )
            {
                Button(
                    onClick = {})
                {
                    Text(
                        text = stringResource(R.string.swimming),
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .width(50.dp)
                    )
                }
                Spacer(modifier = Modifier.width(25.dp))
                Button(
                    onClick = {})
                {
                    Text(
                        text = stringResource(R.string.running),
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .width(50.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(20.dp),
            )
            {
                Button(
                    onClick = {})
                {
                    Text(
                        text = stringResource(R.string.cycling),
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .width(50.dp)
                    )
                }

                Spacer(modifier = Modifier.width(25.dp))

                Button(
                    onClick = {})
                {
                    Text(
                        text = stringResource(R.string.gym),
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .width(50.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(20.dp),
            )
            {
                Button(
                    onClick = {})
                {
                    Text(
                        text = stringResource(R.string.skiing),
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .width(50.dp)
                    )
                }
                Spacer(modifier = Modifier.width(25.dp))
                Button(
                    onClick = {})
                {
                    Text(
                        text = stringResource(R.string.dancing),
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .width(50.dp)
                    )
                }
            }
            Box(modifier = Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter)
            {
                Image(painterResource(R.drawable.sports), contentDescription = null)
            }
        }
    }
}

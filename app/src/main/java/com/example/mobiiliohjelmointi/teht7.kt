package com.example.mobiiliohjelmointi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Teht7() {
    var currentImageIndex by remember { mutableStateOf(0) }
    val imagenum = currentImageIndex + 1
    val images = listOf(
        R.drawable.taavi1,
        R.drawable.taavi2,
        R.drawable.taavi3,
        R.drawable.taavi4,
    )


    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally

    )

    {
        Box(modifier = Modifier.fillMaxWidth()
            .fillMaxHeight(0.85f),
            contentAlignment = Alignment.TopCenter)
        {
            ShowImage(images[currentImageIndex])

            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(5.dp, 80.dp, 5.dp, 5.dp)
            )
            {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .shadow(15.dp, shape = RoundedCornerShape(12.dp), clip = false)
                        .background(
                            color = Color.White.copy(alpha = 0.5f),  // translucent white
                            shape = RoundedCornerShape(12.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "$imagenum/4",
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp)
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom

        ) {
            Row(
                modifier = Modifier
                    .background(Color.Transparent)
                    .padding(5.dp),
            )
            {
                Text(
                    text = "Taavi Cam",
                    fontSize = 25.sp,
                    textAlign = TextAlign.Justify,
                    color = Color.White,
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center

            ) {
                Button(
                    onClick =
                        {
                            if (currentImageIndex >0)
                            {
                                currentImageIndex--
                            }
                            else
                            {
                                currentImageIndex = 3
                            }

                        })
                {
                    Text(
                        text = "Previous",
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                    )
                }

                Spacer(modifier = Modifier.width(100.dp))

                Button(
                    onClick =
                        {
                            if (currentImageIndex < 3) {
                                currentImageIndex++
                            } else {
                                currentImageIndex = 0
                            }
                        })

                {
                    Text(
                        text = "Next",
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                    )
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}

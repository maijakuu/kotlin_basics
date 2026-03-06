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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri

@Composable
fun Home()
{
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Black, Color(0xFFB5A9FF), Color.White),
                        startY = 800f,
                        endY = 2400f
                    )
                )
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {
            Image(
                painter = painterResource(id = R.drawable.kotlinperusteet),
                contentDescription = "kotlin",
                modifier = Modifier
                    .size(width = 500.dp, height = 250.dp)
                    .padding(end = 8.dp)
            )

            Text(
                text = "Tämä projekti koostuu useasta erilaisesta tehtävästä, jotka olivat osaa Mobiiliohjelmointi -kurssikokonaisuutta. " +
                        "Tehtävät avautuvat valikosta.",
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(16.dp)
            )
            Text(
                text = "This project was carried out using finnish as the main language, " +
                        "which is why the comments, variables and the overall execution of the app is mainly in finnish. " +
                        "At some point I shall do the proper language versions.",
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(16.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            )
                {
                    Image(
                        painter = painterResource(id = R.drawable.githublogo),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .size(32.dp)
                            .padding(end = 8.dp)
                    )

                    Text(
                        text = "maijakuu (2026)",
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        textDecoration = TextDecoration.Underline,
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
    }
}
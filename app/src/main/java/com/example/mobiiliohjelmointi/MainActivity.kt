package com.example.mobiiliohjelmointi

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.snapping.SnapPosition
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
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobiiliohjelmointiApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)

//YLÄKULMAN MENU
@Composable
fun MobiiliohjelmointiApp() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    var selectedItem by remember { mutableStateOf("Home") }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                val items = listOf("Home", "Tehtävä 1.1", "Tehtävä 1.2", "Tehtävä 1.3", "Tehtävä 1.4",
                    "Tehtävä 2.1", "Tehtävä 2.2", "Tehtävä 2.3", "Tehtävä 2.4", "Tehtävä 2.5", "Tehtävä 2.6",
                    "Tehtävä 3.1", "Tehtävä 3.2", "Tehtävä 3.3")

                Text("TEHTÄVÄT", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleMedium)
                items.forEach { item ->
                    NavigationDrawerItem(
                        label = { Text(item) },
                        selected = selectedItem == item,
                        onClick = {
                            selectedItem = item
                            navController.navigate(item) { launchSingleTop = true } // navigate
                            scope.launch { drawerState.close() }
                        }
                    )
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    modifier= Modifier.background(Transparent),
                    title = { Text("Mobiiliohjelmointi") },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                 )
                )
            }
        ) { padding ->
            NavHost(
                //modifier = Modifier.padding(padding),
                navController = navController,
                startDestination = "Tehtävä 3.1",

            ) {
                composable("Home") { Home() }
                composable("Tehtävä 1.1") { Teht1() }
                composable("Tehtävä 1.2") { Teht2() }
                composable("Tehtävä 1.3") { Teht3() }
                composable("Tehtävä 1.4") { Teht4() }
                composable("Tehtävä 2.1") { Teht5() }
                composable("Tehtävä 2.2") { Teht6() }
                composable("Tehtävä 2.3") { Teht7() }
                composable("Tehtävä 2.4") { Teht8() }
                composable("Tehtävä 2.5") { Teht9() }
                composable("Tehtävä 2.6") { Teht10()}
                composable("Tehtävä 3.1") { Teht11()}
                composable("Tehtävä 3.2") { Teht12()}
                composable("Tehtävä 3.3") { Teht13()}
            }
        }
    }
}



@Composable
fun Home()
{
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.home2),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.White, Color(0xCCCB8FFA)),
                        startY = 0.0f,
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
            Text(
                text = "MOBIILIOHJELMOINTI, KURSSITEHTÄVÄT KEVÄT 2026",
                style = MaterialTheme.typography.titleLarge,
                lineHeight = 30.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(
                        Color(0xCCCB8FFA),
                        shape = RoundedCornerShape(100.dp)
                    )
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.width(30.dp))

            Text(
                text = "Maija Kuusela, R54T24S",
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.width(30.dp))

            Text(
                text = "Valikosta aukeavat kaikki kurssillle kuuluvat tehtävät",
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(16.dp)

            )
        }
    }
}
@Composable
fun Teht1()
{
    val muoto = RoundedCornerShape(200.dp)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "nappi1",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .border(2.dp, Color.Magenta, muoto)
                    .background(Color.Black, muoto)
                    .padding(horizontal = 24.dp, vertical = 12.dp)
            )

            Spacer(modifier = Modifier.width(80.dp))

            Text(
                text = "nappi2",
                color = Color.Blue,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .border(2.dp, Color.Black, muoto)
                    .background(Color.Magenta, muoto)
                    .padding(horizontal = 24.dp, vertical = 12.dp)
            )

        }
    }
}
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
@Composable
fun Teht3()
{
    var name by remember { mutableStateOf("")}
    var address by remember { mutableStateOf("")}
    var number by remember { mutableStateOf("")}
    var other by remember { mutableStateOf("")}


    Column(
        modifier = Modifier.fillMaxSize()
        .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = "CONTACT FORM",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier
                .padding(16.dp, 50.dp, 16.dp, 16.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        TextField(
            modifier = Modifier.background(Color.LightGray),
            value = name,
            onValueChange = { name = it },
            label = { Text("Username") }
        )
        TextField(
            modifier = Modifier.background(Color.LightGray),
            value = address,
            onValueChange = { address = it },
            label = { Text("Address") }
        )
        TextField(
            modifier = Modifier.background(Color.LightGray),
            value = number,
            onValueChange = { number = it },
            label = { Text("Phone number") }
        )
        TextField(
            modifier = Modifier.background(Color.LightGray),
            value = other,
            onValueChange = { other = it },
            label = { Text("Other things") }
        )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick ={},
            modifier = Modifier
                .padding(100.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow))
        {
            Text(
                text = "SAVE",
                fontSize = 50.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                modifier = Modifier
                    .padding(20.dp)
            )
        }
    }


    }
}
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

@Composable
fun Teht5() {
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Row(
            modifier = Modifier
                .background(Color.LightGray)
                .padding(5.dp)

        )
        {
            Text(
                text = "Visitor Counter",
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                modifier = Modifier
                    .padding(30.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 100.dp, 10.dp, 10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    count++
                })
            {
                Text(
                    text = "Add visitor",
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = {
                    if (count > 0) count--
                })
            {
                Text(
                    text = "Decrease visitor",
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))

        Row(
            horizontalArrangement = Arrangement.Center
        )
        {
            Box(
                modifier = Modifier
                    .background(Color.LightGray, RoundedCornerShape(12.dp))
                    .border(1.dp, Color.Black, RoundedCornerShape(12.dp))
                    .padding(horizontal = 24.dp, vertical = 12.dp)
            ) {
                Text(
                    text = count.toString(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
            Spacer(modifier = Modifier.height(30.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        if (count > 0) count = 0
                    }
                ) {
                    Text("Reset")
                }
            }
        }
    }

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

@Composable
fun Teht11() {
    var name by remember { mutableStateOf("")}
    var address by remember { mutableStateOf("")}

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(5.dp, 50.dp, 5.dp, 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = "Tuotteen tiedot",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier
                .padding(16.dp, 50.dp, 16.dp, 16.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        TextField(
            modifier = Modifier.background(Color.LightGray),
            value = name,
            onValueChange = { name = it },
            label = { Text("Tuotteen nimi") }
        )
        TextField(
            modifier = Modifier.background(Color.LightGray),
            value = address,
            onValueChange = { address = it },
            label = { Text("Tuotteen hinta euroissa") }
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row() {
                Button(
                    onClick ={},
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
                Button(
                    onClick ={},
                    modifier = Modifier
                        .padding(20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow))
                {
                    Text(
                        text = "Yhteenveto",
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

@Composable
fun Teht12() {
    TODO("Not yet implemented")
}

@Composable
fun Teht13() {
    TODO("Not yet implemented")
}
@Composable
fun ShowImage(@DrawableRes imageResId: Int) {
    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(imageResId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp) // height of gradient from bottom
                .align(Alignment.BottomCenter) // pinned to bottom
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                          Color.Transparent,
                          Color.Black.copy(alpha = 0.9f)
                        ),
                        startY = 0f,
                        endY = 350f // controls fade speed
                    )
                )
        )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .align(Alignment.TopCenter)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.White.copy(alpha = 0.9f),
                                Color.Transparent
                            ),
                            startY = 0f,
                            endY = 350f // controls fade speed
                        )
                    )
            )

    }
}


package com.example.learningjetpackcompose.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalFoundationApi
@Composable
fun HomeScreen()
{
    Box(modifier = Modifier
        .background(Color.Blue)
        .fillMaxSize())
    {
        Column {

            HeaderSection("ehsaen")
            UnderHeaderList()
            CurrentTrack("ehsan")
            GirdList(listOf(HomeScreenn("ehsan","kolivand"),
                HomeScreenn("reza","rezayi"), HomeScreenn("ali","hossin"), HomeScreenn("ali","hossin")))
        }
    }
}


@Composable
fun HeaderSection(name:String)
{
    Row(horizontalArrangement = Arrangement.SpaceBetween
        ,verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(text = "Good morning $name",
            style = MaterialTheme.typography.h5,
                color = Color.White
            )
            Text(text = "We wish you have good day",
                style = MaterialTheme.typography.body1,
            color = Color.White)

        }
        Icon(painter = painterResource(id =
        android.R.drawable.ic_menu_search),
            contentDescription = "Search",
            tint=Color.White,
        modifier = Modifier.size(24.dp), )

    }
}

@Composable
fun UnderHeaderList(listOfName:List<String>
                    = listOf("ehsan","Mohammad","ali","aghil",
                                                        "keyone","milad"))
{
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
   LazyRow{
       items(listOfName.size) {
           Box(contentAlignment = Alignment.Center, modifier
           = Modifier
               .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
               .clickable {
                   selectedChipIndex = it
               }
               .clip(RoundedCornerShape(10.dp))
               .background(
                   if (selectedChipIndex == it) Color.Black else Color.Cyan
               )
               .padding(15.dp)) {

               Text(text = listOfName[it], color = Color.White)

           }
       }
   }
}

@Composable
fun CurrentTrack(name: String)
{
    Row(verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier
        .padding(15.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(Color.White)
        .padding(horizontal = 15.dp, vertical = 20.dp)
        .fillMaxWidth()) {
        Column {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.h5
            )
            Text(
                text = "Meditation • 3-10 min",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.White)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = android.R.drawable.ic_media_play),
                contentDescription = "Play",
                tint = Color.Black,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun GirdList(homeScreenn: List<HomeScreenn>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Features",style = MaterialTheme.typography.h4,
        color = Color.White)
        LazyVerticalGrid(cells = GridCells.Fixed(2)
            ,  contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ){

            items(homeScreenn.size)
            {
                GrideItem(homeScreenn[it])
            }

        }

        
    }
}

@Composable
fun GrideItem(homeScreenn: HomeScreenn) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.DarkGray)

    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
        ){
            Text(text = homeScreenn.title,
            style = MaterialTheme.typography.h5,
            lineHeight = 25.sp,
            modifier = Modifier.align(Alignment.TopCenter))
            Icon(painter = painterResource(id = android.R.drawable.checkbox_on_background,
            ), contentDescription = "it's just for test")
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun PreviewScreen()
{

    HomeScreen()
}

data class HomeScreenn(val title:String, val body:String)
package com.example.meditationuicompose

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationuicompose.ui.theme.AquaBlue
import com.example.meditationuicompose.ui.theme.Beige1
import com.example.meditationuicompose.ui.theme.Beige2
import com.example.meditationuicompose.ui.theme.Beige3
import com.example.meditationuicompose.ui.theme.BlueViolet1
import com.example.meditationuicompose.ui.theme.BlueViolet2
import com.example.meditationuicompose.ui.theme.BlueViolet3
import com.example.meditationuicompose.ui.theme.ButtonBlue
import com.example.meditationuicompose.ui.theme.DarkerButtonBlue
import com.example.meditationuicompose.ui.theme.DeepBlue
import com.example.meditationuicompose.ui.theme.LightGreen1
import com.example.meditationuicompose.ui.theme.LightGreen2
import com.example.meditationuicompose.ui.theme.LightRed
import com.example.meditationuicompose.ui.theme.OrangeYellow1
import com.example.meditationuicompose.ui.theme.OrangeYellow2
import com.example.meditationuicompose.ui.theme.OrangeYellow3
import com.example.meditationuicompose.ui.theme.TextWhite

@Composable
fun HomeScreen(){

    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()
        .padding(bottom = 30.dp)
    ){
        Column(modifier = Modifier.padding(top = 30.dp,)) {

            //val scrollState = rememberScrollState()
            GreetingSection()
            ChipSection(chips = listOf("Sweet sleep", "Insomnia", "Relax"))
            CurrentMeditation()
            FeatureSection(features = listOf(
                Feature(
                    title = "Sleep meditation",
                    R.drawable.ic_headphone,
                    BlueViolet1,
                    BlueViolet2,
                    BlueViolet3
                ),

                Feature(
                    title = "Tips for sleeping",
                    R.drawable.ic_videocam,
                    LightGreen1,
                    LightGreen2,
                    AquaBlue
                ),

                Feature(
                    title = "Night island",
                    R.drawable.ic_headphone,
                    OrangeYellow1,
                    OrangeYellow2,
                    OrangeYellow3
                ),
                Feature(
                    title = "Calming sounds",
                    R.drawable.ic_headphone,
                    Beige1,
                    Beige2,
                    Beige3
                )
            )
                ,)
        }

        BottomMenu(
            items = listOf(
                BottomMenuContent("Home", R.drawable.ic_home),
                BottomMenuContent("Meditate", R.drawable.ic_bubble),
                BottomMenuContent("Sleep", R.drawable.ic_moon),
                BottomMenuContent("Music", R.drawable.ic_music),
                BottomMenuContent("Profile", R.drawable.ic_profile),
            ),
            modifier = Modifier
                .align(Alignment.BottomCenter))
    }
}

@Composable
fun GreetingSection(
    name : String = "KellyR"
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp)
    ){

        Column(
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Good Morning, $name",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 6.dp)
            )
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.bodySmall
            )
        }
        Icon(
            painter = painterResource(R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )

    }
}


@Composable
fun ChipSection(
    chips: List<String>
){
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(chips.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ){
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}


@Composable
fun CurrentMeditation(
    color: Color = LightRed
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ){

        Column() {
        Text(
            text = "Daily Thought!",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = "Meditation 3-10 min",
            style = MaterialTheme.typography.bodySmall,
            color = TextWhite
        )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(52.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(4.dp)
        ){
            Icon(painter = painterResource(
                R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.padding(14.dp))
        }

    }
}

@Composable
fun FeatureSection(features: List<Feature>){

    Column (
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Text(
            text = "Features",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
          //  verticalArrangement = Arrangement.spacedBy(8.dp),
         //   horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
            ) {
            items(features.size){
                FeatureItem(feature = features[it])
            }
        }
    }

}

@Composable
fun FixedGrid(){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) { }
}


@Composable
fun FeatureItem(
    feature: Feature
){
    Column (
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
        ){
            Text(
                text = feature.title,
                style = MaterialTheme.typography.headlineMedium,
                lineHeight = 24.sp,
                modifier = Modifier.align(Alignment.TopStart)

            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )

            Text("Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {

                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
                )

        }

    }
}

@Composable
fun BottomMenu(
    items : List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighColor : Color = ButtonBlue,
    activeTextColor : Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
){

    var selectedIndex by remember {
        mutableStateOf(0)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ){
        items.forEachIndexed { index, item ->

            BottomMenuItem(
                item = item,
                isSelected = index == selectedIndex,
                activeHighColor = activeHighColor,
                activeTextColor =activeTextColor,
                inactiveTextColor = inactiveTextColor
            )

            {
                selectedIndex = index
            }

        }
    }
    
}

@Composable
fun BottomMenuItem(
    item : BottomMenuContent,
    isSelected: Boolean = false,
    activeHighColor : Color = ButtonBlue,
    activeTextColor : Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit

){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighColor else Color.Transparent)
                .padding(12.dp)
        ){
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if(isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(16.dp)
            )
        }
        Text(
            text = item.title,
            color = if(isSelected) activeTextColor else inactiveTextColor,
            fontSize = 12.sp
        )
    }


}

data class BottomMenuContent(
    val title : String,
    @DrawableRes val iconId : Int,
)
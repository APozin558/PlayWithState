package com.jc.study.play.with.state.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jc.study.play.with.state.R
import com.jc.study.play.with.state.ui.models.MainScreenModel
import com.jc.study.play.with.state.ui.theme.cBoxItemColor
import com.jc.study.play.with.state.ui.theme.cPrimaryColor
import com.jc.study.play.with.state.ui.theme.cSecondaryColor
import com.jc.study.play.with.state.ui.theme.cTextColor

@Composable
fun MainScreen(scrModel: MainScreenModel) {
    var msLocalCounter by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        UxHeaderItem(headerTitleTxt = "Screen - Variable")

        UxLineItem(descriptionTxt = "MAIN SCREEN",
            counter = msLocalCounter,
            onButtonClick = { msLocalCounter += 1 },
            isDivider = false
        )

        UxLineItem(descriptionTxt = "Screen Model - State",
            counter = scrModel.smCounter,
            onButtonClick = {scrModel.incrementScreenCounter()},
            isDivider = true
        )

        UxLineItem(descriptionTxt = "App Model - Data model",
            counter = scrModel.getCurrentCounter(),
            onButtonClick = {scrModel.onCounterClick()},
            isDivider = true
        )

        UxLineItem(descriptionTxt = "Screen Model - Singleton",
            counter = scrModel.getSingletonCounter(),
            onButtonClick = { scrModel.incrementSingletonCounter() },
            isDivider = true
        )

        val scrExampleCounter = scrModel.appDataExample.collectAsState().value

        UxLineItem(descriptionTxt = "Screen Model - Example",
            counter = scrExampleCounter.counter,
            onButtonClick = { scrModel.incrementExampleCounter() },
            isDivider = true
        )
        
        Spacer(modifier = Modifier.weight(1.0f))
        
        UxBottomSection(onPauseButtonClicked = {scrModel.onPauseButtonClicked()})
    }
}

@Composable
fun UxBottomSection(onPauseButtonClicked: () -> Unit) {
    Row(
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth()
            .background(color = cPrimaryColor)
    ) {
        Spacer(modifier = Modifier.weight(1.0f))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.clickable(onClick = onPauseButtonClicked)
        ) {
            Text(text = "START/PAUSE", color = cSecondaryColor, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.width(10.dp))
    }

}

@Composable
fun UxHeaderItem(headerTitleTxt: String = "DEFAULT"){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth()
            .background(color = cPrimaryColor)
    ) {
        Text(text = headerTitleTxt, color = cSecondaryColor, fontWeight = FontWeight.Bold, fontSize = 24.sp)
    }
}

@Composable
fun UxLineItem(descriptionTxt: String, counter: Int, onButtonClick: () -> Unit, isDivider: Boolean = true){

    if (isDivider) Divider(color = Color.LightGray, thickness = 2.dp)

    Spacer(modifier = Modifier.height(5.dp))
    Row(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(color = cBoxItemColor)
    ) {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .height(50.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.ux_star_icon), contentDescription = descriptionTxt)
        }
        Spacer(modifier = Modifier.width(5.dp))
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier.height(50.dp)
        ) {
            Text(text = "$descriptionTxt : $counter", color = cTextColor, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.width(5.dp))
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .height(50.dp)
                .clickable(onClick = onButtonClick)
        ){
            Image(painter = painterResource(id = R.drawable.ux_add_icon), contentDescription = "increment counter" )
        }
    }
}
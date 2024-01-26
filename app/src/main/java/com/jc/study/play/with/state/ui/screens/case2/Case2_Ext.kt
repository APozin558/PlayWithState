package com.jc.study.play.with.state.ui.screens.case2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_SCREEN_FIRST
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_SCREEN_SECOND
import com.jc.study.play.with.state.ext.ExtLogic2.case2getDaytimeIconById
import com.jc.study.play.with.state.ext.ExtLogic2.case2getHeaderIconById
import com.jc.study.play.with.state.ext.ExtLogic2.case2getNavigationIconByID
import com.jc.study.play.with.state.ext.ExtLogic2.case2getRoundIconById
import com.jc.study.play.with.state.ui.theme.cAccentColor
import com.jc.study.play.with.state.ui.theme.cPrimaryColor
import com.jc.study.play.with.state.ui.theme.cSecondaryColor

@Composable
fun Case2uxHeader(
    headerLbl: String = "Default",
    pausePressed: () -> Unit,
    gameSpeedState: Int,
    gameDay: Int,
    gameDaytime: Int,
    gameRound: Int
){
    val pauseImageId = case2getHeaderIconById(gameSpeedState)
    val daytimeImageId = case2getDaytimeIconById(gameDaytime)

    Row(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(color = cAccentColor)
    ) {
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            modifier = Modifier.align(CenterVertically),
            text = headerLbl,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = cSecondaryColor
        )
        Spacer(modifier = Modifier.weight(1.0f))
        Text(
            modifier = Modifier.align(CenterVertically),
            text = "Day: $gameDay",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = cSecondaryColor
        )
        Box(modifier = Modifier
            .height(50.dp)
            .width(50.dp)
        ){
            Image(
                modifier = Modifier
                    .align(TopCenter)
                    .padding(top = 5.dp),
                painter = painterResource(id = daytimeImageId),
                contentDescription = "daytime"
            )
            Row(
                modifier = Modifier
                    .align(BottomCenter)
                    .padding(bottom = 5.dp)
            ) {
                for (i in 0..3){
                    Image(
                        painter = painterResource(id = case2getRoundIconById(gameRound = gameRound, i = i)),
                        contentDescription = "round"
                    )
                }
            }

        }
        Box(contentAlignment = Center,
            modifier = Modifier
                .height(50.dp)
                .width(40.dp)
                .clickable(onClick = pausePressed)
        ){
            Image(painter = painterResource(id = pauseImageId), contentDescription = "play/pause")
        }
        Spacer(modifier = Modifier.width(5.dp))
    }
}

@Composable
fun Case2uxTopNavigationTab(nextScreenPressed: () -> Unit,
                            currentScreen: Int,
                            navigateToPressed: (Int) -> Unit
){
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(color = cPrimaryColor)
    ) {
        Box(
            contentAlignment = Center,
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp)
                .size(50.dp)
                .clickable(onClick = {navigateToPressed(CASE_2_SCREEN_FIRST)})
        ){
            Image(
                painter = painterResource(
                    id = case2getNavigationIconByID(
                        currentScreenId = currentScreen,
                        screenId = CASE_2_SCREEN_FIRST)
                ),
                contentDescription = "Navigation 01"
            )
        }
        Box(
            contentAlignment = Center,
            modifier = Modifier
                .padding(start = 5.dp)
                .size(50.dp)
                .clickable(onClick = {navigateToPressed(CASE_2_SCREEN_SECOND)})
        ){
            Image(
                painter = painterResource(
                    id = case2getNavigationIconByID(
                        currentScreenId = currentScreen,
                        screenId = CASE_2_SCREEN_SECOND)
                ),
                contentDescription = "Navigation 02"
            )
        }
    }
}

@Composable
fun Case2uxBottomTab(nextScreenPressed: () -> Unit){
    Row(
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth()
            .background(cPrimaryColor)
    ) {
        Spacer(modifier = Modifier.weight(1.0f))
        Box(
            modifier = Modifier
                .background(color = cAccentColor)
                .clickable(onClick = nextScreenPressed),
            contentAlignment = Alignment.Center
        ) {
            Text(text = " NEXT >> ", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = cSecondaryColor)
        }
    }
}
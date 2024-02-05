package com.jc.study.play.with.state.ui.screens.case3.ux

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jc.study.play.with.state.constants.CommonConstants
import com.jc.study.play.with.state.ext.case3.ExtCase3ImageIcons.getDayPeriodIconById
import com.jc.study.play.with.state.ext.case3.ExtCase3ImageIcons.getHeaderSectionIconById
import com.jc.study.play.with.state.ext.case3.ExtCase3ImageIcons.getNavigationIconById
import com.jc.study.play.with.state.ext.case3.ExtCase3ImageIcons.getPauseIconByIsStarted
import com.jc.study.play.with.state.ext.case3.ExtCase3ImageIcons.getRoundMarkerIconById
import com.jc.study.play.with.state.ext.case3.ExtCase3Labels.getDayPeriodTitleById
import com.jc.study.play.with.state.ext.case3.ExtCase3Labels.getScreenTitleById
import com.jc.study.play.with.state.models.case3.Case3GameCommonData
import com.jc.study.play.with.state.ui.theme.cHeaderColor
import com.jc.study.play.with.state.ui.theme.cSecondaryColor
import com.jc.study.play.with.state.ui.theme.cTextAltColor
import com.jc.study.play.with.state.ui.theme.cTextWColor

@Composable
fun Case3uxNavigationSection(
    currentScreen:Int,
    onNavigationClicked: (Int) -> Unit
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .background(color = cSecondaryColor)
    ){
        Spacer(modifier = Modifier.width(5.dp))
        Case3NavigationIconSection(
            currentScreen = currentScreen,
            screenId = CommonConstants.SCREEN_OVERVIEW,
            onNavigationClicked = { onNavigationClicked(CommonConstants.SCREEN_OVERVIEW)}
        )
        Spacer(modifier = Modifier.width(5.dp))
        Case3NavigationIconSection(
            currentScreen = currentScreen,
            screenId = CommonConstants.SCREEN_PEOPLE,
            onNavigationClicked = { onNavigationClicked(CommonConstants.SCREEN_PEOPLE)}
        )
        Spacer(modifier = Modifier.width(5.dp))
        Case3NavigationIconSection(
            currentScreen = currentScreen,
            screenId = CommonConstants.SCREEN_BUILDINGS,
            onNavigationClicked = { onNavigationClicked(CommonConstants.SCREEN_BUILDINGS)}
        )
        Spacer(modifier = Modifier.width(5.dp))
        Case3NavigationIconSection(
            currentScreen = currentScreen,
            screenId = CommonConstants.SCREEN_LOCATIONS,
            onNavigationClicked = { onNavigationClicked(CommonConstants.SCREEN_LOCATIONS)}
        )
        Spacer(modifier = Modifier.weight(1.0f))
    }

}

@Composable
fun Case3NavigationIconSection(currentScreen: Int, screenId: Int, onNavigationClicked: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxHeight()
            .width(50.dp)
            .padding(vertical = 4.dp)
            .clickable(onClick = onNavigationClicked)
            .background(color = cHeaderColor, shape = CircleShape)
            .border(width = 1.dp, color = cTextAltColor, shape = CircleShape)
    ) {
        Image(
            painter = painterResource(id = getNavigationIconById(screenId = screenId, isCurrentScreen = (currentScreen == screenId))),
            contentDescription = "navigation icon"
        )
    }
}

@Composable
fun Case3uxHeaderSection(
    currentScreen: Int,
    onPauseClicked: () -> Unit,
    isGameStarted: Boolean,
    commonData: State<Case3GameCommonData>
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .background(color = cHeaderColor)
        .padding(2.dp)
    ) {
        Spacer(modifier = Modifier.width(5.dp))
        Case3HeaderIconSection(currentScreenId = currentScreen)
        Spacer(modifier = Modifier.width(5.dp))
        Case3HeaderTitleSection(currentScreenId = currentScreen)
        Spacer(modifier = Modifier.weight(1.0f))
        Case3HeaderDateTimeSection(commonData = commonData)
        Spacer(modifier = Modifier.width(5.dp))
        Case3HeaderResumeSection(isGameStarted = isGameStarted, onPauseClicked = onPauseClicked)
        Spacer(modifier = Modifier.width(5.dp))
    }
}

@Composable
fun Case3HeaderDateTimeSection(commonData: State<Case3GameCommonData>) {
    val dayN = commonData.value.dayN
    val dayPeriod = commonData.value.dayPeriod
    val roundNumber = commonData.value.roundNumber

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxHeight()
    ){
        Column {
            Text(text = "DAY: $dayN", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = cTextWColor)
            Text(text = getDayPeriodTitleById(dayPeriod = dayPeriod, roundN = roundNumber), fontSize = 10.sp, fontWeight = FontWeight.Bold, color = cTextWColor)
        }
        Spacer(modifier = Modifier.width(5.dp))
        Box(modifier = Modifier
            .height(50.dp)
            .width(50.dp)
        ){
            Image(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 5.dp),
                painter = painterResource(id = getDayPeriodIconById(dayPeriod = dayPeriod)),
                contentDescription = "day"
            )
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 5.dp)
            ) {
                //for (i in 1..CommonConstants.TIME_PERIOD_LENGTH){
                for (i in 0 until CommonConstants.TIME_PERIOD_LENGTH)
                    Image(
                        painter = painterResource(id = getRoundMarkerIconById(gameRound = roundNumber, i = i)),
                        contentDescription = "round"
                    )
            }
        }

    }
}

@Composable
fun Case3HeaderIconSection(currentScreenId: Int) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxHeight()
    ) {
        Image(painter = painterResource(id = getHeaderSectionIconById(currentScreenId)), contentDescription = "screen icon")
    }
}

@Composable
fun Case3HeaderResumeSection(isGameStarted: Boolean, onPauseClicked: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxHeight()
            .clickable(onClick = onPauseClicked)
    ) {
        Image(painter = painterResource(id = getPauseIconByIsStarted(isGameStarted)), contentDescription = "start/pause")
    }
}

@Composable
fun Case3HeaderTitleSection(currentScreenId: Int) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier.fillMaxHeight()
    ){
        Text(text = getScreenTitleById(screenId = currentScreenId), fontSize = 18.sp, fontWeight = FontWeight.Bold, color = cTextWColor)
    }

}

@Preview
@Composable
fun Case3uxHeaderSectionPreview(){
    val tstData: State<Case3GameCommonData> = remember {
        mutableStateOf(Case3GameCommonData())
    }

    Case3uxHeaderSection(
        currentScreen = CommonConstants.SCREEN_OVERVIEW,
        onPauseClicked = {},
        isGameStarted = false,
        commonData = tstData
    )
}

@Preview
@Composable
fun Case3uxNavigationSectionPreview(){
    Case3uxNavigationSection(
        currentScreen = CommonConstants.SCREEN_PEOPLE,
        onNavigationClicked = {it ->}
    )
}
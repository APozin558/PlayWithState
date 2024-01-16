package com.jc.study.play.with.state.ui.screens.case2

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.jc.study.play.with.state.ext.ExtCase2
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_SCREEN_FIRST
import com.jc.study.play.with.state.models.case2.Case2GameResources

@Composable
fun Case2FirstScreen(
    nextScreenPressed: () -> Unit,
    gameSpeedState: Int,
    pausePressed: () -> Unit,
    gameDay: Int,
    gameDaytime: Int,
    gameRound: Int,
    navigateToPressed: (Int) -> Unit,
    gameResources: MutableState<Case2GameResources>
){
    Log.d(ExtCase2.CASE_2_LOG_D, "Case2_FirstScreen: START")

    Column {
        Case2uxHeader(
            headerLbl = "OVERVIEW",
            pausePressed = pausePressed,
            gameSpeedState = gameSpeedState,
            gameDay = gameDay,
            gameDaytime = gameDaytime,
            gameRound = gameRound
        )
        Case2uxTopNavigationTab(
            nextScreenPressed = nextScreenPressed,
            currentScreen = CASE_2_SCREEN_FIRST,
            navigateToPressed = navigateToPressed
        )
        Case2uxFirstResourcesSection(
            modifier = Modifier.weight(1.0f),
            gameResources = gameResources
        )
    }
}
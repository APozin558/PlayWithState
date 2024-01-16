package com.jc.study.play.with.state.ui.screens.case2

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_GAME_STATE_PAUSE
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_LOG_D
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_SCREEN_FIRST
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_SCREEN_SECOND
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_SCREEN_ZERO
import com.jc.study.play.with.state.models.case2.AppDataCase2
import kotlinx.coroutines.delay

@Composable
fun Case2ZeroScreen(){
    val appData = remember { AppDataCase2()}

    val gameSpeedState = appData.gameState.collectAsState().value
    val gameDay = appData.gameDay.collectAsState().value
    val gameDaytime = appData.gameDaytime.collectAsState().value
    val gameRound = appData.gameRound.collectAsState().value
    val gameCharactersList = appData.charactersList.collectAsState().value
    val gameResources = appData.gameResources.collectAsState().value

    when(appData.currentScreen.collectAsState().value){
        CASE_2_SCREEN_ZERO -> appData.nextScreen()
        CASE_2_SCREEN_FIRST -> Case2FirstScreen(
            nextScreenPressed =  { appData.nextScreen() },
            gameSpeedState = gameSpeedState,
            pausePressed = { appData.onPausePressed() },
            gameDay = gameDay,
            gameDaytime = gameDaytime,
            gameRound = gameRound,
            navigateToPressed = {screenId -> appData.navigateToPressed(screenId)},
            gameResources = gameResources
        )
        CASE_2_SCREEN_SECOND -> Case2SecondScreen(
            nextScreenPressed =  { appData.nextScreen() },
            gameSpeedState = gameSpeedState,
            pausePressed = { appData.onPausePressed() },
            gameDay = gameDay,
            gameDaytime = gameDaytime,
            gameRound = gameRound,
            gameCharactersList = gameCharactersList,
            navigateToPressed = {screenId -> appData.navigateToPressed(screenId)},
            updateTasksList = {peopleList, newOrder -> appData.updatePeopleOrderList(peopleList, newOrder) }
        )
    }

    if (gameSpeedState != CASE_2_GAME_STATE_PAUSE){
        LaunchedEffect(key1 = gameSpeedState){
            while (true){
                delay(1_000)
                Log.d(CASE_2_LOG_D, "Click! ${appData.gameRound.value}")
                appData.nextRound()
            }
        }
    }

}
package com.jc.study.play.with.state.ui.screens.case3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.jc.study.play.with.state.constants.CommonConstants
import com.jc.study.play.with.state.models.case3.Case3GameResourcesData
import com.jc.study.play.with.state.ui.models.case3.Case3DefaultScreenModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow

@Composable
fun Case3DefaultScreen(model: Case3DefaultScreenModel){
    val gmCommonData = model.gmCommonData.collectAsState()
    val isGameStarted = model.isGameStarted.collectAsState()
    val currentScreen = model.currentScreen.collectAsState()

    val gameData: StateFlow<Case3GameResourcesData> = model.gmResData
    val resNextRoundInfo = model.gmResNextRoundInfo

    val gamePeople = model.gmHeroesList.collectAsState()

    when (currentScreen.value){
        CommonConstants.SCREEN_OVERVIEW ->
            Case3OverviewScreen(
                gameData = gameData,
                commonData = gmCommonData,
                resNextRoundInfo = resNextRoundInfo,
                isGameStarted = isGameStarted,
                onPauseClicked = { model.onPauseClicked() },
                currentScreen = currentScreen.value,
                onNavigationClicked = { nextScreen:Int -> model.navigation(nextScreen) }
            )
        CommonConstants.SCREEN_PEOPLE ->
            Case3PeopleScreen(
                commonData = gmCommonData,
                onPauseClicked = { model.onPauseClicked() },
                currentScreen = currentScreen.value,
                isGameStarted = isGameStarted,
                onNavigationClicked = { nextScreen:Int -> model.navigation(nextScreen) },
                gamePeople = gamePeople,
                updateTaskClicked = {newOrder, selectedPeopleList -> model.updatePeopleTasks(newOrder = newOrder, selectedPeopleList = selectedPeopleList)}
            )
    }

    if (isGameStarted.value){
        LaunchedEffect(key1 = isGameStarted.value){
            while (true){
                delay(1_000)
                model.updateResOnNextRound()
            }
        }
    }
}
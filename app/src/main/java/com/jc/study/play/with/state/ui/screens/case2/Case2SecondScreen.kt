package com.jc.study.play.with.state.ui.screens.case2

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_SCREEN_SECOND
import com.jc.study.play.with.state.models.case2.Case2CharacterData

@Composable
fun Case2SecondScreen(
    nextScreenPressed: () -> Unit,
    gameSpeedState: Int,
    pausePressed: () -> Unit,
    gameDay: Int,
    gameDaytime: Int,
    gameRound: Int,
    gameCharactersList: MutableList<Case2CharacterData>,
    navigateToPressed: (Int) -> Unit,
    updateTasksList: (peopleList:List<Int>, newOrder:Int) -> Unit
){
    val listOfSelectedItems = remember {
        mutableStateListOf<Int>()
    }

    Column {
        Case2uxHeader(
            headerLbl = "PEOPLE",
            pausePressed = pausePressed,
            gameSpeedState = gameSpeedState,
            gameDay = gameDay,
            gameDaytime = gameDaytime,
            gameRound = gameRound
        )
        Case2uxTopNavigationTab(
            nextScreenPressed = nextScreenPressed,
            currentScreen = CASE_2_SCREEN_SECOND,
            navigateToPressed = navigateToPressed
        )
        Case2uxPeopleListSection(
            modifier = Modifier.weight(1.0f),
            gameCharactersList = gameCharactersList,
            listOfSelectedItems = listOfSelectedItems
        )
        if (listOfSelectedItems.isNotEmpty()){
            Case2uxBottomSelectTaskSection(onNewTaskPressed = { newOrder ->
                val peopleList = listOfSelectedItems.toList()
                updateTasksList(peopleList, newOrder)
                listOfSelectedItems.clear()
            })
        }
    }

}
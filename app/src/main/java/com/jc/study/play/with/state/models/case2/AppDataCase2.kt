package com.jc.study.play.with.state.models.case2

import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_GAME_DAYTIME_MORNING
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_GAME_DAYTIME_NIGHT
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_GAME_INIT_DAY
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_GAME_INIT_ROUND
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_GAME_STATE_PAUSE
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_GAME_STATE_PLAY
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_SCREEN_FIRST
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_SCREEN_SECOND
import com.jc.study.play.with.state.ext.ExtLogic2.case2getNextDaytime
import com.jc.study.play.with.state.ext.ExtLogic2.case2isDayTimeChanged
import com.jc.study.play.with.state.models.case2.Case2NewGameGenerator.getInitialGameResources
import com.jc.study.play.with.state.models.case2.Case2NewGameGenerator.getInitialListOfCharters
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppDataCase2 {
    val currentScreen = MutableStateFlow(CASE_2_SCREEN_FIRST)
    val gameState = MutableStateFlow(CASE_2_GAME_STATE_PAUSE)

    val gameRound = MutableStateFlow(CASE_2_GAME_INIT_ROUND)
    val gameDay = MutableStateFlow(CASE_2_GAME_INIT_DAY)
    val gameDaytime = MutableStateFlow(CASE_2_GAME_DAYTIME_MORNING)

    val charactersList = MutableStateFlow(
        getInitialListOfCharters(num = 16)
    )

    val gameResources = MutableStateFlow(
        getInitialGameResources()
    )

    fun nextScreen(){
        val nextScreen =  if(currentScreen.asStateFlow().value == CASE_2_SCREEN_FIRST) {
            CASE_2_SCREEN_SECOND
        } else {
            CASE_2_SCREEN_FIRST
        }
        currentScreen.update { nextScreen }
    }

    fun onPausePressed() {
        val newGameState = if (gameState.value == CASE_2_GAME_STATE_PAUSE)
            CASE_2_GAME_STATE_PLAY
        else CASE_2_GAME_STATE_PAUSE
        gameState.update { newGameState }
    }

    fun nextRound() {
        val nextRound = gameRound.asStateFlow().value + 1
        val currentDaytime = gameDaytime.asStateFlow().value

        if (case2isDayTimeChanged(nextRound = nextRound, currentDaytime = currentDaytime)){
            gameRound.update { CASE_2_GAME_INIT_ROUND }

            if (currentDaytime == CASE_2_GAME_DAYTIME_NIGHT) {
                val nextDay = gameDay.asStateFlow().value + 1
                gameDay.update { nextDay }
                gameDaytime.update { CASE_2_GAME_DAYTIME_MORNING }
            } else {
                val nextDaytime: Int = case2getNextDaytime(currentDaytime = currentDaytime)
                gameDaytime.update { nextDaytime }
            }

        } else {
            gameRound.update { nextRound }
        }
    }

    fun navigateToPressed(screenId: Int) {
        currentScreen.update { screenId }
    }

    fun updatePeopleOrderList(peopleList: List<Int>, newOrder: Int) {
        val currentList = charactersList.value
        currentList.forEach { item -> if (peopleList.contains(item.id)) {
            item.orderId = newOrder
            item.currentOrderId = newOrder
        }}
    }


}
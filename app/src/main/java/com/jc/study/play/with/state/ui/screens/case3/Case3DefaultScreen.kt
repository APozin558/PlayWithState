package com.jc.study.play.with.state.ui.screens.case3

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.jc.study.play.with.state.models.case3.Case3GameResourcesData
import com.jc.study.play.with.state.ui.models.case3.Case3DefaultScreenModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow

@Composable
fun Case3DefaultScreen(model: Case3DefaultScreenModel){
    val isGameStarted = model.isGameStarted.collectAsState()
    val gameData: StateFlow<Case3GameResourcesData> = model.gmResData
    val resNextRoundInfo = model.gmResNextRoundInfo

    Case3OverviewScreen(gameData = gameData, resNextRoundInfo = resNextRoundInfo)

    if (isGameStarted.value){
        LaunchedEffect(key1 = isGameStarted.value){
            while (true){
                delay(1_000)
                model.updateResOnNextRound()
                Log.d("CASE_3", "LaunchedEffect: CLICK!")
            }
        }
    }
}
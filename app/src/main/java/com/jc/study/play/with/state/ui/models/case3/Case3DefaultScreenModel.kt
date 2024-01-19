package com.jc.study.play.with.state.ui.models.case3

import android.util.Log
import androidx.lifecycle.ViewModel
import com.jc.study.play.with.state.logic.case3.Case3InitNewGame.generateNewHeroes
import com.jc.study.play.with.state.logic.case3.Case3NextRound
import com.jc.study.play.with.state.models.case3.Case3GameResourcesData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class Case3DefaultScreenModel: ViewModel() {
    private val _gmResData = MutableStateFlow(Case3GameResourcesData())
    val gmResData: StateFlow<Case3GameResourcesData> = _gmResData.asStateFlow()

    private val _isGameStarted = MutableStateFlow(true)
    val isGameStarted: StateFlow<Boolean> = _isGameStarted

    private val _gmHeroesList = MutableStateFlow(generateNewHeroes())
    val gmHeroesList = _gmHeroesList.asStateFlow()

    private val _gmResNextRoundInfo = MutableStateFlow(Case3NextRound.getNextRoundInfo(gmHeroesList))
    val gmResNextRoundInfo = _gmResNextRoundInfo.asStateFlow()

    fun updateResOnNextRound(){
        val gmResWaterNew = gmResData.value.resWater + gmResNextRoundInfo.value.resWater
        val gmResRawFoodNew = gmResData.value.resRawFood + gmResNextRoundInfo.value.resRawFood
        val gmResScrapNew = gmResData.value.resScrap + gmResNextRoundInfo.value.resScrap

        _gmResData.value = _gmResData.value
            .copy(resWater = gmResWaterNew, resRawFood = gmResRawFoodNew, resScrap = gmResScrapNew)

        Log.d("CASE_3", "updateResOnNextRound: $gmResWaterNew $gmResRawFoodNew $gmResScrapNew")
    }
}
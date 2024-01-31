package com.jc.study.play.with.state.ui.models.case3

import androidx.lifecycle.ViewModel
import com.jc.study.play.with.state.constants.CommonConstants
import com.jc.study.play.with.state.ext.case3.ExtCase3Labels.getDayPeriodTitleById
import com.jc.study.play.with.state.logic.case3.Case3InitNewGame.generateNewHeroes
import com.jc.study.play.with.state.logic.case3.Case3NextRound
import com.jc.study.play.with.state.models.case3.Case3GameCommonData
import com.jc.study.play.with.state.models.case3.Case3GameResourcesData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class Case3DefaultScreenModel: ViewModel() {
    val isMessageForToast = MutableStateFlow(false)
    private val txtMessageForToast = MutableStateFlow("???")

    private val _gmCommonDate = MutableStateFlow(Case3GameCommonData())
    val gmCommonData = _gmCommonDate.asStateFlow()

    private val _currentScreen = MutableStateFlow(CommonConstants.SCREEN_OVERVIEW)
    val currentScreen = _currentScreen.asStateFlow()

    private val _isGameStarted = MutableStateFlow(CommonConstants.IS_GAME_STARTED_DEFAULT)
    val isGameStarted: StateFlow<Boolean> = _isGameStarted

    private val _gmResData = MutableStateFlow(Case3GameResourcesData())
    val gmResData: StateFlow<Case3GameResourcesData> = _gmResData.asStateFlow()

    private val _gmHeroesList = MutableStateFlow(generateNewHeroes())
    val gmHeroesList = _gmHeroesList.asStateFlow()

    private val _gmResNextRoundInfo = MutableStateFlow(Case3NextRound.getNextRoundInfo(gmHeroesList))
    val gmResNextRoundInfo = _gmResNextRoundInfo.asStateFlow()

    fun updateResOnNextRound(){
        val newCommonData = Case3NextRound.runNextRound(currentData = gmCommonData.value)
        _gmCommonDate.value = _gmCommonDate.value
            .copy(roundNumber = newCommonData.roundNumber, dayN = newCommonData.dayN, dayPeriod = newCommonData.dayPeriod)

        _gmResNextRoundInfo.value = Case3NextRound.getNextRoundInfo(gmHeroesList)
        val gmResWaterResult = gmResData.value.resWater + gmResNextRoundInfo.value.getWater(newCommonData.dayPeriod, newCommonData.roundNumber)
        val gmResRawFoodResult = gmResData.value.resRawFood + gmResNextRoundInfo.value.getFood(newCommonData.dayPeriod, newCommonData.roundNumber)
        val gmResScrapResult = gmResData.value.resScrap + gmResNextRoundInfo.value.getScrap(newCommonData.dayPeriod, newCommonData.roundNumber)

        _gmResData.value = _gmResData.value
            .copy(resWater = gmResWaterResult, resRawFood = gmResRawFoodResult, resScrap = gmResScrapResult)
    }

    fun onPauseClicked() {
        val isStartedNew = !isGameStarted.value
        _isGameStarted.value = isStartedNew
    }

    fun navigation(nextScreen: Int){
        _currentScreen.value = nextScreen
    }

    fun updatePeopleTasks(newOrder: Int, selectedPeopleList: List<Int>) {
        val currentHeroList = _gmHeroesList.value
        currentHeroList.forEach { hero -> if (selectedPeopleList.contains(hero.id)) {
            hero.orderedTask = newOrder
            hero.currentTask = newOrder
        }}
        _gmResNextRoundInfo.value = Case3NextRound.getNextRoundInfo(gmHeroesList)
    }

    fun getMessageForToast(): StateFlow<String> {
        isMessageForToast.value = false
        return txtMessageForToast.asStateFlow()
    }

    fun checkToastMessage() {
        if (gmCommonData.value.roundNumber == 0){
            txtMessageForToast.value = getDayPeriodTitleById(gmCommonData.value.dayPeriod) + " STARTED"
            isMessageForToast.value = true
        }
    }
}
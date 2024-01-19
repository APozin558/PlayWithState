package com.jc.study.play.with.state.ui.models

import android.util.Log
import androidx.lifecycle.ViewModel
import com.jc.study.play.with.state.models.case2.Case2GameResources
import com.jc.study.play.with.state.models.case2.Case2NewGameGenerator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Case2ViewModel:ViewModel() {
    private val _gameResources = MutableStateFlow(Case2NewGameGenerator.getInitialGameResources())
    val gameResource: StateFlow<Case2GameResources> = _gameResources

    fun nextRound(){
        val resPrimaryWaterNew = gameResource.value.resPrimaryWater + 2
        val resPrimaryRawFoodNew = gameResource.value.resPrimaryRawFood + 1
        val resPrimaryScrapNew = gameResource.value.resPrimaryScrap + 1
        val resPrimaryHerbsNew = gameResource.value.resPrimaryHerbs + 1

        Log.d("[NEXT-ROUND]", "nextRound: $resPrimaryWaterNew $resPrimaryRawFoodNew $resPrimaryScrapNew $resPrimaryHerbsNew")

        _gameResources.value = _gameResources.value.copy(
            resPrimaryWater = resPrimaryWaterNew,
            resPrimaryRawFood = resPrimaryRawFoodNew,
            resPrimaryScrap = resPrimaryScrapNew,
            resPrimaryHerbs = resPrimaryHerbsNew
        )
    }
}
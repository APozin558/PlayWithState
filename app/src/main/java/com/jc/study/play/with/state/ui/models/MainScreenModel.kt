package com.jc.study.play.with.state.ui.models

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.jc.study.play.with.state.models.AppDataAlt
import com.jc.study.play.with.state.models.AppDataModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class MainScreenModel(appData: AppDataModel = AppDataModel()) :ViewModel() {
    var smCounter by mutableStateOf(0)
    private val adModel = MutableStateFlow(appData)

    private val _appDataExample = MutableStateFlow(appData)
    val appDataExample = _appDataExample

    fun onCounterClick(){
        val newCount = adModel.value.counter + 1
        adModel.update { it.copy(counter = newCount) }
        Log.d("TAG", "onCounterClick: ${adModel.value.counter}")
    }

    fun getCurrentCounter():Int{
        return adModel.value.counter
    }

    fun incrementScreenCounter(){
        smCounter += 1
    }

    fun getSingletonCounter():Int{
        return AppDataAlt.getCounter()
    }

    fun incrementSingletonCounter(){
        AppDataAlt.incrementCounter()
    }

    fun incrementExampleCounter(){
        val newExampleCount = appDataExample.value.counter + 1
        _appDataExample.update { it.copy(counter = newExampleCount) }
    }

    fun onPauseButtonClicked() {
        val newIsGameStarted = appDataExample.value.isGameStarted
        _appDataExample.update { it.copy(isGameStarted = !newIsGameStarted) }
    }
}
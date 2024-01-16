package com.jc.study.play.with.state.ui.models

import androidx.lifecycle.ViewModel
import com.jc.study.play.with.state.models.AppDataModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DefaultScreenModel(appData: AppDataModel):ViewModel() {
    private val _appDataModel = MutableStateFlow(appData)
    val appDataModel = _appDataModel.asStateFlow()
}
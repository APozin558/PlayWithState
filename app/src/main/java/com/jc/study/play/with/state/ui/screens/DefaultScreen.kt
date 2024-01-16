package com.jc.study.play.with.state.ui.screens

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import com.jc.study.play.with.state.models.AppDataModel
import com.jc.study.play.with.state.ui.models.DefaultScreenModel
import com.jc.study.play.with.state.ui.models.MainScreenModel

@Composable
fun DefaultScreen(appData: AppDataModel){
    MainScreen(MainScreenModel(appData))
}
package com.jc.study.play.with.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.jc.study.play.with.state.ui.models.case3.Case3DefaultScreenModel
import com.jc.study.play.with.state.ui.screens.case3.Case3DefaultScreen
import com.jc.study.play.with.state.ui.theme.PlayWithStateTheme
import com.jc.study.play.with.state.ui.theme.cDefaultBackgroundColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayWithStateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = cDefaultBackgroundColor
                ) {
/*
                    val appDataModel = remember{ AppDataModel() }
                    DefaultScreen(appDataModel)
*/
                    //Case2ZeroScreen()
                    val model = remember{ Case3DefaultScreenModel() }
                    Case3DefaultScreen(model)
                }
            }
        }
    }
}

package com.jc.study.play.with.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.jc.study.play.with.state.ui.screens.case2.Case2ZeroScreen
import com.jc.study.play.with.state.ui.theme.PlayWithStateTheme
import com.jc.study.play.with.state.ui.theme.cSecondaryColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayWithStateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = cSecondaryColor
                ) {
/*
                    val appDataModel = remember{ AppDataModel() }
                    DefaultScreen(appDataModel)
*/

                    Case2ZeroScreen()
                }
            }
        }
    }
}

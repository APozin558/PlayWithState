package com.jc.study.play.with.state.ui.screens.case3

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jc.study.play.with.state.models.case3.Case3GameCommonData
import com.jc.study.play.with.state.ui.screens.case3.ux.Case3uxFab
import com.jc.study.play.with.state.ui.screens.case3.ux.Case3uxHeaderSection
import com.jc.study.play.with.state.ui.screens.case3.ux.Case3uxNavigationSection

@Composable
fun Case3LocationsScreen(
    commonData: State<Case3GameCommonData>,
    onPauseClicked: () -> Unit,
    currentScreen: Int,
    isGameStarted: State<Boolean>,
    onNavigationClicked: (Int) -> Unit
){
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopStart)
        ) {
            Case3uxHeaderSection(
                currentScreen = currentScreen,
                onPauseClicked = onPauseClicked,
                isGameStarted = isGameStarted.value,
                commonData = commonData
            )
            Spacer(modifier = Modifier.weight(1.0f))
            Case3uxNavigationSection(
                currentScreen = currentScreen,
                onNavigationClicked = onNavigationClicked
            )
        }

        Surface(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(5.dp)
                .padding(bottom = 65.dp)
        ) {
            Case3uxFab(
                isStarted = isGameStarted.value,
                onClick = onPauseClicked
            )
        }
    }
}
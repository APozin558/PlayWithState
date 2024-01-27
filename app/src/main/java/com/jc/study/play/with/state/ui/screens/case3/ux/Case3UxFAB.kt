package com.jc.study.play.with.state.ui.screens.case3.ux

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.jc.study.play.with.state.ui.theme.cHeaderColor
import com.jc.study.play.with.state.ui.theme.cWhiteColor

@Composable
fun Case3uxFab(isStarted: Boolean = false, onClick: () -> Unit){
    FloatingActionButton(
        containerColor = cHeaderColor,
        contentColor = cWhiteColor,
        onClick = onClick
    ) {
        Icon(
            imageVector = if (isStarted) Icons.Filled.Close else Icons.Filled.PlayArrow,
            contentDescription = "Add"
        )
    }
}



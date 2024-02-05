
package com.jc.study.play.with.state.ui.screens.case3.ux

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun Case3uxShowToast(msg: String){
    val contextForToast = LocalContext.current.applicationContext
    Toast.makeText(contextForToast, msg, Toast.LENGTH_SHORT).show()
}
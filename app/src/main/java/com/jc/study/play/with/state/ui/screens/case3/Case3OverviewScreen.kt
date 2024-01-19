package com.jc.study.play.with.state.ui.screens.case3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jc.study.play.with.state.models.case3.Case3GameResourcesData
import com.jc.study.play.with.state.models.case3.Case3ResNextRoundChanges
import com.jc.study.play.with.state.ui.theme.cWhiteColor
import kotlinx.coroutines.flow.StateFlow

@Composable
fun Case3OverviewScreen(
    gameData: StateFlow<Case3GameResourcesData>,
    resNextRoundInfo: StateFlow<Case3ResNextRoundChanges>
) {
    val resWater = gameData.collectAsState().value.resWater
    val resNextWater = resNextRoundInfo.collectAsState().value.resWater
    val resHeroWater = resNextRoundInfo.collectAsState().value.heroWater
    val resRawFood = gameData.collectAsState().value.resRawFood
    val resNextRawFood = resNextRoundInfo.collectAsState().value.resRawFood
    val resHeroRawFood = resNextRoundInfo.collectAsState().value.heroRawFood
    val resScrap = gameData.collectAsState().value.resScrap
    val resNextScrap = resNextRoundInfo.collectAsState().value.resScrap
    val resHeroScrap = resNextRoundInfo.collectAsState().value.heroScrap

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Case3uxResourcesItem(res = resWater, resTitle = "WATER", resNext = resNextWater, resHero = resHeroWater)
        Case3uxResourcesItem(res = resRawFood, resTitle = "RAW FOOD", resNext = resNextRawFood, resHero = resHeroRawFood)
        Case3uxResourcesItem(res = resScrap, resTitle = "SCRAP", resNext = resNextScrap, resHero = resHeroScrap)
    }
}

@Composable
fun Case3uxResourcesItem(res: Float, resTitle: String, resNext: Float, resHero: Int){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(4.dp)
            .background(color = cWhiteColor)
    ) {
        Text(text = "$resTitle $res +$resNext H: $resHero", fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}
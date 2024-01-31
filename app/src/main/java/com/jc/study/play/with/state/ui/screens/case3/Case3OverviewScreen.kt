package com.jc.study.play.with.state.ui.screens.case3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jc.study.play.with.state.R
import com.jc.study.play.with.state.constants.CommonConstants
import com.jc.study.play.with.state.ext.case3.ExtCase3ImageIcons.getBigResImageById
import com.jc.study.play.with.state.ext.case3.ExtCase3ImageIcons.getResourceIconById
import com.jc.study.play.with.state.ext.case3.ExtCase3Labels
import com.jc.study.play.with.state.models.case3.Case3GameCommonData
import com.jc.study.play.with.state.models.case3.Case3GameResourcesData
import com.jc.study.play.with.state.models.case3.Case3ResNextRoundChanges
import com.jc.study.play.with.state.ui.screens.case3.ux.Case3uxFab
import com.jc.study.play.with.state.ui.screens.case3.ux.Case3uxHeaderSection
import com.jc.study.play.with.state.ui.screens.case3.ux.Case3uxNavigationSection
import com.jc.study.play.with.state.ui.theme.cAccentColor
import com.jc.study.play.with.state.ui.theme.cPrimaryColor
import com.jc.study.play.with.state.ui.theme.cTextColor
import com.jc.study.play.with.state.ui.theme.cWhiteColor
import kotlinx.coroutines.flow.StateFlow

@Composable
fun Case3OverviewScreen(
    gameData: StateFlow<Case3GameResourcesData>,
    commonData: State<Case3GameCommonData>,
    resNextRoundInfo: StateFlow<Case3ResNextRoundChanges>,
    onPauseClicked: () -> Unit,
    currentScreen: Int,
    isGameStarted: State<Boolean>,
    onNavigationClicked: (Int) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(TopStart)
        ) {
            Case3uxHeaderSection(
                currentScreen = currentScreen,
                onPauseClicked = onPauseClicked,
                isGameStarted = isGameStarted.value,
                commonData = commonData
            )
            Case3uxResourceSection(gameData = gameData, resNextRoundInfo = resNextRoundInfo, modifier = Modifier.weight(1.0f))
            Case3uxNavigationSection(currentScreen = currentScreen, onNavigationClicked = onNavigationClicked)
        }

        Surface(
            modifier = Modifier
                .align(BottomStart)
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

@Composable
fun Case3uxResourceSection(
    gameData: StateFlow<Case3GameResourcesData>,
    resNextRoundInfo: StateFlow<Case3ResNextRoundChanges>,
    modifier: Modifier
) {

    val heroTotal = resNextRoundInfo.collectAsState().value.heroTotal
    
    val resWater = gameData.collectAsState().value.resWater
    val resNextWater = resNextRoundInfo.collectAsState().value.resWater
    val resHeroWater = resNextRoundInfo.collectAsState().value.heroWater
    val resHeroSpendWater = resNextRoundInfo.collectAsState().value.spendWater

    val resRawFood = gameData.collectAsState().value.resRawFood
    val resNextRawFood = resNextRoundInfo.collectAsState().value.resRawFood
    val resHeroRawFood = resNextRoundInfo.collectAsState().value.heroRawFood
    val resHeroSpendRawFood = resNextRoundInfo.collectAsState().value.spendFood

    val resScrap = gameData.collectAsState().value.resScrap
    val resNextScrap = resNextRoundInfo.collectAsState().value.resScrap
    val resHeroScrap = resNextRoundInfo.collectAsState().value.heroScrap
    val resHeroSpendScrap = resNextRoundInfo.collectAsState().value.spendScrap

    Column(
        modifier = modifier
            .padding(start = 2.dp, end = 2.dp, top=4.dp, bottom = 4.dp)
    ) {
        Row {
            Case3uxResourcesItem(
                resId = CommonConstants.GAME_RES_WATER,
                res = resWater,
                resNext = resNextWater,
                resHero = resHeroWater,
                spendRes = resHeroSpendWater,
                affectedHeroes = heroTotal,
                modifier = Modifier.weight(1.0f)
            )
            Spacer(modifier = Modifier.width(2.dp))
            Case3uxResourcesItem(
                resId = CommonConstants.GAME_RES_RAW_FOOD,
                res = resRawFood,
                resNext = resNextRawFood,
                resHero = resHeroRawFood,
                spendRes = resHeroSpendRawFood,
                affectedHeroes = heroTotal,
                modifier = Modifier.weight(1.0f)
            )
        }
        Spacer(modifier = Modifier.height(2.dp))
        Row {
            Case3uxResourcesItem(
                resId = CommonConstants.GAME_RES_SCRAP,
                res = resScrap,
                resNext = resNextScrap,
                resHero = resHeroScrap,
                spendRes = resHeroSpendScrap,
                affectedHeroes = heroTotal,
                modifier = Modifier.weight(1.0f)
            )
            Spacer(modifier = Modifier.width(2.dp))
            Case3uxResourcesItem(
                resId = CommonConstants.GAME_RES_SCRAP,
                res = resScrap,
                resNext = resNextScrap,
                resHero = resHeroScrap,
                spendRes = resHeroSpendScrap,
                affectedHeroes = heroTotal,
                modifier = Modifier.weight(1.0f)
            )
        }
    }
}

@Composable
fun Case3uxResourcesItem(
    resId: Int,
    res: Float,
    resNext: Float,
    resHero: Int,
    spendRes: Float,
    affectedHeroes: Int,
    modifier: Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(50.dp)
            //.width(200.dp)
            .padding(start = 2.dp, end = 2.dp)
            .background(color = cPrimaryColor)
            .border(color = Color.Black, width = 1.dp)
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(
                    color = cWhiteColor,
                    shape = RoundedCornerShape(4.dp)
                )
        ){
            Image(
                modifier = Modifier.align(Center).size(46.dp),
                painter = painterResource(
                    id = getBigResImageById(resId)
                ),
                contentDescription = "big_res_img"
            )
            Image(
                modifier = Modifier
                    .align(BottomEnd)
                    .size(18.dp)
                    .background(color = cWhiteColor, shape = CircleShape)
                    .padding(2.dp),
                painter = painterResource(
                    id = getResourceIconById(resId)
                ),
                contentDescription = "res icon"
            )
        }
        Spacer(modifier = Modifier.width(2.dp))
        Column(
            verticalArrangement = Arrangement.SpaceEvenly
            ,modifier = Modifier
                .weight(1.0f)
                .padding(top = 1.dp, bottom = 1.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    color = cWhiteColor
                )
                .padding(start = 4.dp, end = 4.dp)
        ) {
            Row {
                Text(text = "${ExtCase3Labels.getResTitleById(resId)}: ", color = cAccentColor, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Text(text = res.toString(), color = cAccentColor, fontSize = 14.sp, fontWeight = FontWeight.Normal)
                Spacer(modifier = Modifier.weight(1.0f))
                Row {
                    Image(painter = painterResource(id = R.drawable.ux_small_hero_b_16), contentDescription = "hero", modifier = Modifier
                        .align(Bottom)
                        .size(16.dp))
                    Text(text = "$resHero")
                }
            }
            Row {
                Text(text = "+$resNext", color = cTextColor, fontSize = 12.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "-$spendRes", color = cTextColor, fontSize = 12.sp)
                Spacer(modifier = Modifier.weight(1.0f))
            }

        }
    }
/*
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(4.dp)
            .background(color = cWhiteColor)
    ) {
        Image(painter = painterResource(id = getResourceIconById(resId)), contentDescription = resTitle)
        Spacer(modifier = Modifier.width(5.dp))
        Column(modifier = Modifier.fillMaxHeight()) {
            Row {
                Text(text = "$resTitle: $res", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = cTextColor)
                if (resHero > 0) {
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "+$resNext", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = cTextColor)
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "($resHero", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = cTextColor)
                    Image(painter = painterResource(id = R.drawable.ux_small_hero_b_16), contentDescription = "hero", modifier = Modifier
                        .align(Bottom)
                        .size(20.dp))
                    Text(text = ")", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = cTextColor)

                }
            }
            if (spendRes > 0){
                Row {
                    Text(text = "SPEND: $spendRes", fontSize = 12.sp, fontWeight = FontWeight.Normal, color = cTextAltColor )
                    if (affectedHeroes > 0) {
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "($affectedHeroes", fontSize = 12.sp, fontWeight = FontWeight.Normal, color = cTextAltColor )
                        Image(painter = painterResource(id = R.drawable.ux_small_hero_b_16), contentDescription = "hero", modifier = Modifier
                            .align(Bottom)
                            .size(14.dp))
                        Text(text = ")", fontSize = 12.sp, fontWeight = FontWeight.Normal, color = cTextAltColor )

                    }
                }
            }
        }
*/
}

@Preview
@Composable
fun Case3uxResourcesItemPreview(){
    Case3uxResourcesItem(
        res = 25.0f,
        resHero = 5,
        resId = CommonConstants.GAME_RES_WATER,
        resNext = 5.5f,
        spendRes = 10.0f,
        affectedHeroes = 10,
        modifier = Modifier.width(200.dp)
    )
}
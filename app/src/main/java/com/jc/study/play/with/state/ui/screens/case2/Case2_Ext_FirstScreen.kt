package com.jc.study.play.with.state.ui.screens.case2

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jc.study.play.with.state.R
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_RES_HERBS
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_RES_NAME_PRIMARY_SECTION
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_RES_NAME_SECTION
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_RES_RAW_FOOD
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_RES_SCRAP
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_RES_WATER
import com.jc.study.play.with.state.ext.ExtLogic2.case2getResNameById
import com.jc.study.play.with.state.models.case2.Case2GameResources
import com.jc.study.play.with.state.ui.theme.cWhiteColor
import com.jc.study.play.with.state.ui.theme.cTextColor

@Composable
fun Case2uxFirstResourcesSection(
    modifier: Modifier,
    gameResources: State<Case2GameResources>
) {
    val resWater = gameResources.value.resPrimaryWater
    val resRawFood = gameResources.value.resPrimaryRawFood
    val resScrap = gameResources.value.resPrimaryScrap
    val resHerbs = gameResources.value.resPrimaryHerbs
    Log.d("[NEXT-ROUND] ", "Case2uxFirstResourcesSection: $resWater $resRawFood $resScrap $resHerbs")


    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = cWhiteColor)
            .padding(2.dp)
    ) {
        Text(text = CASE_2_RES_NAME_SECTION, color = cTextColor, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text(text = CASE_2_RES_NAME_PRIMARY_SECTION, color = cTextColor, fontSize = 14.sp, fontWeight = FontWeight.Bold)
        Case2uxFirstResourcesSectionItem(resCont = resWater, resId = CASE_2_RES_WATER)
        Case2uxFirstResourcesSectionItem(resCont = resRawFood, resId = CASE_2_RES_RAW_FOOD)
        Case2uxFirstResourcesSectionItem(resCont = resScrap, resId = CASE_2_RES_SCRAP)
        Case2uxFirstResourcesSectionItem(resCont = resHerbs, resId = CASE_2_RES_HERBS)
    }

}

@Composable
fun Case2uxFirstResourcesSectionItem(resCont:Float, resId:Int){
    Row(
        modifier = Modifier
            .height(50.dp)
            .padding(4.dp)
    ) {
        Column(
            Modifier
                .fillMaxHeight()
                .weight(1.0f)) {
            Text(text = case2getResNameById(resId), color = cTextColor, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text(text = "$resCont", color = cTextColor, fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight()
                .width(50.dp)
        ){
            Image(painter = painterResource(id = R.drawable.ux_res_default_c_36), contentDescription = "res $Int")
        }
    }
}
package com.jc.study.play.with.state.ext.case3

import com.jc.study.play.with.state.constants.CommonConstants
import com.jc.study.play.with.state.constants.CommonConstants.GAME_RES_HERBS
import com.jc.study.play.with.state.constants.CommonConstants.GAME_RES_RAW_FOOD
import com.jc.study.play.with.state.constants.CommonConstants.GAME_RES_SCRAP
import com.jc.study.play.with.state.constants.CommonConstants.GAME_RES_WATER

object ExtCase3Labels {

    fun getScreenTitleById(screenId:Int):String{
        return when(screenId){
            CommonConstants.SCREEN_OVERVIEW -> "OVERVIEW"
            CommonConstants.SCREEN_PEOPLE -> "PEOPLE"
            CommonConstants.SCREEN_BUILDINGS -> "BUILDINGS"
            CommonConstants.SCREEN_LOCATIONS -> "LOCATIONS"
            else -> "????"
        }
    }

    fun getDayPeriodTitleById(dayPeriod: Int, roundN:Int):String{
        if (dayPeriod == CommonConstants.TIME_MORNING && roundN == 0)
            return CommonConstants.TIME_MORNING_START_LBL
        if (dayPeriod == CommonConstants.TIME_MORNING)
            return CommonConstants.TIME_MORNING_LBL
        if (dayPeriod == CommonConstants.TIME_DAY && roundN == 0)
            return CommonConstants.TIME_DAY_START_LBL
        if (dayPeriod == CommonConstants.TIME_DAY)
            return CommonConstants.TIME_DAY_LBL
        if (dayPeriod == CommonConstants.TIME_EVENING && roundN == 0)
            return CommonConstants.TIME_EVENING_START_LBL
        if (dayPeriod == CommonConstants.TIME_EVENING)
            return CommonConstants.TIME_EVENING_LBL
        if (dayPeriod == CommonConstants.TIME_NIGHT && roundN == 0)
            return CommonConstants.TIME_NIGHT_START_LBL
        if (dayPeriod == CommonConstants.TIME_NIGHT)
            return CommonConstants.TIME_NIGHT_LBL
        return "????"
    }

    fun getResTitleById(resId:Int):String{
        return when(resId){
            GAME_RES_WATER -> "WATER"
            GAME_RES_RAW_FOOD -> "FOOD"
            GAME_RES_SCRAP -> "SCRAP"
            GAME_RES_HERBS -> "HERBS"
            else -> "???"
        }
    }

    fun getDayPeriodTitleById(dayPeriodId:Int):String{
        return when(dayPeriodId) {
            CommonConstants.TIME_MORNING -> CommonConstants.TIME_MORNING_LBL
            CommonConstants.TIME_DAY -> CommonConstants.TIME_DAY_LBL
            CommonConstants.TIME_EVENING -> CommonConstants.TIME_EVENING_LBL
            CommonConstants.TIME_NIGHT -> CommonConstants.TIME_NIGHT_LBL
            else -> "???"
        }
    }
}
package com.jc.study.play.with.state.ext.case3

import com.jc.study.play.with.state.constants.CommonConstants

object ExtCase3Labels {

    fun getScreenTitleById(screenId:Int):String{
        return when(screenId){
            CommonConstants.SCREEN_OVERVIEW -> "OVERVIEW"
            CommonConstants.SCREEN_PEOPLE -> "PEOPLE"
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

}
package com.jc.study.play.with.state.ext.case3

import com.jc.study.play.with.state.R
import com.jc.study.play.with.state.constants.CommonConstants
import com.jc.study.play.with.state.constants.HeroConstants

object ExtCase3ImageIcons {

    fun getResourceIconById(resId:Int):Int{
        return when(resId){
            CommonConstants.GAME_RES_WATER -> R.drawable.ux_res_water_c_40
            CommonConstants.GAME_RES_RAW_FOOD -> R.drawable.ux_res_raw_food_c_40
            CommonConstants.GAME_RES_SCRAP -> R.drawable.ux_res_gear_c_40
            else -> R.drawable.ux_alert_c_24
        }
    }

    fun getPauseIconByIsStarted(isStarted:Boolean):Int{
        return if (isStarted) R.drawable.ux_pause_c else R.drawable.ux_play_c
    }

    fun getDayPeriodIconById(dayPeriod:Int):Int{
        return when (dayPeriod){
            CommonConstants.TIME_MORNING -> R.drawable.ux_morning_icon
            CommonConstants.TIME_DAY -> R.drawable.ux_day_icon
            CommonConstants.TIME_EVENING -> R.drawable.ux_evening_icon
            CommonConstants.TIME_NIGHT -> R.drawable.ux_night_icon
            else -> R.drawable.ux_alert_icon
        }
    }

    fun getRoundMarkerIconById(gameRound:Int, i:Int):Int{
        if (i == gameRound) return R.drawable.ux_circle_b_10
        return if (i < gameRound) R.drawable.ux_circle_filled_10_icon
        else R.drawable.ux_circle_10_icon
    }

    fun getHeaderSectionIconById(screenId:Int):Int{
        return when(screenId){
            CommonConstants.SCREEN_OVERVIEW -> R.drawable.ux_navigation_main_icon
            CommonConstants.SCREEN_PEOPLE -> R.drawable.ux_navigation_people_icon
            CommonConstants.SCREEN_BUILDINGS -> R.drawable.ux_navigation_buildings_w_24
            CommonConstants.SCREEN_LOCATIONS -> R.drawable.ux_navigation_locations_w_24
            else -> R.drawable.ux_alert_icon
        }
    }

    fun getNavigationIconById(screenId:Int, isCurrentScreen:Boolean):Int{
        return when(screenId){
            CommonConstants.SCREEN_OVERVIEW ->
                if (isCurrentScreen)
                    R.drawable.ux_navigation_main_selected_icon
                else
                    R.drawable.ux_navigation_main_icon
            CommonConstants.SCREEN_PEOPLE ->
                if (isCurrentScreen)
                    R.drawable.ux_navigation_people_selected_icon
                else
                    R.drawable.ux_navigation_people_icon
            CommonConstants.SCREEN_BUILDINGS ->
                if (isCurrentScreen)
                    R.drawable.ux_navigation_buildings_c_24
                else
                    R.drawable.ux_navigation_buildings_w_24
            CommonConstants.SCREEN_LOCATIONS ->
                if (isCurrentScreen)
                    R.drawable.ux_navigation_locations_c_24
                else
                    R.drawable.ux_navigation_locations_w_24
            else -> R.drawable.ux_alert_icon
        }
    }

    fun getTaskIconById(taskId:Int):Int{
        return when(taskId){
            HeroConstants.TASK_NOTHING -> R.drawable.ux_task_sleep_c_24
            HeroConstants.TASK_REST -> R.drawable.ux_task_rest_c_24
            HeroConstants.TASK_WATER -> R.drawable.ux_task_water_c_24
            HeroConstants.TASK_RAW_FOOD -> R.drawable.ux_res_raw_food_c_40
            HeroConstants.TASK_SCRAP -> R.drawable.ux_task_scrap_c_24
            HeroConstants.TASK_HERBS -> R.drawable.ux_task_herbs_c_24
            HeroConstants.TASK_SCOUT -> R.drawable.ux_task_scout_c_24
            HeroConstants.TASK_BUILD -> R.drawable.ux_task_build_c_24
            HeroConstants.TASK_HEAL ->  R.drawable.ux_task_heal_c_24
            else -> R.drawable.ux_alert_c_24
        }
    }

    fun getNewTaskImageById(taskId: Int):Int{
        return when(taskId){
            HeroConstants.TASK_NOTHING -> R.drawable.ux_task_nothing_w_24
            HeroConstants.TASK_REST -> R.drawable.ux_task_rest_w_icon
            HeroConstants.TASK_WATER -> R.drawable.ux_task_water_w_icon
            HeroConstants.TASK_RAW_FOOD -> R.drawable.ux_task_food_w_24
            HeroConstants.TASK_SCRAP -> R.drawable.ux_task_scrap_w_24
            HeroConstants.TASK_HERBS -> R.drawable.ux_task_herbs_w_24
            HeroConstants.TASK_SCOUT -> R.drawable.ux_task_scout_w_icon
            HeroConstants.TASK_BUILD -> R.drawable.ux_task_build_w_24
            HeroConstants.TASK_HEAL -> R.drawable.ux_task_heal_w_24
            HeroConstants.TASK_RESET_SELECTION -> R.drawable.ux_task_cancel_w_24
            else -> R.drawable.ux_alert_icon
        }
    }

    fun getBigResImageById(resId: Int):Int{
        return when(resId){
            CommonConstants.GAME_RES_WATER -> R.drawable.ux_res_big_water
            CommonConstants.GAME_RES_RAW_FOOD -> R.drawable.ux_res_big_raw_food
            CommonConstants.GAME_RES_SCRAP -> R.drawable.ux_res_big_soup
            CommonConstants.GAME_RES_HERBS -> R.drawable.ux_res_big_herbs
            else -> R.drawable.ux_res_big_water
        }
    }

    fun getExpandIcon(isExpanded:Boolean):Int{
        return if (isExpanded) R.drawable.ux_icon_expand_less else R.drawable.ux_icon_expand_more
    }

}
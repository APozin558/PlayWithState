package com.jc.study.play.with.state.ext

import com.jc.study.play.with.state.R
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_GAME_DAYTIME_DAY
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_GAME_DAYTIME_EVENING
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_GAME_DAYTIME_MORNING
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_GAME_DAYTIME_NIGHT
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_GAME_DAY_LENGTH
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_GAME_EVENING_LENGTH
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_GAME_MORNING_LENGTH
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_GAME_NIGHT_LENGTH
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_GAME_STATE_PAUSE
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_GAME_STATE_PLAY
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_RES_HERBS
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_RES_NAME_HERBS
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_RES_NAME_RAW_FOOD
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_RES_NAME_SCRAP
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_RES_NAME_WATER
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_RES_RAW_FOOD
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_RES_SCRAP
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_RES_WATER
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_SCREEN_FIRST
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_SCREEN_SECOND
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_BUILD
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_COOK
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_CRAFT
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_FOOD
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_GUARD
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_HEAL
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_HERBS
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_MORE
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_NAME_BUILD
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_NAME_COOK
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_NAME_CRAFT
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_NAME_FOOD
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_NAME_GUARD
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_NAME_HEAL
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_NAME_HERBS
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_NAME_MORE
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_NAME_NOTHING
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_NAME_REST
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_NAME_SCOUT
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_NAME_SCRAP
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_NAME_TRADE
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_NAME_WATER
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_NOTHING
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_PREFIX_NAME_FIND
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_PREFIX_NAME_HARVEST
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_PREFIX_NAME_TASK
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_REST
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_SCOUT
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_SCRAP
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_TRADE
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_WATER

object ExtLogic2 {
    fun case2getHeaderIconById(gameState: Int):Int{
        return when (gameState){
            CASE_2_GAME_STATE_PAUSE -> R.drawable.ux_play_icon
            CASE_2_GAME_STATE_PLAY -> R.drawable.ux_pause_icon
            else -> R.drawable.ux_alert_icon
        }
    }

    fun case2isDayTimeChanged(nextRound: Int, currentDaytime: Int): Boolean {
        return when(currentDaytime){
            CASE_2_GAME_DAYTIME_MORNING -> nextRound >= CASE_2_GAME_MORNING_LENGTH
            CASE_2_GAME_DAYTIME_DAY -> nextRound >= CASE_2_GAME_DAY_LENGTH
            CASE_2_GAME_DAYTIME_EVENING -> nextRound >= CASE_2_GAME_EVENING_LENGTH
            CASE_2_GAME_DAYTIME_NIGHT -> nextRound >= CASE_2_GAME_NIGHT_LENGTH
            else -> false
        }
    }

    fun case2getNextDaytime(currentDaytime:Int):Int{
        return when(currentDaytime){
            CASE_2_GAME_DAYTIME_MORNING -> CASE_2_GAME_DAYTIME_DAY
            CASE_2_GAME_DAYTIME_DAY -> CASE_2_GAME_DAYTIME_EVENING
            CASE_2_GAME_DAYTIME_EVENING -> CASE_2_GAME_DAYTIME_NIGHT
            else -> CASE_2_GAME_DAYTIME_MORNING
        }
    }

    fun case2getDaytimeIconById(gameDaytime:Int):Int{
        return when(gameDaytime){
            CASE_2_GAME_DAYTIME_MORNING -> R.drawable.ux_morning_icon
            CASE_2_GAME_DAYTIME_DAY -> R.drawable.ux_day_icon
            CASE_2_GAME_DAYTIME_EVENING -> R.drawable.ux_evening_icon
            CASE_2_GAME_DAYTIME_NIGHT -> R.drawable.ux_night_icon
            else -> R.drawable.ux_alert_icon
        }
    }

    fun case2getRoundIconById(gameRound:Int, i:Int):Int{
        return if (i <= gameRound) R.drawable.ux_circle_filled_10_icon else R.drawable.ux_circle_10_icon
    }


    fun case2getTaskIconById(taskId:Int):Int{
        return when(taskId){
            CASE_2_TASK_NOTHING -> R.drawable.ux_task_sleep_c_24
            CASE_2_TASK_REST -> R.drawable.ux_task_rest_c_24
            CASE_2_TASK_WATER -> R.drawable.ux_task_water_c_24
            CASE_2_TASK_FOOD -> R.drawable.ux_task_food_c_24
            CASE_2_TASK_SCRAP -> R.drawable.ux_task_scrap_c_24
            CASE_2_TASK_SCOUT -> R.drawable.ux_task_scout_c_24
            CASE_2_TASK_HEAL -> R.drawable.ux_task_heal_c_24
            else -> R.drawable.ux_alert_icon
        }
    }

    fun case2getNavigationIconByID(screenId: Int, currentScreenId:Int):Int{
        return when(screenId){
            CASE_2_SCREEN_FIRST -> if (CASE_2_SCREEN_FIRST == currentScreenId)
                    R.drawable.ux_navigation_main_selected_icon
                else
                    R.drawable.ux_navigation_main_icon
            CASE_2_SCREEN_SECOND -> if (CASE_2_SCREEN_SECOND == currentScreenId)
                    R.drawable.ux_navigation_people_selected_icon
                else
                    R.drawable.ux_navigation_people_icon
            else -> R.drawable.ux_alert_icon
        }
    }

    fun case2getNewTaskImageById(taskId: Int):Int{
        return when(taskId){
            CASE_2_TASK_NOTHING -> R.drawable.ux_task_nothing_w_24
            CASE_2_TASK_REST -> R.drawable.ux_task_rest_w_icon
            CASE_2_TASK_WATER -> R.drawable.ux_task_water_w_icon
            CASE_2_TASK_FOOD -> R.drawable.ux_task_food_w_24
            CASE_2_TASK_SCRAP -> R.drawable.ux_task_scrap_w_24
            CASE_2_TASK_SCOUT -> R.drawable.ux_task_scout_w_icon
            CASE_2_TASK_HEAL -> R.drawable.ux_task_heal_w_24
            CASE_2_TASK_MORE -> R.drawable.ux_task_more_w_24
            else -> R.drawable.ux_alert_icon
        }
    }

    fun case2getResNameById(resId: Int):String{
        return when(resId){
            CASE_2_RES_WATER -> CASE_2_RES_NAME_WATER
            CASE_2_RES_RAW_FOOD -> CASE_2_RES_NAME_RAW_FOOD
            CASE_2_RES_SCRAP -> CASE_2_RES_NAME_SCRAP
            CASE_2_RES_HERBS -> CASE_2_RES_NAME_HERBS
            else -> "UNKNOWN"
        }
    }

    fun case2getTaskPrefixNameById(taskId: Int):String{
        return when(taskId){
            CASE_2_TASK_WATER, CASE_2_TASK_SCRAP -> CASE_2_TASK_PREFIX_NAME_FIND
            CASE_2_TASK_FOOD, CASE_2_TASK_HERBS  -> CASE_2_TASK_PREFIX_NAME_HARVEST
            else -> CASE_2_TASK_PREFIX_NAME_TASK
        }
    }

    fun case2getTaskNameById(taskId: Int):String{
        return when(taskId){
            CASE_2_TASK_MORE -> CASE_2_TASK_NAME_MORE
            CASE_2_TASK_NOTHING -> CASE_2_TASK_NAME_NOTHING
            CASE_2_TASK_REST -> CASE_2_TASK_NAME_REST
            CASE_2_TASK_WATER -> CASE_2_TASK_NAME_WATER
            CASE_2_TASK_FOOD -> CASE_2_TASK_NAME_FOOD
            CASE_2_TASK_SCRAP -> CASE_2_TASK_NAME_SCRAP
            CASE_2_TASK_SCOUT -> CASE_2_TASK_NAME_SCOUT
            CASE_2_TASK_HERBS -> CASE_2_TASK_NAME_HERBS
            CASE_2_TASK_COOK -> CASE_2_TASK_NAME_COOK
            CASE_2_TASK_BUILD -> CASE_2_TASK_NAME_BUILD
            CASE_2_TASK_CRAFT -> CASE_2_TASK_NAME_CRAFT
            CASE_2_TASK_HEAL -> CASE_2_TASK_NAME_HEAL
            CASE_2_TASK_GUARD -> CASE_2_TASK_NAME_GUARD
            CASE_2_TASK_TRADE -> CASE_2_TASK_NAME_TRADE
            else -> "UNKNOWN"
        }
    }

}
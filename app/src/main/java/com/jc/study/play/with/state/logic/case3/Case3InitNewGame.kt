package com.jc.study.play.with.state.logic.case3

import com.jc.study.play.with.state.ext.ExtCase2GameDefaults
import com.jc.study.play.with.state.ext.case3.ExtCase3.CASE_3_TASK_RAW_FOOD
import com.jc.study.play.with.state.ext.case3.ExtCase3.CASE_3_TASK_SCRAP
import com.jc.study.play.with.state.ext.case3.ExtCase3.CASE_3_TASK_WATER
import com.jc.study.play.with.state.models.case3.Case3GameHeroesData

object Case3InitNewGame {

    fun generateNewHeroes(num:Int = 7):MutableList<Case3GameHeroesData>{
        var result: MutableList<Case3GameHeroesData> = mutableListOf()

        for (i in 1..3){
            val firstName = ExtCase2GameDefaults.GAME_CHAR_FIRST_NAME[(ExtCase2GameDefaults.GAME_CHAR_FIRST_NAME.indices).random()]
            val lastName = ExtCase2GameDefaults.GAME_CHAR_LAST_NAME[(ExtCase2GameDefaults.GAME_CHAR_LAST_NAME.indices).random()]
            result.add(Case3GameHeroesData(name = "$firstName $lastName", currentOrder = CASE_3_TASK_WATER))
        }

        for (i in 1..2){
            val firstName = ExtCase2GameDefaults.GAME_CHAR_FIRST_NAME[(ExtCase2GameDefaults.GAME_CHAR_FIRST_NAME.indices).random()]
            val lastName = ExtCase2GameDefaults.GAME_CHAR_LAST_NAME[(ExtCase2GameDefaults.GAME_CHAR_LAST_NAME.indices).random()]
            result.add(Case3GameHeroesData(name = "$firstName $lastName", currentOrder = CASE_3_TASK_RAW_FOOD))
        }

        for (i in 1..4){
            val firstName = ExtCase2GameDefaults.GAME_CHAR_FIRST_NAME[(ExtCase2GameDefaults.GAME_CHAR_FIRST_NAME.indices).random()]
            val lastName = ExtCase2GameDefaults.GAME_CHAR_LAST_NAME[(ExtCase2GameDefaults.GAME_CHAR_LAST_NAME.indices).random()]
            result.add(Case3GameHeroesData(name = "$firstName $lastName", currentOrder = CASE_3_TASK_SCRAP))
        }

        return result
    }

}
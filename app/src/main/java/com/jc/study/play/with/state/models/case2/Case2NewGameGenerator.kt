package com.jc.study.play.with.state.models.case2

import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_NOTHING
import com.jc.study.play.with.state.ext.ExtCase2GameDefaults.CASE_2_GAME_DEFAULT_RES_HERBS
import com.jc.study.play.with.state.ext.ExtCase2GameDefaults.CASE_2_GAME_DEFAULT_RES_RAW_FOOD
import com.jc.study.play.with.state.ext.ExtCase2GameDefaults.CASE_2_GAME_DEFAULT_RES_SCRAP
import com.jc.study.play.with.state.ext.ExtCase2GameDefaults.CASE_2_GAME_DEFAULT_RES_WATER

object Case2NewGameGenerator {

    fun getInitialListOfCharters(num:Int):MutableList<Case2CharacterData>{
        val result: MutableList<Case2CharacterData> = mutableListOf<Case2CharacterData>()

        for (i in 1..num) result.add(Case2CharacterData.create(
            name = "Freya Anderson",
            orderId = CASE_2_TASK_NOTHING,
            currentOrderId = CASE_2_TASK_NOTHING
        ))

        return result
    }


    fun getInitialGameResources(): Case2GameResources {
        return Case2GameResources(
                resPrimaryWater = CASE_2_GAME_DEFAULT_RES_WATER,
                resPrimaryRawFood = CASE_2_GAME_DEFAULT_RES_RAW_FOOD,
                resPrimaryScrap = CASE_2_GAME_DEFAULT_RES_SCRAP,
                resPrimaryHerbs = CASE_2_GAME_DEFAULT_RES_HERBS
            )
    }

}
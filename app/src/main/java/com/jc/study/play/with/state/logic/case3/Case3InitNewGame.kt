package com.jc.study.play.with.state.logic.case3

import com.jc.study.play.with.state.constants.HeroConstants
import com.jc.study.play.with.state.models.case3.Case3GameHeroesData

object Case3InitNewGame {

    fun generateNewHeroes(num:Int = 7):MutableList<Case3GameHeroesData>{
        var result: MutableList<Case3GameHeroesData> = mutableListOf()

        for (i in 1..2){
            result.add(Case3GameHeroesData.create(orderedTask = HeroConstants.TASK_WATER) )
        }

        for (i in 1..2){
            result.add(Case3GameHeroesData.create(orderedTask = HeroConstants.TASK_RAW_FOOD))
        }

        for (i in 1..3){
            result.add(Case3GameHeroesData.create(orderedTask = HeroConstants.TASK_SCRAP))
        }

        return result
    }

}
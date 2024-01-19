package com.jc.study.play.with.state.logic.case3

import com.jc.study.play.with.state.ext.case3.ExtCase3.CASE_3_TASK_RAW_FOOD
import com.jc.study.play.with.state.ext.case3.ExtCase3.CASE_3_TASK_SCRAP
import com.jc.study.play.with.state.ext.case3.ExtCase3.CASE_3_TASK_WATER
import com.jc.study.play.with.state.models.case3.Case3GameHeroesData
import com.jc.study.play.with.state.models.case3.Case3ResNextRoundChanges
import kotlinx.coroutines.flow.StateFlow

object Case3NextRound {
    fun getNextRoundInfo(gmHeroesList: StateFlow<MutableList<Case3GameHeroesData>>): Case3ResNextRoundChanges {
        val result = Case3ResNextRoundChanges()
        gmHeroesList.value.forEach { hero ->
            run {
                when (hero.currentOrder) {
                    CASE_3_TASK_WATER -> {
                        result.heroWater += 1
                        result.resWater += 2.0f
                    }

                    CASE_3_TASK_RAW_FOOD -> {
                        result.heroRawFood += 1
                        result.resRawFood += 1.0f
                    }

                    CASE_3_TASK_SCRAP -> {
                        result.heroScrap += 1
                        result.resScrap += 1.5f
                    }
                }
            }
        }
        return result
    }

}
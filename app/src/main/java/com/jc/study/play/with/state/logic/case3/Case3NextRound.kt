package com.jc.study.play.with.state.logic.case3

import com.jc.study.play.with.state.constants.CommonConstants
import com.jc.study.play.with.state.constants.HeroConstants
import com.jc.study.play.with.state.models.case3.Case3GameCommonData
import com.jc.study.play.with.state.models.case3.Case3GameHeroesData
import com.jc.study.play.with.state.models.case3.Case3ResNextRoundChanges
import kotlinx.coroutines.flow.StateFlow

object Case3NextRound {
    fun getNextRoundInfo(gmHeroesList: StateFlow<MutableList<Case3GameHeroesData>>): Case3ResNextRoundChanges {
        val result = Case3ResNextRoundChanges()
        gmHeroesList.value.forEach { hero ->
            run {
                result.heroTotal += 1

                when (hero.currentTask) {
                    HeroConstants.TASK_WATER -> {
                        result.heroWater += 1
                        result.resWater += HeroConstants.DEFAULT_GET_WATER
                    }

                    HeroConstants.TASK_RAW_FOOD -> {
                        result.heroRawFood += 1
                        result.resRawFood += HeroConstants.DEFAULT_GET_RAW_FOOD
                    }

                    HeroConstants.TASK_SCRAP -> {
                        result.heroScrap += 1
                        result.resScrap += HeroConstants.DEFAULT_GET_SCRAP
                    }

                    HeroConstants.TASK_SCOUT -> {
                        result.heroScout += 1
                        result.resScout += HeroConstants.DEFAULT_DO_SCOUT
                    }
                }

                result.spendWater += HeroConstants.DEFAULT_NEED_WATER
                result.spendFood += HeroConstants.DEFAULT_NEED_FOOD
            }
        }
        return result
    }

    fun runNextRound(currentData: Case3GameCommonData): Case3GameCommonData {
        val result:Case3GameCommonData = Case3GameCommonData()

        var newRound = currentData.roundNumber + 1
        var newDayPeriod = currentData.dayPeriod
        var newDayN = currentData.dayN

        if (newRound >= CommonConstants.TIME_PERIOD_LENGTH) {
            newRound = 0
            newDayPeriod += 1

            if (newDayPeriod >= 4){
                newDayPeriod = CommonConstants.TIME_MORNING
                newDayN += 1
            }
        }

        return Case3GameCommonData(roundNumber = newRound, dayPeriod = newDayPeriod, dayN = newDayN )
    }

}
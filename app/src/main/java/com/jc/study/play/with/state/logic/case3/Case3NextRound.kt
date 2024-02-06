package com.jc.study.play.with.state.logic.case3

import com.jc.study.play.with.state.constants.CommonConstants
import com.jc.study.play.with.state.constants.HeroConstants
import com.jc.study.play.with.state.models.case3.Case3GameCommonData
import com.jc.study.play.with.state.models.case3.Case3GameHeroesData
import com.jc.study.play.with.state.models.case3.Case3ResNextRoundChanges
import kotlinx.coroutines.flow.StateFlow

object Case3NextRound {
    fun getNextRoundChanges(gmHeroesList: StateFlow<MutableList<Case3GameHeroesData>>): Case3ResNextRoundChanges {
        val result = Case3ResNextRoundChanges()
        gmHeroesList.value.forEach { hero ->
            run {
                result.heroTotal += 1

                when (hero.currentTask) {

                    // Hero actions
                    HeroConstants.TASK_NOTHING -> {
                        result.heroNothing += 1
                    }

                    HeroConstants.TASK_REST -> {
                        result.heroRest += 1
                    }

                    HeroConstants.TASK_HEAL -> {
                        result.heroHeal += 1
                    }

                    // Settlement scopes
                    HeroConstants.TASK_SCOUT -> {
                        result.heroScout += 1
                        result.scpScoutPoints += HeroConstants.DEFAULT_DO_SCOUT
                    }

                    HeroConstants.TASK_BUILD -> {
                        result.heroBuild += 1
                        result.scrConstructionPoints += HeroConstants.DEFAULT_DO_CONSTRUCTION
                    }

                    // Resources I
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

                    HeroConstants.TASK_HERBS -> {
                        result.heroHerbs += 1
                        result.resHerbs += HeroConstants.DEFAULT_DO_SCOUT
                    }

                    /*
    const val TASK_BUILD = 7
    const val TASK_HEAL = 8
                     */
                }
                result.heroSpendWater += hero.needWater
                result.heroSpendFood += hero.needFood
            }
        }

        result.spendWater += result.heroSpendWater
        result.spendFood += result.heroSpendFood
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
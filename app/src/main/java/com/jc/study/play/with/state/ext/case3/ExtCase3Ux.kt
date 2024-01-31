package com.jc.study.play.with.state.ext.case3

import com.jc.study.play.with.state.constants.HeroConstants

object ExtCase3Ux {

    fun getListOfNewOrders(): List<Int> {
        return listOf(
            HeroConstants.TASK_NOTHING,
            HeroConstants.TASK_REST,
            HeroConstants.TASK_WATER,
            HeroConstants.TASK_RAW_FOOD,
            HeroConstants.TASK_SCRAP,
            HeroConstants.TASK_HERBS,
            HeroConstants.TASK_SCOUT,
            HeroConstants.TASK_BUILD,
            HeroConstants.TASK_HEAL,
            HeroConstants.TASK_NOTHING
        )
    }

}
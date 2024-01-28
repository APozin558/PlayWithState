package com.jc.study.play.with.state.models.case3

import com.jc.study.play.with.state.constants.GeneratorConstants
import com.jc.study.play.with.state.constants.HeroConstants

data class Case3GameHeroesData(
    var id: Int = -1,
    var name: String = "??? ???",
    var currentTask: Int = HeroConstants.TASK_NOTHING,
    var orderedTask: Int = HeroConstants.TASK_NOTHING,
    val needWater: Float = HeroConstants.DEFAULT_NEED_WATER,
    val needFood: Float = HeroConstants.DEFAULT_NEED_FOOD
){
    companion object{
        private var nextId = 0

        fun create(orderedTask: Int):Case3GameHeroesData{
            val firstName = GeneratorConstants.HERO_FIRST_NAME[(GeneratorConstants.HERO_FIRST_NAME.indices).random()]
            val lastName = GeneratorConstants.HERO_LAST_NAME[(GeneratorConstants.HERO_LAST_NAME.indices).random()]

            return Case3GameHeroesData(
                id = nextId++,
                name = "$firstName $lastName",
                currentTask = orderedTask,
                orderedTask = orderedTask
            )
        }
    }
}

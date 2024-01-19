package com.jc.study.play.with.state.models.case3

import com.jc.study.play.with.state.ext.case3.ExtCase3.CASE_3_TASK_NOTHING

data class Case3GameHeroesData(
    var name: String,
    var currentOrder: Int = CASE_3_TASK_NOTHING
)

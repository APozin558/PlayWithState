package com.jc.study.play.with.state.models.case3

import com.jc.study.play.with.state.constants.CommonConstants

data class Case3GameCommonData(
    val roundNumber:Int = 0,
    val dayPeriod: Int = CommonConstants.TIME_MORNING,
    val dayN:Int = 1
)

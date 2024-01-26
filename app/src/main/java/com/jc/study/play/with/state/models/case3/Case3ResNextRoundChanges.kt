package com.jc.study.play.with.state.models.case3

data class Case3ResNextRoundChanges(
    var resWater: Float = 0.0f,
    var resRawFood: Float = 0.0f,
    var resScrap:Float = 0.0f,
    var resScout:Float = 0.0f,

    var heroTotal:Int = 0,
    var heroWater: Int = 0,
    var heroRawFood: Int = 0,
    var heroScrap: Int = 0,
    var heroScout: Int = 0,

    var spendWater: Float = 0.0f,
    var spendFood: Float = 0.0f,
    var spendScrap: Float = 0.0f
)

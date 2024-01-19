package com.jc.study.play.with.state.models.case2

data class Case2GameResources(
    var resPrimaryWater: Float = 0.0f,
    var resPrimaryRawFood: Float = 0.0f,
    var resPrimaryScrap: Float = 0.0f,
    var resPrimaryHerbs: Float = 0.0f
){
    fun getPrimaryWater():Int{
        return resPrimaryWater.toInt()
    }

    fun getPrimaryRawFood():Int{
        return resPrimaryRawFood.toInt()
    }

    fun getPrimaryScrap():Int{
        return resPrimaryScrap.toInt()
    }

    fun getPrimaryHerbs():Int{
        return resPrimaryHerbs.toInt()
    }

    fun updatePrimaryResources(newWater:Float, newRawFood:Float, newScrap:Float, newHerbs:Float):Case2GameResources{
        resPrimaryWater = newWater
        resPrimaryRawFood = newRawFood
        resPrimaryScrap = newScrap
        resPrimaryHerbs = newHerbs
        return this
    }
}

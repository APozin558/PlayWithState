package com.jc.study.play.with.state.models.case2

data class Case2ResourceNewRound(
    var resPrimaryWater: Float = 0.0f,
    var resPrimaryRawFood: Float = 0.0f,
    var resPrimaryScrap: Float = 0.0f,
    var resPrimaryHerbs: Float = 0.0f,

    var charPrimaryWater: Int = 0,
    var charPrimaryRawFood: Int = 0,
    var charPrimaryScrap: Int = 0,
    var charPrimaryHerbs: Int = 0,
){
    fun addWater(water:Float){
        resPrimaryWater += water
    }

    fun addRawFood(rawFood:Float){
        resPrimaryRawFood += rawFood
    }

    fun addScrap(scrap:Float){
        resPrimaryScrap += scrap
    }

    fun addHerbs(herbs:Float){
        resPrimaryHerbs += herbs
    }

    fun addCharWater(){
        charPrimaryWater++
    }

    fun addCharRawFood(){
        charPrimaryRawFood++
    }

    fun addCharScrap(){
        charPrimaryScrap++
    }

    fun addCharHerbs(){
        charPrimaryHerbs++
    }
}

package com.jc.study.play.with.state.models.case3

data class Case3ResNextRoundChanges(
    var nextRoundResources: Case3GameResourcesData = Case3GameResourcesData(),

    // Settlement points
    var scpScoutPoints:Float = 0.0f,
    var scpResearchPoints:Float = 0.0f,
    var scrConstructionPoints: Float = 0.0f,
    var scrManufacturingPoints: Float = 0.0f,

    var heroScout: Int = 0,
    var heroBuild: Int = 0,

    // Resources - Tier I
    var resWater: Float = 0.0f,
    var resRawFood: Float = 0.0f,
    var resScrap:Float = 0.0f,
    var resHerbs: Float = 0.0f,

    var heroWater: Int = 0,
    var heroRawFood: Int = 0,
    var heroScrap: Int = 0,
    var heroHerbs: Int = 0,

    // Resources - Tier II
    var resTools: Float = 0.0f,
    var resFuel: Float = 0.0f,
    var resRations: Float = 0.0f,
    var resMedicine: Float = 0.0f,
    var resMechanicParts: Float = 0.0f,
    var resElectronicComponents: Float = 0.0f,

    var heroTools: Int = 0,
    var heroFuel: Int = 0,
    var heroRations: Int = 0,
    var heroMedicine: Int = 0,
    var heroMechanicParts: Int = 0,
    var heroElectronicComponents: Int = 0,

    // Hero Actions Info
    var heroTotal:Int = 0,
    var heroNothing:Int = 0,
    var heroRest:Int = 0,
    var heroHeal:Int = 0,

    // Calculated
    var spendWater: Float = 0.0f,
    var spendFood: Float = 0.0f,
    var spendScrap: Float = 0.0f
)

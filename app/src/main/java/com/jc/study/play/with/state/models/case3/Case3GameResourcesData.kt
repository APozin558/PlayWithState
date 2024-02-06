package com.jc.study.play.with.state.models.case3

data class Case3GameResourcesData(
    // Resources Tier I
    val resWater: Float = 0.0f, // (WTR) BLUE
    val resRawFood: Float = 0.0f, // (RFD) GREEN
    val resScrap: Float = 0.0f, //  (SRP) BROWN
    val resHerbs: Float = 0.0f, // (HRB) GREEN

    // Resources Tier II
    val resTools: Float = 0.0f, // (TLS) BROWN
    val resFuel: Float = 0.0f,  // (FLS) BLUE
    val resRations: Float = 0.0f, // (RTN) GREEN
    val resMedicine: Float = 0.0f, // (MED) GREEN
    val resMechanicParts: Float = 0.0f, // (PRT) BROWN
    val resElectronicComponents: Float = 0.0f, // (CMP) BROWN

    // Military
    val resAmmunition: Float = 0.0f, // (AMN)
    val resMunitions: Float = 0.0f,  // (MNT)
    val resHeavyMunitions: Float = 0.0f,  // (HMN)
    val resEnergyMunitions: Float = 0.0f,  // (EMN)

    // Goods
    val resGoods: Float = 0.0f, // (GDS) YELLOW
    val resArtefacts: Float = 0.0f, // (ART) YELLOW
    val resLuxury: Float = 0.0f, // (LXR) YELLOW
    val resAlcohol: Float = 0.0f // (ALK) YELLOW
)

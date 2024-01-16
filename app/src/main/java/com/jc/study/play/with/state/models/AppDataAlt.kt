package com.jc.study.play.with.state.models

object AppDataAlt {
    private var counter: Int = 0

    fun getCounter():Int{
        return counter
    }

    fun incrementCounter(){
        counter++
    }
}
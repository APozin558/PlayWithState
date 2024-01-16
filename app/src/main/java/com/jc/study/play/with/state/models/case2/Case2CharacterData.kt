package com.jc.study.play.with.state.models.case2

import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_NOTHING
import com.jc.study.play.with.state.ext.ExtCase2GameDefaults.CASE_2_CHAR_FIRST_NAME
import com.jc.study.play.with.state.ext.ExtCase2GameDefaults.CASE_2_CHAR_LAST_NAME
import com.jc.study.play.with.state.ext.ExtCase2GameDefaults.CASE_2_GAME_DEFAULT_STAMINA

data class Case2CharacterData(
    val id: Int = -1,
    val name: String = "Jon Dove",
    val stamina: Int = CASE_2_GAME_DEFAULT_STAMINA,
    var orderId: Int = CASE_2_TASK_NOTHING,
    var currentOrderId: Int = CASE_2_TASK_NOTHING
){
    companion object {
        private var nextId = 0

        fun create(name: String, orderId: Int, currentOrderId:Int):Case2CharacterData{

            val firstName = CASE_2_CHAR_FIRST_NAME[(CASE_2_CHAR_FIRST_NAME.indices).random()]
            val lastName = CASE_2_CHAR_LAST_NAME[(CASE_2_CHAR_LAST_NAME.indices).random()]

            return Case2CharacterData(
                id = nextId++,
                name = "$firstName $lastName",
                orderId = orderId,
                currentOrderId = currentOrderId
            )
        }
    }
}

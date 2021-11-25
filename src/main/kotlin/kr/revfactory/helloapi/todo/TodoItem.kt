package kr.revfactory.helloapi.todo

import java.time.LocalDate

data class TodoItem(
    val id: Long,
    var description: String,
    var date: LocalDate,
    var finished: Boolean
)
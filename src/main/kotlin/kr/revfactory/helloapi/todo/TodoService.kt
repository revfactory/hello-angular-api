package kr.revfactory.helloapi.todo

import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class TodoService {
    companion object {
        val todos = mutableListOf(
            TodoItem( 1, "주말작업 확인하기", LocalDate.of(2021,11,26), true),
            TodoItem(2, "연말정산 서류 제출", LocalDate.of(2021,11,26), false),
            TodoItem(3, "일일 업무계획", LocalDate.of(2021,11,26), false)
        )
    }
    fun getTodos() = todos.sortedBy { it.id }
    fun getById(id: Long) = todos.first { it.id == id }
    fun modify(id: Long, todoItem: TodoItem) = getById(id).let { todos.remove(it) }.let { todos.add(todoItem) }
}
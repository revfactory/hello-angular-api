package kr.revfactory.helloapi.todo

import org.springframework.web.bind.annotation.*

@RequestMapping("/todos")
@RestController
class TodoController(private val todoService: TodoService) {

    @GetMapping
    fun getTodos(): List<TodoItem> {
        return todoService.getTodos()
    }

    @GetMapping("{id}")
    fun getTodo(@PathVariable id: Long): TodoItem {
        return todoService.getById(id)
    }

    @PutMapping("{id}")
    fun modifyTodo(@PathVariable id: Long, @RequestBody todoItem: TodoItem): Boolean {
        return todoService.modify(id, todoItem)
    }
}
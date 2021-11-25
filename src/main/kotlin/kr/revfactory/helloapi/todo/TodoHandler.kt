package kr.revfactory.helloapi.todo

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.servlet.function.ServerRequest
import org.springframework.web.servlet.function.ServerResponse.ok
import org.springframework.web.servlet.function.body

@Component
class TodoHandler(private val todoService: TodoService) {
    fun getAll(req: ServerRequest) = ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(todoService.getTodos())

    fun getById(req: ServerRequest) = ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(todoService.getById(req.pathVariable("id").toLong()))

    fun modify(req: ServerRequest) = ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(todoService.modify(req.pathVariable("id").toLong(), req.body()))
}
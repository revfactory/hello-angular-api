package kr.revfactory.helloapi.config

import kr.revfactory.helloapi.todo.TodoHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.function.RequestPredicates.path
import org.springframework.web.servlet.function.RouterFunctions.nest
import org.springframework.web.servlet.function.router

@Configuration
class TodoRouter(private val handler: TodoHandler) {
    @Bean
    fun routerFunction() = nest(path("/v2/todos"),
        router {
            listOf(
                GET("/", handler::getAll),
                GET("/{id}", handler::getById),
                PUT("/{id}", handler::modify),
            )
        }
        )
}
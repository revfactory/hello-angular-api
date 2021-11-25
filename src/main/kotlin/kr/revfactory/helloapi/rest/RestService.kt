package kr.revfactory.helloapi.rest

import kr.revfactory.helloapi.todo.TodoItem
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import javax.annotation.PostConstruct

@Service
class RestService(val restTemplateBuilder: RestTemplateBuilder) {
    private lateinit var restTemplate: RestTemplate

    @PostConstruct
    fun setWebClient() {
        restTemplate = restTemplateBuilder.build()
    }

    fun getTodo(): ResponseEntity<TodoItem> {
        return restTemplate.getForEntity("http://localhost:8080", TodoItem::class.java)
    }
}
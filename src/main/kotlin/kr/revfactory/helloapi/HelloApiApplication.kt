package kr.revfactory.helloapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloApiApplication

fun main(args: Array<String>) {
	runApplication<HelloApiApplication>(*args)
}

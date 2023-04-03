package com.paddock.pizza

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PizzaToppingsApplication

fun main(args: Array<String>) {
	runApplication<PizzaToppingsApplication>(*args)
}

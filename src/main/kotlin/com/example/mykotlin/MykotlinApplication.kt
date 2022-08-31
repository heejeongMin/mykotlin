package com.example.mykotlin

import com.example.mykotlin.config.*
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@EnableConfigurationProperties(ApplicationProperties::class)
@SpringBootApplication
class MykotlinApplication

fun main(args: Array<String>) {
    runApplication<MykotlinApplication>(*args)
}

@RestController
class HelloController {

    @GetMapping("/")
    fun sayHello () {
        val hello = "hello".encrypt()
        println(hello)
       println(hello.decrypt())
    }
}

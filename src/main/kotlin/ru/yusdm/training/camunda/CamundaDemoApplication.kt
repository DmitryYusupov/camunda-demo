package ru.yusdm.training.camunda

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableProcessApplication
class CamundaDemoApplication

fun main(args: Array<String>) {
	runApplication<CamundaDemoApplication>(*args)
}

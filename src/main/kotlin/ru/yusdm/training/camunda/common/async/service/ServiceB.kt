package ru.yusdm.training.camunda.common.async.service

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.solutions.logger

@Service
class ServiceB {

    private val log = ServiceB::class.logger

    fun execute() {
        log.info("This is service B")
    }
}
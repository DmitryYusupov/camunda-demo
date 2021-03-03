package ru.yusdm.training.camunda.flows.async.service

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.solutions.logger

@Service
class ServiceA {

    private val log = ServiceA::class.logger

    fun execute() {
        log.info("This is service A")
        Thread.sleep(3000)
    }
}
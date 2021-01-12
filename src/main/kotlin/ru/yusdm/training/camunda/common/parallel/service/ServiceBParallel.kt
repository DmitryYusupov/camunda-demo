package ru.yusdm.training.camunda.common.parallel.service

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.solutions.logger

@Service
class ServiceBParallel {

    private val log = ServiceBParallel::class.logger

    fun execute() {
        log.info("Service B begin")
        Thread.sleep(3000)
        log.info("Service B end")
    }
}
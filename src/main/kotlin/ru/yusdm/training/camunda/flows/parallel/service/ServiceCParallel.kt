package ru.yusdm.training.camunda.flows.parallel.service

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.solutions.logger

@Service
class ServiceCParallel {

    private val log = ServiceCParallel::class.logger

    fun execute() {
        log.info("Service C begin")
        Thread.sleep(3000)
        log.info("Service C end")
    }
}
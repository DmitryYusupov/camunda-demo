package ru.yusdm.training.camunda.flows.parallel.service

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.solutions.logger

@Service
class ServiceAParallel {

    private val log = ServiceAParallel::class.logger

    fun execute() {
        log.info("Service A begin")
        Thread.sleep(3000)
        log.info("Service A end")
    }
}
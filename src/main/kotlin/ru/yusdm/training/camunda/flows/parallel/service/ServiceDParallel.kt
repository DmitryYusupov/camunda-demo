package ru.yusdm.training.camunda.flows.parallel.service

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.solutions.logger

@Service
class ServiceDParallel {

    private val log = ServiceDParallel::class.logger

    fun execute() {
        log.info("All services finished")
    }
}
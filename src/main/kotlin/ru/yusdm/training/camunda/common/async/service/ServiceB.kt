package ru.yusdm.training.camunda.common.async.service

import org.camunda.bpm.engine.delegate.BpmnError
import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.solutions.logger

@Service
class ServiceB {

    private val log = ServiceB::class.logger

    /**
     * 1) Run without exception
     * 2) Run with exception
     * 3) Fix exception
     * 4) Go to cockpit
     * 5) Retry it
     * 6) Process b Will continue
     *
     *
     * Retry policies R2/P1S - two time per secd
     * R2/P4M - 2 times per 4 min
     *
     * R0/PT1S - no retry - it is set in ServiceB job by in file
     */
    fun execute() {
        log.info("This is service B")
        //todo play with it
        throw RuntimeException()
      //  throw BpmnError("BULL SHIT Happened")
    }
}
package ru.yusdm.training.camunda.flows.parallel.api

import org.camunda.bpm.engine.RuntimeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.yusdm.training.camunda.common.solutions.logger
import kotlin.system.measureTimeMillis

@RestController
@RequestMapping("/api/paralleltasks")
class ParallelTasksExecutionFlowController(private val runtimeService: RuntimeService) {

    private val log = ParallelTasksExecutionFlowController::class.logger
    //localhost:8080/api/paralleltasks/demo
    @GetMapping("/demo")
    fun demo() {
        val total = measureTimeMillis {
            runtimeService.startProcessInstanceByKey("parallelFlow")
        }
        log.info("TOTAL duration $total")
    }
}
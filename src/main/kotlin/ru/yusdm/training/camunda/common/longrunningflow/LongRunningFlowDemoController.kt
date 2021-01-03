package ru.yusdm.training.camunda.common.longrunningflow

import org.camunda.bpm.engine.RuntimeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.yusdm.training.camunda.common.solutions.logger

@RestController
@RequestMapping(value = ["/api/long_running_flow"])
class LongRunningFlowDemoController(private val longRunningFlowExecutor: LongRunningFlowExecutor) {

    private val log = LongRunningFlowDemoController::class.logger

    //http://localhost:8080/api/long_running_flow/demo
    @GetMapping("/demo")
    fun demoFlow(): String {
        log.info("Demo long running")
        return longRunningFlowExecutor.startForResultLongRunningFlow()
    }
}
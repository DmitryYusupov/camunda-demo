package ru.yusdm.training.camunda.flows.returnresultflow

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.yusdm.training.camunda.common.solutions.logger

@RestController
@RequestMapping(value = ["/api/return_result_flow"])
class ReturnResultFlowDemoController(private val returnResultFlowExecutor: ReturnResultFlowExecutor) {

    private val log = ReturnResultFlowDemoController::class.logger

    //http://localhost:8080/api/return_result_flow/demo
    @GetMapping("/demo")
    fun demoFlow(): String {
        log.info("Demo return result")
        return returnResultFlowExecutor.startForResultLongRunningFlow()
    }
}
package ru.yusdm.training.camunda.flows.async.api

import org.camunda.bpm.engine.RuntimeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/async"])
class AsyncFlowDemoController(private val runtimeService: RuntimeService) {
    //http://localhost:8080/api/async/demo
    @GetMapping("/demo")
    fun demo() {
        runtimeService.startProcessInstanceByKey("asyncFlow")
    }
}
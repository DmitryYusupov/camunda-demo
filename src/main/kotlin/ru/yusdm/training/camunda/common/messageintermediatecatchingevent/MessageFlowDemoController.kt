package ru.yusdm.training.camunda.common.messageintermediatecatchingevent

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/message_flow"])
class MessageFlowDemoController(private val flowExecutor: MessageIntermediateCatchingEventFlowExecutor) {

    @GetMapping("/demo")
    fun demoFlow() {
        flowExecutor.startFlow()
    }

}
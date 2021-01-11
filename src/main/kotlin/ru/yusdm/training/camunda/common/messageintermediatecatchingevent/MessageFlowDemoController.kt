package ru.yusdm.training.camunda.common.messageintermediatecatchingevent

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.yusdm.training.camunda.common.solutions.logger

@RestController
@RequestMapping(value = ["/api/message_flow"])
class MessageFlowDemoController(private val flowExecutor: MessageIntermediateCatchingEventFlowExecutor) {

    private val log = MessageFlowDemoController::class.logger

    @GetMapping("/demo")
    fun demoFlow() {
        flowExecutor.startFlow()
    }

    @GetMapping("/ticketresponse/{userId}")
    fun ticketResponse(@PathVariable("userId") userId: Int) {
        log.info("Ticket response for user $userId")
        MessageFlowStorage.findByUserId(userId)?.let {

        }
    }

}
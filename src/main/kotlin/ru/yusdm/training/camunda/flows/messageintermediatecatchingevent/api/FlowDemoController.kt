package ru.yusdm.training.camunda.flows.messageintermediatecatchingevent.api

import org.camunda.bpm.engine.RuntimeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.yusdm.training.camunda.flows.messageintermediatecatchingevent.service.ticketresponse.TicketBidResponseMessage
import ru.yusdm.training.camunda.flows.messageintermediatecatchingevent.service.ticketresponse.TicketBidResponseStatus
import ru.yusdm.training.camunda.common.solutions.logger

@RestController
@RequestMapping(value = ["/api/message_flow"])
class FlowDemoController(private val flowExecutor: FlowExecutor, private val runtimeService: RuntimeService) {

    private val log = FlowDemoController::class.logger

    //http://localhost:8080/api/message_flow/demo/1
    @GetMapping("/demo/{userId}")
    fun demoFlow(@PathVariable("userId") userId: Int) {
        flowExecutor.startFlow(userId)
    }

    //http://localhost:8080/api/message_flow/ticketresponse/1
    @GetMapping("/ticketresponse/{userId}")
    fun ticketResponse(@PathVariable("userId") userId: Int) {
        log.info("Ticket response for user $userId")
        val tickerBidResponseMessage = TicketBidResponseMessage(
            if (userId % 2 == 0) TicketBidResponseStatus.APPROVED else TicketBidResponseStatus.DENIED,
            userId
        )
        tickerBidResponseMessage.bind(runtimeService)
    }

}
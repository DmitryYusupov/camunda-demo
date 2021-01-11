package ru.yusdm.training.camunda.common.messageintermediatecatchingevent

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.solutions.logger

@Service
class MessageFlowTicketResponse {

    private val log = MessageFlowTicketResponse::class.logger

    fun notifyUserTicketStatus() {
        log.info("Notify user")
    }
}
package ru.yusdm.training.camunda.flows.messageintermediatecatchingevent.service.ticketrequest

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.solutions.logger

@Service
class TicketRequestService {

    private val log = TicketRequestService::class.logger

    fun execute(userId: Int) {
        log.info("Request ticket for user $userId")
        log.info("Waiting for event to continue")
    }
}
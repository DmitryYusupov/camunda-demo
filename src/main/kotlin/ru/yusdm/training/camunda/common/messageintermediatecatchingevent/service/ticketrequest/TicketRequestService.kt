package ru.yusdm.training.camunda.common.messageintermediatecatchingevent.service.ticketrequest

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.solutions.logger
import java.util.concurrent.atomic.AtomicInteger

@Service
class TicketRequestService {

    private val log = TicketRequestService::class.logger
    private val userIdGenerator = AtomicInteger(0)

    fun execute() {
        val userId = userIdGenerator.incrementAndGet()
        log.info("Request ticket for user $userId")
        log.info("Waiting for event to continue")
    }
}
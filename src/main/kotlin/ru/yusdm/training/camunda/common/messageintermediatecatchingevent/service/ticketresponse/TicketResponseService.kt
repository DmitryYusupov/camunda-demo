package ru.yusdm.training.camunda.common.messageintermediatecatchingevent.service.ticketresponse

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.solutions.logger

@Service
class TicketResponseService {

    private val log = TicketResponseService::class.logger

    fun notifyUserTicketStatus(message: TicketBidResponseMessage) {
        when (message.status){
            TicketBidResponseStatus.APPROVED -> log.info("Bid Ticket for user ${message.userId}.Status Approved")
            TicketBidResponseStatus.DENIED -> log.info("Bid Ticket for user ${message.userId} was DENIED")
        }
    }
}
package ru.yusdm.training.camunda.common.messageintermediatecatchingevent.service.ticketresponse

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.yusdm.training.camunda.common.creditflow.services.CreditFlowExecutor
import ru.yusdm.training.camunda.common.messageintermediatecatchingevent.api.FlowExecutor
import ru.yusdm.training.camunda.common.solutions.camunda.get

@Component("messageFlowTicketResponseCamunda")
class TicketResponseCamunda(private val ticketResponseService: TicketResponseService) :
    JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        val message = execution.get<TicketBidResponseMessage>(FlowExecutor.TICKET_BID_MESSAGE_RESPONSE)!!
        ticketResponseService.notifyUserTicketStatus(message)
    }
}
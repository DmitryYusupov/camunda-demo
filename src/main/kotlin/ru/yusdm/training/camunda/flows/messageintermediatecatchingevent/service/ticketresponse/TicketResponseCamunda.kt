package ru.yusdm.training.camunda.flows.messageintermediatecatchingevent.service.ticketresponse

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.yusdm.training.camunda.flows.messageintermediatecatchingevent.api.FlowExecutor
import ru.yusdm.training.camunda.common.solutions.camunda.get

@Component("messageFlowTicketResponseCamunda")
class TicketResponseCamunda(private val ticketResponseService: TicketResponseService) :
    JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        val message = execution.get<TicketBidResponseMessage>(FlowExecutor.TICKET_BID_MESSAGE_RESPONSE)!!
        ticketResponseService.notifyUserTicketStatus(message)
    }
}
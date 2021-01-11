package ru.yusdm.training.camunda.common.messageintermediatecatchingevent.service.ticketrequest;

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component;

@Component("messageFlowTicketRequestCamunda")
class TicketRequestCamunda(private val ticketRequestService: TicketRequestService) : JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        ticketRequestService.execute()
    }
}

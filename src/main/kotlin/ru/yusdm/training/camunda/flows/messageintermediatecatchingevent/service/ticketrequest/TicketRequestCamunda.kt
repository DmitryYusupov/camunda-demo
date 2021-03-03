package ru.yusdm.training.camunda.flows.messageintermediatecatchingevent.service.ticketrequest;

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component;
import ru.yusdm.training.camunda.common.solutions.camunda.get
import ru.yusdm.training.camunda.flows.messageintermediatecatchingevent.api.FlowExecutor

@Component("messageFlowTicketRequestCamunda")
class TicketRequestCamunda(private val ticketRequestService: TicketRequestService) : JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        ticketRequestService.execute(execution[FlowExecutor.USER_ID]!!)
    }
}

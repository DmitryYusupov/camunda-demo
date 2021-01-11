package ru.yusdm.training.camunda.common.messageintermediatecatchingevent;

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component;

@Component("messageFlowTicketRequestCamunda")
class MessageFlowTicketRequestCamunda(private val messageFlowTicketRequest: MessageFlowTicketRequest) : JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        messageFlowTicketRequest.execute()
    }
}

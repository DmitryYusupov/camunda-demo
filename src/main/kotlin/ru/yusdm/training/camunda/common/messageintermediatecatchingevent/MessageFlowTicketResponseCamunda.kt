package ru.yusdm.training.camunda.common.messageintermediatecatchingevent

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component("messageFlowTicketResponseCamunda")
class MessageFlowTicketResponseCamunda(private val messageFlowTicketResponse: MessageFlowTicketResponse) :
    JavaDelegate {

    override fun execute(execution: DelegateExecution?) {
        messageFlowTicketResponse.notifyUserTicketStatus()
    }
}
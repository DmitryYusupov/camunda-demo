package ru.yusdm.training.camunda.common.messageintermediatecatchingevent.service.ticketresponse

import org.camunda.bpm.engine.RuntimeService
import org.camunda.bpm.engine.runtime.Execution
import ru.yusdm.training.camunda.common.messageintermediatecatchingevent.api.FlowExecutor
import ru.yusdm.training.camunda.common.solutions.camunda.Message
import ru.yusdm.training.camunda.common.solutions.camunda.MessageType
import java.io.Serializable

enum class TicketBidResponseStatus {
    APPROVED, DENIED
}

enum class MessageTypes(override val id: String) : MessageType {
    TICKET_RESPONSE("ticketBidResponseMessage33")
}

class TicketBidResponseMessage(
    val status: TicketBidResponseStatus,
    val userId: Int
) : Message, Serializable {

    override val type: MessageType
        get() = MessageTypes.TICKET_RESPONSE

    override fun findMessageExecutionContext(runtimeService: RuntimeService): Execution? {
        return runtimeService.createExecutionQuery()
            .messageEventSubscriptionName(MessageTypes.TICKET_RESPONSE.id)
            .processDefinitionKey(FlowExecutor.FLOW_NAME)
            .processVariableValueEquals(FlowExecutor.USER_ID, userId)
            .active()
            .singleResult()
    }

    override fun bind(runtimeService: RuntimeService, params: MutableMap<String, Any>) {
        val execution = findMessageExecutionContext(runtimeService)
        execution?.let {
            params[FlowExecutor.TICKET_BID_MESSAGE_RESPONSE] = this
            runtimeService.messageEventReceived(type.id, it.id, params)
        }
    }

}
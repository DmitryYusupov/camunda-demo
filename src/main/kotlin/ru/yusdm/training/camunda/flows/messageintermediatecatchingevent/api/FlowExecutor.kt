package ru.yusdm.training.camunda.flows.messageintermediatecatchingevent.api

import org.camunda.bpm.engine.RuntimeService
import org.springframework.stereotype.Component

@Component
class FlowExecutor(private val runtimeService: RuntimeService) {

    companion object FlowVariables {
        const val FLOW_NAME = "message_Intermediate_Catching_Event_Flow"
        const val USER_ID = "userId"
        const val TICKET_BID_MESSAGE_RESPONSE = "ticketBidMessageResponse"
    }

    fun startFlow(userId: Int) {
        runtimeService.startProcessInstanceByKey(FLOW_NAME, mapOf(USER_ID to userId))
    }
}
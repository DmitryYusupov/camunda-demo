package ru.yusdm.training.camunda.common.messageintermediatecatchingevent

import org.camunda.bpm.engine.RuntimeService
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables
import org.springframework.stereotype.Component

@Component
class MessageIntermediateCatchingEventFlowExecutor(private val runtimeService: RuntimeService) {

    companion object FlowVariables {
        const val FLOW_NAME = "Message_Intermediate_Catching_Event_Flow"
    }

    fun startFlow() {
        val processInstance: ProcessInstanceWithVariables = runtimeService.createProcessInstanceByKey(FLOW_NAME).
        executeWithVariablesInReturn()
    }
}
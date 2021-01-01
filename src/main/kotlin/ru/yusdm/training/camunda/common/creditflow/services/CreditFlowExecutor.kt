package ru.yusdm.training.camunda.common.creditflow.services

import org.camunda.bpm.engine.RuntimeService
import org.springframework.stereotype.Component


@Component
class CreditFlowExecutor(private val runtimeService: RuntimeService) {

    companion object FlowVariables {
        const val FLOW_NAME = "creditFlow"
        const val USER_ID = "userId"
        const val USER = "user"
    }

    fun calcCreditForUser(userId: Long) {
        runtimeService.startProcessInstanceByKey(FLOW_NAME, mapOf(
            USER_ID to userId
        ))
    }
}
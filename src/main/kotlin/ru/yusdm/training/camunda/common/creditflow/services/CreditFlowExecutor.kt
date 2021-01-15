package ru.yusdm.training.camunda.common.creditflow.services

import org.camunda.bpm.engine.RuntimeService
import org.camunda.bpm.engine.runtime.ProcessInstance
import org.springframework.stereotype.Component


@Component
class CreditFlowExecutor(private val runtimeService: RuntimeService) {

    companion object FlowVariables {
        const val FLOW_NAME = "creditFlow"
        const val USER_ID = "userId"
        const val USER = "user"
        const val USER_FROM_SPB = "userFromSpb"
        const val CREDIT_HISTORY_STATUS = "creditHistoryStatus"
        const val INCOME_STATUS = "incomeStatus"
        const val CREDIT_APPROVED = "creditApproved"
    }

    fun calcCreditForUser(userId: Long) {
        val processInstance: ProcessInstance = runtimeService.startProcessInstanceByKey(FLOW_NAME, mapOf(
            USER_ID to userId
        ))
    }
}
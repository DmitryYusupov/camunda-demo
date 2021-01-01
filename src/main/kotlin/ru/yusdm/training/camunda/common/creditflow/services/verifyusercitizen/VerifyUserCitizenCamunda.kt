package ru.yusdm.training.camunda.common.creditflow.services.verifyusercitizen

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.yusdm.training.camunda.common.creditflow.services.CreditFlowExecutor.FlowVariables.USER_ID
import ru.yusdm.training.camunda.common.solutions.camunda.get

@Component
class VerifyUserCitizenServiceCamunda(private val verifyUserCitizenService: VerifyUserCitizenService) : JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        val userId: Long? = execution[USER_ID]
        userId?.let {
            verifyUserCitizenService.verifyUserFromRussia(userId)
        }
    }
}
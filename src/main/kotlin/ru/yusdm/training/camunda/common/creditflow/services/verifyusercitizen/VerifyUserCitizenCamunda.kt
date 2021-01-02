package ru.yusdm.training.camunda.common.creditflow.services.verifyusercitizen

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.yusdm.training.camunda.common.creditflow.model.User
import ru.yusdm.training.camunda.common.creditflow.services.CreditFlowExecutor
import ru.yusdm.training.camunda.common.creditflow.services.CreditFlowExecutor.FlowVariables.USER
import ru.yusdm.training.camunda.common.creditflow.services.CreditFlowExecutor.FlowVariables.USER_ID
import ru.yusdm.training.camunda.common.solutions.camunda.get
import ru.yusdm.training.camunda.common.solutions.camunda.set
import ru.yusdm.training.camunda.common.solutions.logger

@Component("verifyUserCitizenServiceCamunda")
class VerifyUserCitizenServiceCamunda(private val verifyUserCitizenService: VerifyUserCitizenService) : JavaDelegate {

    private val log = VerifyUserCitizenServiceCamunda::class.logger

    override fun execute(execution: DelegateExecution) {
        val user: User? = execution[USER]
        user?.let {
            log.info("Verify user citizen")
            val userFromRussia = verifyUserCitizenService.verifyUserFromRussia(user)
            if (userFromRussia){
                log.info("User from Russia")
            }
        }
    }
}
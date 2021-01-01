package ru.yusdm.training.camunda.common.creditflow.services.verifyusercitizen

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.yusdm.training.camunda.common.solutions.camunda.get

val USER_ID = "userId"

@Component
class VerifyUserCitizenServiceCamunda(private val verifyUserCitizenService: VerifyUserCitizenService) : JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        val userId: Long? = execution[USER_ID]
        userId?.let {
            verifyUserCitizenService.verifyUserFromRussia(userId)
        }
    }
}
package ru.yusdm.training.camunda.common.creditflow.services.checkuserpresence

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.yusdm.training.camunda.common.creditflow.services.CreditFlowExecutor.FlowVariables.USER
import ru.yusdm.training.camunda.common.creditflow.services.CreditFlowExecutor.FlowVariables.USER_ID
import ru.yusdm.training.camunda.common.solutions.camunda.get
import ru.yusdm.training.camunda.common.solutions.camunda.set
import ru.yusdm.training.camunda.common.solutions.logger


@Component("checkUserPresenceCamunda")
class CheckUserPresenceCamunda(private val checkUserPresenceService: CheckUserPresenceService) : JavaDelegate {

    val log = CheckUserPresenceCamunda::class.logger

    override fun execute(execution: DelegateExecution) {
        val userId: Long? = execution[USER_ID]

        userId?.let {
            log.info("Check if we have user with ID = $it in system")
            val user = checkUserPresenceService.findUserById(userId)
            if (user != null) {
                execution[USER] = user
                log.info("User is present: UserName = ${user.name}")
            } else {
                execution.setVariable(USER, null)
                log.info("No user with id = $it in system")
            }
        } ?: kotlin.run {
            log.warn("Can't get user id from context")
        }
    }
}
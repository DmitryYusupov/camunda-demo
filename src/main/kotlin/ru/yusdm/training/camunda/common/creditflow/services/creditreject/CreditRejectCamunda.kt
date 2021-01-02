package ru.yusdm.training.camunda.common.creditflow.services.creditreject

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.yusdm.training.camunda.common.creditflow.model.User
import ru.yusdm.training.camunda.common.creditflow.services.CreditFlowExecutor.FlowVariables.USER
import ru.yusdm.training.camunda.common.creditflow.services.CreditFlowExecutor.FlowVariables.USER_ID
import ru.yusdm.training.camunda.common.solutions.camunda.get

@Component("creditRejectCamunda")
class CreditRejectCamunda(private val creditRejectService: CreditRejectService): JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        creditRejectService.rejectCredit(
            CreditRejectContext(
                userId = execution[USER_ID]!!,
                noUserFoundInSystem = execution.get<User?>(USER) == null
            )
        )
    }
}
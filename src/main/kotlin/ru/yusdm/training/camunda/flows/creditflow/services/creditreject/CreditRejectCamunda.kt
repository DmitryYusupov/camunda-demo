package ru.yusdm.training.camunda.flows.creditflow.services.creditreject

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.yusdm.training.camunda.flows.creditflow.model.User
import ru.yusdm.training.camunda.flows.creditflow.services.CreditFlowExecutor.FlowVariables.CREDIT_HISTORY_STATUS
import ru.yusdm.training.camunda.flows.creditflow.services.CreditFlowExecutor.FlowVariables.INCOME_STATUS
import ru.yusdm.training.camunda.flows.creditflow.services.CreditFlowExecutor.FlowVariables.USER
import ru.yusdm.training.camunda.flows.creditflow.services.CreditFlowExecutor.FlowVariables.USER_FROM_SPB
import ru.yusdm.training.camunda.flows.creditflow.services.CreditFlowExecutor.FlowVariables.USER_ID
import ru.yusdm.training.camunda.flows.creditflow.services.credithistory.CreditHistoryStatus
import ru.yusdm.training.camunda.flows.creditflow.services.credithistory.IncomeVerifyStatus
import ru.yusdm.training.camunda.common.solutions.camunda.get

@Component("creditRejectCamunda")
class CreditRejectCamunda(private val creditRejectService: CreditRejectService): JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        creditRejectService.rejectCredit(
            CreditRejectContext(
                userId = execution[USER_ID]!!,
                noUserFoundInSystem = execution.get<User?>(USER) == null,
                userFromSpb = execution[USER_FROM_SPB],
                historyStatus = execution.get<String>(CREDIT_HISTORY_STATUS)?.let {
                    CreditHistoryStatus.valueOf(it)
                },
                incomeStatus = execution.get<String>(INCOME_STATUS)?.let {
                    IncomeVerifyStatus.valueOf(it)
                }
            )
        )
    }
}
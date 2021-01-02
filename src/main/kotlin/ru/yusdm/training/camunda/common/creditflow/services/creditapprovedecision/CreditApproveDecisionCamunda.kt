package ru.yusdm.training.camunda.common.creditflow.services.creditapprovedecision

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.yusdm.training.camunda.common.creditflow.services.CreditFlowExecutor.FlowVariables.CREDIT_APPROVED
import ru.yusdm.training.camunda.common.creditflow.services.CreditFlowExecutor.FlowVariables.CREDIT_HISTORY_STATUS
import ru.yusdm.training.camunda.common.creditflow.services.credithistory.CreditHistory
import ru.yusdm.training.camunda.common.solutions.camunda.get
import ru.yusdm.training.camunda.common.solutions.camunda.set

@Component("creditApproveDecisionCamunda")
class CreditApproveDecisionCamunda(private val creditApproveDecisionService: CreditApproveDecisionService): JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        execution[CREDIT_APPROVED] = creditApproveDecisionService.approveCredit(
            creditHistory = CreditHistory.valueOf(execution.get<String>(CREDIT_HISTORY_STATUS)!!)
        )
    }

}
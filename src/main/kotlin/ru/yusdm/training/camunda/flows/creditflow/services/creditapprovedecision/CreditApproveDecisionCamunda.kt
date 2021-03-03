package ru.yusdm.training.camunda.flows.creditflow.services.creditapprovedecision

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.yusdm.training.camunda.flows.creditflow.services.CreditFlowExecutor.FlowVariables.CREDIT_APPROVED
import ru.yusdm.training.camunda.flows.creditflow.services.CreditFlowExecutor.FlowVariables.CREDIT_HISTORY_STATUS
import ru.yusdm.training.camunda.flows.creditflow.services.CreditFlowExecutor.FlowVariables.INCOME_STATUS
import ru.yusdm.training.camunda.flows.creditflow.services.credithistory.CreditHistoryStatus
import ru.yusdm.training.camunda.flows.creditflow.services.credithistory.IncomeVerifyStatus
import ru.yusdm.training.camunda.common.solutions.camunda.get
import ru.yusdm.training.camunda.common.solutions.camunda.set

@Component("creditApproveDecisionCamunda")
class CreditApproveDecisionCamunda(private val creditApproveDecisionService: CreditApproveDecisionService): JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        execution[CREDIT_APPROVED] = creditApproveDecisionService.approveCredit(
            creditHistoryStatus = CreditHistoryStatus.valueOf(execution.get<String>(CREDIT_HISTORY_STATUS)!!),
            incomeVerifyStatus = IncomeVerifyStatus.valueOf(execution.get<String>(INCOME_STATUS)!!)
        )
    }

}
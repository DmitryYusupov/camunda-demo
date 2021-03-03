package ru.yusdm.training.camunda.flows.creditflow.services.credithistory

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.yusdm.training.camunda.flows.creditflow.services.CreditFlowExecutor.FlowVariables.INCOME_STATUS
import ru.yusdm.training.camunda.flows.creditflow.services.CreditFlowExecutor.FlowVariables.USER_ID
import ru.yusdm.training.camunda.common.solutions.camunda.get
import ru.yusdm.training.camunda.common.solutions.camunda.set
import ru.yusdm.training.camunda.common.solutions.logger

@Component("incomeVerifyCamunda")
class IncomeVerifyComunda(private val incomeVerifyService: IncomeVerifyService): JavaDelegate {

    private val log = IncomeVerifyComunda::class.logger

    override fun execute(execution: DelegateExecution) {
        val userId: Long = execution[USER_ID]!!
        log.info("Verify income for user with id $userId")
        execution[INCOME_STATUS] = incomeVerifyService.checkUserCreditHistory(userId).name
    }

}
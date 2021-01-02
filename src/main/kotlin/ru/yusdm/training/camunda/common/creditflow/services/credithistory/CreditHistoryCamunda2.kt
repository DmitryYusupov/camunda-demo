package ru.yusdm.training.camunda.common.creditflow.services.credithistory

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.yusdm.training.camunda.common.creditflow.services.CreditFlowExecutor.FlowVariables.CREDIT_HISTORY_STATUS
import ru.yusdm.training.camunda.common.creditflow.services.CreditFlowExecutor.FlowVariables.USER_ID
import ru.yusdm.training.camunda.common.solutions.camunda.get
import ru.yusdm.training.camunda.common.solutions.camunda.set
import ru.yusdm.training.camunda.common.solutions.logger

@Component("creditHistoryCamunda2")
class CreditHistoryCamunda2() : JavaDelegate {

    private val log = CreditHistoryCamunda2::class.logger

    override fun execute(execution: DelegateExecution) {
        val userId: Long = execution[USER_ID]!!
        log.info("Fetch_2 credit history for user with id = $userId")
    }

}
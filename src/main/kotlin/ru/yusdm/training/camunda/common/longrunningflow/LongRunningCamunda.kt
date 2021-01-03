package ru.yusdm.training.camunda.common.longrunningflow

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.yusdm.training.camunda.common.longrunningflow.LongRunningFlowExecutor.FlowVariables.FLOW_RESULT
import ru.yusdm.training.camunda.common.solutions.camunda.set

@Component("longRunningCamunda")
class LongRunningCamunda(private val longRunningService: LongRunningService): JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        execution[FLOW_RESULT] = longRunningService.execute()
    }
}
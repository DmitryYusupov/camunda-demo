package ru.yusdm.training.camunda.common.longrunningflow

import org.camunda.bpm.engine.RuntimeService
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables
import org.springframework.stereotype.Component
import ru.yusdm.training.camunda.common.solutions.camunda.get


@Component
class LongRunningFlowExecutor(private val runtimeService: RuntimeService) {

    companion object FlowVariables {
        const val FLOW_NAME = "long_running_flow"
        const val FLOW_RESULT = "flowResult"
    }

    fun startForResultLongRunningFlow(): String {
        val processInstance: ProcessInstanceWithVariables = runtimeService.createProcessInstanceByKey(FLOW_NAME).executeWithVariablesInReturn()
        return if (processInstance.isEnded) {
            processInstance[FLOW_RESULT]!!
        } else {
            throw RuntimeException("Process is not ended")
        }
    }
}
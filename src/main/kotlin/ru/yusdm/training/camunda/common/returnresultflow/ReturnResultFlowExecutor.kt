package ru.yusdm.training.camunda.common.returnresultflow

import org.camunda.bpm.engine.RuntimeService
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables
import org.springframework.stereotype.Component
import ru.yusdm.training.camunda.common.solutions.camunda.get


@Component
class ReturnResultFlowExecutor(private val runtimeService: RuntimeService) {

    companion object FlowVariables {
        const val FLOW_NAME = "return_result_flow"
        const val FLOW_RESULT = "flowResult"
    }

    fun startForResultLongRunningFlow(): String {
        val processInstance: ProcessInstanceWithVariables = runtimeService.createProcessInstanceByKey(FLOW_NAME)
            .executeWithVariablesInReturn()
        return processInstance[FLOW_RESULT]!!

        /*return if (processInstance.isEnded) {
            processInstance[FLOW_RESULT]!!
        } else {
            throw RuntimeException("Process is not ended")
        }*/
    }
}
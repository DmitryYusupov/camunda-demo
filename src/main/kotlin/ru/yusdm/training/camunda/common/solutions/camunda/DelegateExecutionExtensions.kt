package ru.yusdm.training.camunda.common.solutions.camunda

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables

inline operator fun<reified T> DelegateExecution.get(variableName: String) : T? {
    return this.getVariable(variableName)?.let {
        it as T
    }
}

operator fun DelegateExecution.set(variableName: String, variableValue: Any) {
    this.setVariable(variableName, variableValue)
}

inline operator fun<reified T> ProcessInstanceWithVariables.get(variableName: String) : T? {
    return this.variables.get(variableName)?.let {
        it as T
    }
}

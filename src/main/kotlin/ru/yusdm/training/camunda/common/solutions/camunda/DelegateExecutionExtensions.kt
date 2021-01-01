package ru.yusdm.training.camunda.common.solutions.camunda

import org.camunda.bpm.engine.delegate.DelegateExecution

inline operator fun<reified T> DelegateExecution.get(variableName: String) : T? {
    return this.getVariable(variableName)?.let {
        it as T
    }
}

operator fun DelegateExecution.set(variableName: String, variableValue: Any) {
    this.setVariable(variableName, variableValue)
}

package ru.yusdm.training.camunda.common.solutions.camunda

import org.camunda.bpm.engine.RuntimeService
import org.camunda.bpm.engine.runtime.Execution

interface Message {
    val type: MessageType
    fun findMessageExecutionContext(runtimeService: RuntimeService) : Execution?
    fun bind(runtimeService: RuntimeService, params: MutableMap<String, Any> = mutableMapOf())
}

interface MessageType {
    val id: String
}




package ru.yusdm.training.camunda.common.messageintermediatecatchingevent

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.solutions.logger

@Service
class MessageFlowFirstStep {

    private val log = MessageFlowFirstStep::class.logger

    fun execute() {
        log.info("Message flow first step")
        log.info("Waiting for event to continue")
    }
}
package ru.yusdm.training.camunda.common.messageintermediatecatchingevent;

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component;

@Component("messageFlowFirstStepCamunda")
class MessageFlowFirstStepCamunda(private val messageFlowFirstStep: MessageFlowFirstStep) : JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        messageFlowFirstStep.execute()
    }
}

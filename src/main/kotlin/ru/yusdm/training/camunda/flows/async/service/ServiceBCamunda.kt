package ru.yusdm.training.camunda.flows.async.service

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

/**
 * Play with asyncBefore property in modeler:
 * asyncBefore on serviceBCamunda or asyncAfter on serviceACamunda
 */
@Component("serviceBCamunda")
class ServiceBCamunda(private val serviceB: ServiceB): JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        serviceB.execute()
    }
}
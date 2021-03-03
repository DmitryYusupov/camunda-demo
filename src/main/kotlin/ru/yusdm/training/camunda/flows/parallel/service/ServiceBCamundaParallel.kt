package ru.yusdm.training.camunda.flows.parallel.service

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

/**
 * Play with asyncBefore property in modeler:
 * asyncBefore on serviceBCamunda or asyncAfter on serviceACamunda
 */
@Component("serviceBCamundaParallel")
class ServiceBCamundaParallel(private val serviceBParallel: ServiceBParallel): JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        serviceBParallel.execute()
    }
}
package ru.yusdm.training.camunda.common.parallel.service

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component("serviceCCamundaParallel")
class ServiceCCamundaParallel(private val serviceCParallel: ServiceCParallel): JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        serviceCParallel.execute()
    }
}
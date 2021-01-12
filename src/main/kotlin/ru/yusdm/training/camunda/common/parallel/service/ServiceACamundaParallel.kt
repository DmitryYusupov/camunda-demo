package ru.yusdm.training.camunda.common.parallel.service

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component("serviceACamundaParallel")
class ServiceACamundaParallel(private val serviceAParallel: ServiceAParallel): JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        serviceAParallel.execute()
    }
}
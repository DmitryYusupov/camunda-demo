package ru.yusdm.training.camunda.common.parallel.service

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component("serviceDCamundaParallel")
class ServiceDCamundaParallel(private val serviceDParallel: ServiceDParallel): JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        serviceDParallel.execute()
    }
}
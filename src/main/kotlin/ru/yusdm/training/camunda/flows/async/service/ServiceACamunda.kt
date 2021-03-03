package ru.yusdm.training.camunda.flows.async.service

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component("serviceACamunda")
class ServiceACamunda(private val serviceA: ServiceA): JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        serviceA.execute()
    }
}
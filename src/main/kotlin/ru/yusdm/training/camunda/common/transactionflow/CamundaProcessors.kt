package ru.yusdm.training.camunda.common.transactionflow

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.yusdm.training.camunda.common.solutions.logger

@Component("service_1_Camunda")
class Service_1_Camunda(private val userService: Service_1): JavaDelegate {

    private val log = Service_1_Camunda::class.logger

    override fun execute(execution: DelegateExecution?) {
        log.info("Service_1: Save users")
        userService.saveUsers()
    }
}

@Component("service_2_Camunda")
class Service_2_Camunda(private val userService: Service_2): JavaDelegate {

    private val log = Service_1_Camunda::class.logger

    override fun execute(execution: DelegateExecution?) {
        log.info("Service_2: Save users")
        userService.saveUsers()
    }
}

@Component("service_3_Camunda")
class Service_3_Camunda(private val userService: Service_3): JavaDelegate {

    private val log = Service_1_Camunda::class.logger

    override fun execute(execution: DelegateExecution?) {
        log.info("Service_3: Save users")
        userService.saveUsers()
    }
}
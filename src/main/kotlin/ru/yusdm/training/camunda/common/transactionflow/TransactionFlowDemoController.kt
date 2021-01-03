package ru.yusdm.training.camunda.common.transactionflow

import org.camunda.bpm.engine.RuntimeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.yusdm.training.camunda.common.solutions.logger


@RestController
@RequestMapping(value = ["/api/transaction_flow"])
class TransactionFlowDemoController(private val runtimeService: RuntimeService) {

    private val log = TransactionFlowDemoController::class.logger

    //http://localhost:8080/api/transaction_flow/demo
    @GetMapping("/demo")
    fun demoFlow() {
        log.info("Demo transaction flow")
        runtimeService.startProcessInstanceByKey("transaction_flow")
    }
}
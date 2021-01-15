package ru.yusdm.training.camunda.common.creditflow.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.yusdm.training.camunda.common.creditflow.services.CreditFlowExecutor
import ru.yusdm.training.camunda.common.solutions.logger

@RestController
@RequestMapping(value = ["/api/user"])
class UserCreditController(private val creditFlowExecutor: CreditFlowExecutor) {

    private val log = UserCreditController::class.logger
    //http://localhost:8080/api/user/credit/1
    @GetMapping("/credit/{userId}")
    fun takeCreditForUser(@PathVariable("userId") userId: Long) {
        log.info("Begin credit process for user with ID = ${userId}")
        creditFlowExecutor.calcCreditForUser(userId)
    }
}
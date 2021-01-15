package ru.yusdm.training.camunda.common.creditflow.services.verifyusercitizen

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.yusdm.training.camunda.common.creditflow.model.User
import ru.yusdm.training.camunda.common.creditflow.services.CreditFlowExecutor.FlowVariables.USER
import ru.yusdm.training.camunda.common.creditflow.services.CreditFlowExecutor.FlowVariables.USER_FROM_SPB
import ru.yusdm.training.camunda.common.solutions.camunda.get
import ru.yusdm.training.camunda.common.solutions.camunda.set
import ru.yusdm.training.camunda.common.solutions.logger

@Component("verifyUserAddressServiceCamunda")
class VerifyUserAddressServiceCamunda(private val verifyUserAddressService: VerifyUserAddressService) : JavaDelegate {

    private val log = VerifyUserAddressServiceCamunda::class.logger

    override fun execute(execution: DelegateExecution) {
        val user: User? = execution[USER]
        user?.let {
            log.info("Verify user address")
            val userFromSpb = verifyUserAddressService.verifyUserFromSpb(user)
            if (userFromSpb){
                log.info("User from Spb")
            }else{
                log.info("User not from Spb")
            }
            execution[USER_FROM_SPB] = userFromSpb
        }
    }
}
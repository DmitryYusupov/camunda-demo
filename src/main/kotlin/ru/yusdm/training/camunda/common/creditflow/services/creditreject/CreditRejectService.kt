package ru.yusdm.training.camunda.common.creditflow.services.creditreject

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.solutions.logger

data class CreditRejectContext(
    val userId: Long,
    val noUserFoundInSystem: Boolean
)

@Service
class CreditRejectService {

    private val log = CreditRejectService::class.logger

    fun rejectCredit(rejectContext: CreditRejectContext) {
        with(rejectContext){
            if (noUserFoundInSystem){
                log.info("Credit rejected to user with id = $userId, because no such user registered in system")
            }
        }
    }

}
package ru.yusdm.training.camunda.flows.creditflow.services.credithistory

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.solutions.logger


enum class IncomeVerifyStatus {
    OK, DECLINE
}

@Service
class IncomeVerifyService {

    private val log = IncomeVerifyService::class.logger

    fun checkUserCreditHistory(userId: Long): IncomeVerifyStatus {
        return if (userId == 8L || userId == 10L) {
            log.info("User income - OK")
            IncomeVerifyStatus.OK
        } else {
            log.info("User income - DECLINE")
            IncomeVerifyStatus.DECLINE
        }
    }

}
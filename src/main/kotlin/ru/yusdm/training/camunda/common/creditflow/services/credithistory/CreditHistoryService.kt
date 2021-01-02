package ru.yusdm.training.camunda.common.creditflow.services.credithistory

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.solutions.logger

enum class CreditHistory {
    OK, DECLINE
}

@Service
class CreditHistoryService {

    private val log = CreditHistoryService::class.logger

    fun checkUserCreditHistory(userId: Long): CreditHistory {
        return if (userId == 8L || userId == 10L) {
            log.info("Credit history status: OK")
            CreditHistory.OK
        } else {
            log.info("Credit history status: DECLINE")
            CreditHistory.DECLINE
        }

    }

}
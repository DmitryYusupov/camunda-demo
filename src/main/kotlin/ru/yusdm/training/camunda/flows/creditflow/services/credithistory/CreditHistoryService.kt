package ru.yusdm.training.camunda.flows.creditflow.services.credithistory

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.solutions.logger

enum class CreditHistoryStatus {
    OK, DECLINE
}

@Service
class CreditHistoryService {

    private val log = CreditHistoryService::class.logger

    fun checkUserCreditHistory(userId: Long): CreditHistoryStatus {
        log.info("Fetch credit history for user with id = $userId")
        return if (userId == 8L || userId == 10L) {
            log.info("Credit history status: OK")
            CreditHistoryStatus.OK
        } else {
            log.info("Credit history status: DECLINE")
            CreditHistoryStatus.DECLINE
        }
    }

}
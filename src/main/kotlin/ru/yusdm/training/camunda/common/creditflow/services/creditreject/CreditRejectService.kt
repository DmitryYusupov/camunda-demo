package ru.yusdm.training.camunda.common.creditflow.services.creditreject

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.creditflow.services.credithistory.CreditHistoryStatus
import ru.yusdm.training.camunda.common.creditflow.services.credithistory.IncomeVerifyStatus
import ru.yusdm.training.camunda.common.solutions.logger
import java.lang.StringBuilder

data class CreditRejectContext(
    val userId: Long,
    val noUserFoundInSystem: Boolean,
    val userFromSpb: Boolean?,
    val historyStatus: CreditHistoryStatus?,
    val incomeStatus: IncomeVerifyStatus?
)

@Service
class CreditRejectService {

    private val log = CreditRejectService::class.logger

    fun rejectCredit(rejectContext: CreditRejectContext) {
        val resolution = StringBuilder()
        with(rejectContext) {
            resolution.append("Credit rejected because:")

            if (noUserFoundInSystem) {
                resolution.append("\n- no user with id = $userId registered in system")
            }
            userFromSpb?.let {
                if (!it) {
                    resolution.append("\n- user is not from Spb")
                }
            }

            if (historyStatus != null && historyStatus != CreditHistoryStatus.OK) {
                resolution.append("\n- has bad credit history")
            }
            if (incomeStatus != null && incomeStatus != IncomeVerifyStatus.OK) {
                resolution.append("\n- insufficient income")
            }
            log.info(resolution.toString())
        }
    }

}
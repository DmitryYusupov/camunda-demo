package ru.yusdm.training.camunda.common.creditflow.services.creditapprovedecision

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.creditflow.services.credithistory.CreditHistoryStatus
import ru.yusdm.training.camunda.common.creditflow.services.credithistory.IncomeVerifyStatus

@Service
class CreditApproveDecisionService {

    fun approveCredit(creditHistoryStatus: CreditHistoryStatus, incomeVerifyStatus: IncomeVerifyStatus): Boolean{
        return creditHistoryStatus == CreditHistoryStatus.OK && incomeVerifyStatus == IncomeVerifyStatus.OK
    }

}
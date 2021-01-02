package ru.yusdm.training.camunda.common.creditflow.services.creditapprovedecision

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.creditflow.services.credithistory.CreditHistory

@Service
class CreditApproveDecisionService {

    fun approveCredit(creditHistory: CreditHistory): Boolean{
        return creditHistory == CreditHistory.OK
    }

}
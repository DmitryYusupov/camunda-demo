package ru.yusdm.training.camunda.common.creditflow.services.verifyusercitizen

import org.springframework.stereotype.Service

@Service
class VerifyUserCitizenService {

    fun verifyUserFromRussia(userId: Long) : Boolean {
        return (userId % 2) == 0L
    }

}
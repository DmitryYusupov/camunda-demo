package ru.yusdm.training.camunda.common.creditflow.services.verifyusercitizen

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.creditflow.model.User

@Service
class VerifyUserAddressService {

    fun verifyUserFromSpb(user: User) : Boolean {
        return (user.id % 2) == 0L
    }

}
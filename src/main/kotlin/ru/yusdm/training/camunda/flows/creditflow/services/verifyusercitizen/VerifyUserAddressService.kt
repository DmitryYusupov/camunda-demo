package ru.yusdm.training.camunda.flows.creditflow.services.verifyusercitizen

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.flows.creditflow.model.User

@Service
class VerifyUserAddressService {

    fun verifyUserFromSpb(user: User) : Boolean {
        return (user.id % 2) == 0L
    }

}
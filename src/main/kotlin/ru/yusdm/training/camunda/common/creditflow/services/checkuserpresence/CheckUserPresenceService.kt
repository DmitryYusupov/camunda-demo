package ru.yusdm.training.camunda.common.creditflow.services.checkuserpresence

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.creditflow.model.User

@Service
class CheckUserPresenceService {

    fun findUserById(userId: Long): User? {
        return if (userId < 50L) {
            User(userId, "Name_$userId", if (userId % 2 == 0L) "Russia" else "Not supported country")
        } else {
            null
        }
    }

}
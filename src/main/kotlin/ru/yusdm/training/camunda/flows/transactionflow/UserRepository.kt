package ru.yusdm.training.camunda.flows.transactionflow

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<UserEntity, UUID>
package ru.yusdm.training.camunda.flows.transactionflow

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "DEMO_USER")
class UserEntity(
    @Id
    @Column(name = "ID")
    var id: UUID = UUID.randomUUID(),

    @Column(name = "NAME")
    var name: String
)

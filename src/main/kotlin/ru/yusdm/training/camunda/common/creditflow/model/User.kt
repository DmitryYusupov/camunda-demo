package ru.yusdm.training.camunda.common.creditflow.model

import java.io.Serializable

class User(private val id: Long, val name: String, val citizen: String) : Serializable

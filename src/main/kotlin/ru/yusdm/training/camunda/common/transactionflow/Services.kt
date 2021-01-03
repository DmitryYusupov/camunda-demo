package ru.yusdm.training.camunda.common.transactionflow

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.concurrent.atomic.AtomicInteger

val counter = AtomicInteger(0)

@Service
@Transactional
class Service_1(private val userRepository: UserRepository) {
    fun saveUsers() {
        userRepository.save(UserEntity(name = "Name_${counter.incrementAndGet()}"))
        userRepository.save(UserEntity(name = "Name_${counter.incrementAndGet()}"))
    }
}

@Service
@Transactional
class Service_2(private val userRepository: UserRepository) {
    fun saveUsers() {
        userRepository.save(UserEntity(name = "Name_${counter.incrementAndGet()}"))
        userRepository.save(UserEntity(name = "Name_${counter.incrementAndGet()}"))
    }
}

@Service
@Transactional
class Service_3(private val userRepository: UserRepository) {
    fun saveUsers() {
        if (true) {
            throw RuntimeException("Unknown error")
        }
    }
}
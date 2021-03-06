package ru.yusdm.training.camunda.flows.transactionflow

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.concurrent.atomic.AtomicInteger
import javax.persistence.EntityManager

val counter = AtomicInteger(0)

@Service
@Transactional
class Service_1(private val userRepository: UserRepository, private val em: EntityManager) {
    fun saveUsers() {
        userRepository.save(UserEntity(name = "Name_${counter.incrementAndGet()}"))
        userRepository.save(UserEntity(name = "Name_${counter.incrementAndGet()}"))
        em.flush()
    }
}

@Service
@Transactional
class Service_2(private val userRepository: UserRepository, private val em: EntityManager) {
    fun saveUsers() {
        userRepository.save(UserEntity(name = "Name_${counter.incrementAndGet()}"))
        userRepository.save(UserEntity(name = "Name_${counter.incrementAndGet()}"))
        em.flush()
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
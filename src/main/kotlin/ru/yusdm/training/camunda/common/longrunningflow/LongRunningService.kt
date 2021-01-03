package ru.yusdm.training.camunda.common.longrunningflow

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.solutions.logger
import java.util.concurrent.atomic.AtomicInteger

val counter = AtomicInteger(0)

@Service
class LongRunningService {

    private val log = LongRunningService::class.logger

    fun execute(): String {
        log.info("Long running blocking task begin")
        Thread.sleep(10000)
        log.info("Long running blocking task end")
        return "Long running result ${counter.incrementAndGet()}"
    }
}
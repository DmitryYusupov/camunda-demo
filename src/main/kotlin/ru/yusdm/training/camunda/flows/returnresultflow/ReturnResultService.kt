package ru.yusdm.training.camunda.flows.returnresultflow

import org.springframework.stereotype.Service
import ru.yusdm.training.camunda.common.solutions.logger
import java.util.concurrent.atomic.AtomicInteger

val counter = AtomicInteger(0)

@Service
class LongRunningService {

    private val log = LongRunningService::class.logger

    fun execute(): String {
        log.info("Long running blocking task begin")
        Thread.sleep(5000)
        log.info("Long running blocking task end")
        return "Long running result ${counter.incrementAndGet()}"
    }
}
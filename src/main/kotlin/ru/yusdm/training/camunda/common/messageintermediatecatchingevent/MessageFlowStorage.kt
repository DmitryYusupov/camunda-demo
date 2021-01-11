package ru.yusdm.training.camunda.common.messageintermediatecatchingevent


data class MessageFlowData(val eventId: Int, val userId: Int)

object MessageFlowStorage {

    private val storage: MutableList<MessageFlowData> = mutableListOf()

    fun save(messageFlowData: MessageFlowData) {
        storage.add(messageFlowData)
    }

    fun findByUserId(userId: Int): MessageFlowData? {
        return storage.asSequence().filter { it.userId == userId }.firstOrNull()
    }

    fun findByEventId(eventId: Int): MessageFlowData? {
        return storage.asSequence().filter { it.eventId == eventId }.firstOrNull()
    }

}
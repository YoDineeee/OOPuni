package Laboo0

data class Universe(
    val name: String,
    val individuals: MutableList<Creature> = mutableListOf()
)

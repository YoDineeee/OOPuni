package labo1.Task3

import labo1.Task1.Display

fun main() {
    // Create a list of monitors
    val monitors = mutableListOf(
        Display(1600, 900, 100.5f, "ASUS"),
        Display(1920, 1200, 106.99f, "Samsung"),
        Display(2560, 1080, 98.0f, "Dell")
    )
    // Meet Chaarlie, an assistant - instance of the class Assistant
    val assistant = Assistant("Charlie", monitors)
    // Create a new Display instance to pass as parameter to assignDisplay()
    val newDisplay = Display(2560, 1080, 100.5f, "Xiaomi")
    assistant.assignDisplay(newDisplay)
    // Call assist method to see the comparison between monitors
    assistant.assist()
    // Instantiate a buyer
    val buyer = Buyer(assistant)
    // Make a choice as a buyer
    val choice = buyer.pickMonitor()
    // Buy the display
    val boughtDisplay = assistant.buyDisplay(assistant.getAssignedDisplays()[choice - 1])
    println("Congratulations! You bought the following display: ${boughtDisplay.getName()}")
}
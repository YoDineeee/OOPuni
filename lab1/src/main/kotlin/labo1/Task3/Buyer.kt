package labo1.Task3


class Buyer(
    // Assign an assistant to the buyer
    private val assignedAssistant: Assistant
) {
    // Method to display the options for buying
    private fun displayOptions() {
        println("Choose a monitor:")
        for (monitor in assignedAssistant.getAssignedDisplays()) {
            println(
                (assignedAssistant.getAssignedDisplays().indexOf(monitor) + 1).toString() + ": " + monitor.getName()
            )
        }
    }

    // Method to pick a monitor to buy
    public fun pickMonitor(): Int {
        displayOptions()
        val displays = assignedAssistant.getAssignedDisplays()
        val nrOfAvailableMonitors = displays.count()
        if (nrOfAvailableMonitors > 0) {
            var chosenIndex = 0
            do {
                println("Please introduce a number between 1 and ${nrOfAvailableMonitors}")
                chosenIndex = readln().toInt()
            } while (chosenIndex !in 1..nrOfAvailableMonitors)
            return chosenIndex
        } else {
            error("Sorry! We don't have any available monitors :(")
        }

    }
}
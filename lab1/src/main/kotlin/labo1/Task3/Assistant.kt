package labo1.Task3

import labo1.Task1.Display

class Assistant(
    //- assistantName
    private val assistantName: String,
    //- List<Display> assignedDisplays
    private var assignedDisplays: MutableList<Display>
) {
    //+ void assignDisplay(Display d)
    public fun assignDisplay(d: Display) {
        assignedDisplays.add(d)
    }

    //+ void assist()
    public fun assist() {
        val comparer = MonitorComparer()
        comparer.compareMonitors(assignedDisplays)
    }

    //+ Display buyDisplay(Display d)
    public fun buyDisplay(d: Display): Display {
        //Return the reference to the monitor if it is found
        if (assignedDisplays.remove(d)) {
            return d
        } else {
            //Return an error if there is no such monitor in the list
            error("The monitor is not in the store.")
        }
    }

    //Getter function for assignedDisplays to use in Main.kt
    public fun getAssignedDisplays(): MutableList<Display> {
        return assignedDisplays
    }
}
import scala.collection.mutable.ListBuffer

class Assistant(var assistantName: String) {
  private val assignedDisplays: ListBuffer[Display] = ListBuffer()

  def assignDisplay(d: Display): Unit= {
    assignedDisplays += d
  }

  def assist(): Unit = {
    if (assignedDisplays.isEmpty) {
      println("No displays")
    } else {
      val len = assignedDisplays.length - 1
      for (i <- 0 until len) {
        val currentDisplay = assignedDisplays(i)
        val nextDisplay = assignedDisplays(i + 1)

        println(s"Comparing display ${i + 1} with display ${i + 2}: ")
        currentDisplay.compareSize(nextDisplay)
        currentDisplay.compareSharpness(nextDisplay)
        println()
      }
    }
  }

  def buyDisplay(d: Display): Option[Display] = {
    val index = assignedDisplays.indexOf(d)
    if (index >= 0) {
      assignedDisplays.remove(index)
      println(s"${d.getModel} has been bought and removed from the list.")
      Some(d)
    } else {
      println(s"${d.getModel} is not in the assigned displays.")
      None
    }
  }


  def getAssignedDisplays: List[Display] = assignedDisplays.toList
}
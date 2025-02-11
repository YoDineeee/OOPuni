object main {
  def main(args: Array[String]): Unit = {
    val display1 = new Display(1920, 1080, 300f, "Monitor A")
    val display2 = new Display(2560, 1440, 350f, "Monitor B")
    val display3 = new Display(1280, 720, 200f, "Monitor C")

    display1.compareWithMonitor(display2)
    println()
    display2.compareWithMonitor(display3)
    println()
    display1.compareWithMonitor(display3)
  }
}
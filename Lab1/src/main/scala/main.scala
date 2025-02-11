object main {
  def main(args: Array[String]): Unit = {
    val Display1 = new Display(1920, 1080, 401, "Model A")
    val Display2 = new Display(2560, 1440, 529, "Model B")
    val Display3 = new Display(3840, 2160, 163, "Model C")

    val assistant = new Assistant("Alex")

    assistant.assignDisplay(Display1)
    assistant.assignDisplay(Display2)
    assistant.assignDisplay(Display3)

    assistant.assist()

    assistant.buyDisplay(Display2)
  }
}
class Display(private var width: Int,
              private var height: Int,
              private var ppi: Float,
              private var model: String) {

  // Calculate the area of the display
  private def area(): Int = {
    width * height
  }

  // Compare size with another Display
  def compareSize(other: Display): Unit = {
    val currentArea = area()
    val otherArea = other.area()

    if (currentArea > otherArea) {
      println(s"$model is bigger than ${other.model}")
    } else if (currentArea < otherArea) {
      println(s"$model is smaller than ${other.model}")
    } else {
      println(s"$model and ${other.model} have the same size.")
    }
  }

  // Compare sharpness with another Display
  def compareSharpness(other: Display): Unit = {
    if (ppi > other.ppi) {
      println(s"$model is sharper than ${other.model}")
    } else if (ppi < other.ppi) {
      println(s"$model is less sharp than ${other.model}")
    } else {
      println(s"$model and ${other.model} have the same sharpness.")
    }
  }

  // Compare both size and sharpness with another Display
  def compareWithMonitor(other: Display): Unit = {
    println(s"Comparison of $model with ${other.model}:")
    compareSize(other)
    compareSharpness(other)
  }

  // Getters and Setters
  def getWidth: Int = width
  def setWidth(newWidth: Int): Unit = {
    width = newWidth
  }

  def getHeight: Int = height
  def setHeight(newHeight: Int): Unit = {
    height = newHeight
  }

  def getPpi: Float = ppi
  def setPpi(newPpi: Float): Unit = {
    ppi = newPpi
  }

  def getModel: String = model
  def setModel(newModel: String): Unit = {
    model = newModel
  }
}
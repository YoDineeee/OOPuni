package Coffee

class Americano(intensity: Intensity, protected val mlOfWater: Int)
  extends Coffee(intensity):

  private val coffeeName: String = "Americano"

  def getMlOfWater: Int = mlOfWater

  override def printCoffeeDetails(): Unit =
    println(s"$coffeeName water: $mlOfWater ml")

  def makeAmericano(): Unit =
    println("Making Americano")
    println(s"Intensity set to $coffeeIntensity")
    println(s"Adding $mlOfWater ml of water")
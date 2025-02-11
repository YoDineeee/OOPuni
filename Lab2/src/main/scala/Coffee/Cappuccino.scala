package Coffee

class Cappuccino(intensity: Intensity, mlOfWater: Int, val mlOfMilk: Int)
  extends Americano(intensity, mlOfWater):

  private val coffeeName: String = "Cappuccino"

  def getCoffee: String = coffeeName

  override def printCoffeeDetails(): Unit =
    println(s"$coffeeName water: ${getMlOfWater} ml, milk: $mlOfMilk ml")

  // Base method
  def makeRecipe(): Unit =
    println(s"Intensity set to $coffeeIntensity")
    println(s"Adding $mlOfMilk ml of milk")

  // Specialized method
  def makeCappuccino(): Cappuccino =
    println(s"Making $coffeeName")
    this.makeRecipe()
    this
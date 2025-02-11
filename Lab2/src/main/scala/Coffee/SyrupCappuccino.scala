package Coffee

class SyrupCappuccino(intensity: Intensity, mlOfWater: Int, mlOfMilk: Int, val syrup: SyrupType)
  extends Cappuccino(intensity, mlOfWater, mlOfMilk):

  private val coffeeName: String = "Syrup Cappuccino"

  def getSyrup: SyrupType = syrup

  override def printCoffeeDetails(): Unit =
    println(s"$coffeeName water: ${getMlOfWater} ml, milk: ${mlOfMilk} ml, syrup: $syrup")

  override def makeRecipe(): Unit =
    super.makeRecipe()
    println(s"Adding $syrup syrup")

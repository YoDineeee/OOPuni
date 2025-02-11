package Coffee

class PumkinSpiceLatte(intensity: Intensity, mlOfWater: Int, mlOfMilk: Int, syrup: SyrupType, val mgOfPumpkinSpice: Int)
  extends SyrupCappuccino(intensity, mlOfWater, mlOfMilk, syrup):

  private val coffeeName: String = "Pumpkin Spice Latte"

  def getName: String = coffeeName

  override def printCoffeeDetails(): Unit =
    println(s"$coffeeName water: ${getMlOfWater} ml, milk: ${mlOfMilk} ml, syrup: ${getSyrup}, pumpkin spice: $mgOfPumpkinSpice mg")

  override def makeRecipe(): Unit =
    super.makeRecipe()
    println(s"Adding $mgOfPumpkinSpice mg of pumpkin spice")

  def makePumpkinSpiceLatte(): PumkinSpiceLatte =
    println(s"Making $coffeeName")
    this.makeRecipe()
    this

// Enum for Intensity
enum Intensity:
  case NORMAL, STRONG, EXTRA_STRONG

// Enum for SyrupType
enum SyrupType:
  case CHOCOLATE, VANILLA, CARAMEL

// Base class Americano
class Americano(val coffeeName: String, val coffeeIntensity: Intensity, val mlOfWater: Int) {
  def printCoffeeDetails(): Unit = {
    println(s"$coffeeName water: $mlOfWater ml")
  }

  def makeAmericano(): Americano = {
    println(s"Making $coffeeName")
    println(s"Intensity set to $coffeeIntensity")
    println(s"Adding $mlOfWater mls of water")
    this
  }
}

// Cappuccino class extending Americano
class Cappuccino(
                  coffeeName: String,
                  coffeeIntensity: Intensity,
                  mlOfWater: Int,
                  val mlOfMilk: Int
                ) extends Americano(coffeeName, coffeeIntensity, mlOfWater) {
  override def printCoffeeDetails(): Unit = {
    println(s"$coffeeName water: $mlOfWater ml, milk: $mlOfMilk mg")
  }

  def makeCappuccino(): Cappuccino = {
    println(s"Making $coffeeName")
    println(s"Intensity set to $coffeeIntensity")
    println(s"Adding $mlOfMilk mls of milk")
    this
  }
}

// SyrupCappuccino class extending Cappuccino
class SyrupCappuccino(
                       coffeeName: String,
                       coffeeIntensity: Intensity,
                       mlOfWater: Int,
                       mlOfMilk: Int,
                       val syrup: SyrupType
                     ) extends Cappuccino(coffeeName, coffeeIntensity, mlOfWater, mlOfMilk) {
  override def printCoffeeDetails(): Unit = {
    println(s"$coffeeName water: $mlOfWater ml, milk: $mlOfMilk mg, syrup: $syrup")
  }

  def makeSyrupCappuccino(): SyrupCappuccino = {
    println(s"Making $coffeeName")
    println(s"Intensity set to $coffeeIntensity")
    println(s"Adding $mlOfMilk mls of milk")
    println(s"Adding syrup: $syrup")
    this
  }
}

// PumpkinSpiceLatte class extending SyrupCappuccino
class PumpkinSpiceLatte(
                         coffeeName: String,
                         coffeeIntensity: Intensity,
                         mlOfWater: Int,
                         mlOfMilk: Int,
                         syrup: SyrupType,
                         val mgOfPumpkinSpice: Int
                       ) extends SyrupCappuccino(coffeeName, coffeeIntensity, mlOfWater, mlOfMilk, syrup) {
  override def printCoffeeDetails(): Unit = {
    println(s"$coffeeName water: $mlOfWater ml, milk: $mlOfMilk mg, syrup: $syrup, pumpkin spice: $mgOfPumpkinSpice mg")
  }

  def makePumpkinSpiceLatte(): PumpkinSpiceLatte = {
    println(s"Making $coffeeName")
    println(s"Intensity set to $coffeeIntensity")
    println(s"Adding $mlOfMilk mls of milk")
    println(s"Adding $mgOfPumpkinSpice mls of pumpkin spice")
    this
  }
}

// Main object to test the classes
object Main extends App {
  val coffee = new PumpkinSpiceLatte(
    "PumpkinSpiceLatte",
    Intensity.NORMAL,
    50,
    20,
    SyrupType.CHOCOLATE,
    3
  )
  coffee.printCoffeeDetails()
  coffee.makePumpkinSpiceLatte()
}

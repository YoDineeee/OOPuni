sealed trait Intensity
case object Light extends Intensity
case object Normal extends Intensity
case object Strong extends Intensity

sealed trait SyrupType
case object Vanilla extends SyrupType
case object Caramel extends SyrupType
case object Chocolate extends SyrupType

open class Coffee(protected val coffeeIntensity: Intensity) {
  protected val name: String = "Coffee"
  protected val coffeeName: String = "Coffee"

  def getCoffeeIntensity: Intensity = coffeeIntensity

  def getName: String = coffeeName

  def printCoffeeDetails(): Unit = {
    println(s"$coffeeName intensity: $coffeeIntensity")
  }
}

class Americano(coffeeIntensity: Intensity, private val mlOfWater: Int) extends Coffee(coffeeIntensity) {
  override val coffeeName: String = "Americano"

  def getMlOfWater: Int = mlOfWater

  override def printCoffeeDetails(): Unit = {
    println(s"$coffeeName water: $mlOfWater ml")
  }
}

class Cappuccino(intensity: Intensity, mlOfWater: Int, private val mlOfMilk: Int) extends Americano(intensity, mlOfWater) {
  override val coffeeName: String = "Cappuccino"

  def getMlOfMilk: Int = mlOfMilk

  override def printCoffeeDetails(): Unit = {
    println(s"$coffeeName water: $getMlOfWater ml, milk: $mlOfMilk mg")
  }
}

class SyrupCappuccino(intensity: Intensity, mlOfWater: Int, mlOfMilk: Int, private val syrup: SyrupType)
  extends Cappuccino(intensity, mlOfWater, mlOfMilk) {

  override val coffeeName: String = "SyrupCappuccino"

  def getSyrup: SyrupType = syrup

  override def printCoffeeDetails(): Unit = {
    println(s"$coffeeName water: $getMlOfWater ml, milk: $getMlOfMilk mg, syrup: $syrup")
  }
}

class PumpkinSpiceLatte(intensity: Intensity, mlOfWater: Int, mlOfMilk: Int, syrup: SyrupType, private val mgOfPumpkinSpice: Int)
  extends SyrupCappuccino(intensity, mlOfWater, mlOfMilk, syrup) {

  override val coffeeName: String = "PumpkinSpiceLatte"

  def getMgOfPumpkinSpice: Int = mgOfPumpkinSpice

  override def printCoffeeDetails(): Unit = {
    println(s"$coffeeName water: $getMlOfWater ml, milk: $getMlOfMilk mg, syrup: $getSyrup, pumpkin spice: $mgOfPumpkinSpice mg")
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val coffee = new PumpkinSpiceLatte(Normal, 50, 20, Chocolate, 3)
    coffee.printCoffeeDetails()
  }
}

enum Intensity:
  case LIGHT, NORMAL, STRONG

enum SyrupType:
  case MACADAMIA, VANILLA, COCONUT, CARAMEL, CHOCOLATE, POPCORN

class Coffee(protected val coffeeIntensity: Intensity):
  protected val name: String = "Coffee"
  def getCoffeeIntensity: Intensity = coffeeIntensity
  def getName: String = name

class Americano(intensity: Intensity, private val mlOfWater: Int) extends Coffee(intensity):
  private val coffeeName: String = "Americano"
  def getMlOfWater: Int = mlOfWater
  def getCoffeeName: String = coffeeName

class Cappuccino(intensity: Intensity, mlOfWater: Int, private val mlOfMilk: Int) extends Americano(intensity, mlOfWater):
  private val coffee: String = "Cappuccino"
  def getMlOfMilk: Int = mlOfMilk
  def getCoffee: String = coffee

class SyrupCappuccino(intensity: Intensity, mlOfWater: Int, mlOfMilk: Int, private val syrup: SyrupType)
  extends Cappuccino(intensity, mlOfWater, mlOfMilk):
  private val coffee: String = "SyrupCappuccino"
  override def getCoffee: String = coffee
  def getSyrup: SyrupType = syrup

class PumpkinSpiceLatte(
                         intensity: Intensity,
                         mlOfWater: Int,
                         mlOfMilk: Int,
                         syrup: SyrupType,
                         private val mgOfPumpkinSpice: Int
                       ) extends SyrupCappuccino(intensity, mlOfWater, mlOfMilk, syrup):
  private val name: String = "PumpkinSpiceLatte"
  override def getName: String = name
  def getMgOfPumpkinSpice: Int = mgOfPumpkinSpice
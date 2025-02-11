package carsystem

object ElectricStation {
  private var rechargeCount = 0
  def getCount: Int = rechargeCount
}

class ElectricStation extends Refuelable {
  override def refuel(carId: String): Unit = {
    ElectricStation.rechargeCount += 1
    println(s"Recharging electric car $carId.")
  }
}
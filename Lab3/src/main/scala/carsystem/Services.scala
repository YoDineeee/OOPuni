package carsystem

// Abstractions
trait Dineable {
  def dine(carId: String): Unit
}

trait Refuelable {
  def refuel(carId: String): Unit
}

// Concrete Implementations
class BasicDiningService extends Dineable {
  override def dine(carId: String): Unit =
    println(s"Serving dinner to car $carId.")
}

class GasRefuelService extends Refuelable {
  override def refuel(carId: String): Unit =
    println(s"Refueling gas car $carId.")
}

class ElectricRefuelService extends Refuelable {
  override def refuel(carId: String): Unit =
    println(s"Charging electric car $carId.")
}
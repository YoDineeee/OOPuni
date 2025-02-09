// Basic dining service (implements Dineable)
class BasicDiningService extends Dineable {
  override def dine(carId: String): Unit =
    println(s"Serving dinner to car $carId.")
}

// Refueling service for gas cars (implements Refuelable)
class GasRefuelService extends Refuelable {
  override def refuel(carId: String): Unit =
    println(s"Refueling gas car $carId.")
}

// Refueling service for electric cars (implements Refuelable)
class ElectricRefuelService extends Refuelable {
  override def refuel(carId: String): Unit =
    println(s"Charging electric car $carId.")
}
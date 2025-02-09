class Gazstation extends Refuelable{
  override def refuel(carId: String): Unit = {
    println(s"Refueling gas car $carId.")
  }
}

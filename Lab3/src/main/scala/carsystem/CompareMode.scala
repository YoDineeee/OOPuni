package carsystem



class CompareMode(priorityFuel: String, priorityDining: String) extends Ordering[Car] {
  private def isPriority(car: Car): Boolean =
    car.carType == priorityFuel && car.passengers == priorityDining

  override def compare(a: Car, b: Car): Int = {
    (isPriority(a), isPriority(b)) match {
      case (true, false) => -1  // a has priority
      case (false, true) => 1   // b has priority
      case _             => 0   // same priority
    }
  }
}
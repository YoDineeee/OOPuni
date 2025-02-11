package carsystem

import java.util.concurrent.atomic.AtomicInteger

object GasStation {
  private val refuelCount = new AtomicInteger(0)
  def getCount: Int = refuelCount.get()
}

class GasStation extends Refuelable {
  override def refuel(carId: String): Unit = {
    val count = GasStation.refuelCount.incrementAndGet()
    println(s"Refueling gas car $carId. (Total: $count)")
  }
}
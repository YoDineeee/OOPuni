package carsystem

import java.util.concurrent.atomic.AtomicInteger

object peopledinner {
  private val peopleServed = new AtomicInteger(0)
  def getCount: Int = peopleServed.get()
}

class peopledinner extends Dineable {
  override def serveDinner(carId: String): Unit = {
    val count = peopledinner.peopleServed.incrementAndGet()
    println(s"Serving dinner to people in car $carId. (Total: $count)")
  }
}

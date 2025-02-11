package carsystem

import java.util.concurrent.atomic.AtomicInteger

object RobotsDinner {
  private val robotsServed = new AtomicInteger(0)
  def getCount: Int = robotsServed.get()
}

class RobotsDinner extends Dineable {
  override def serveDinner(carId: String): Unit = {
    val count = RobotsDinner.robotsServed.incrementAndGet()
    println(s"Serving dinner to robots in car $carId. (Total: $count)")
  }
}
package carsystem
import scala.collection.mutable

class CarStation(
                  private val queue: mutable.Queue[Car],
                  private val refuelingService: Refuelable,
                  private val dinningService: Dineable
                ) {
  
  
  
  def serveCars(): Unit = {
    while (queue.nonEmpty) {
      val car = queue.head
      if (car.isDining) {
        dinningService.serveDinner(car.id.toString)
        CarStation.incrementDining()
      } else {
        println(s"Car ${car.id} Didn't get served")
        CarStation.incrementNotDining()
      }
      refuelingService.refuel(car.id.toString)
      queue.dequeue()
    }
  }

  def addCar(car: Car): Unit = queue.enqueue(car)
}

object CarStation {
  private var diningCount = 0
  private var notDiningCount = 0

  // Maintain Java-style static getters to match original API
  def getDining: Int = diningCount
  def getNot_dining: Int = notDiningCount

  private def incrementDining(): Unit = diningCount += 1
  private def incrementNotDining(): Unit = notDiningCount += 1
}


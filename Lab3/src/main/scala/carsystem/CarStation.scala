package carsystem

import scala.collection.mutable.Queue

class CarStation(
                  private val diningService: Dineable,
                  private val refuelingService: Refuelable
                ) {
  private val queue: Queue[Car] = Queue.empty[Car]
  private var _gasCarsServed: Int = 0
  private var _electricCarsServed: Int = 0

  def addCar(car: Car): Unit = queue.enqueue(car)

  def serveCars(): Unit = {
    while (queue.nonEmpty) {
      val car = queue.dequeue()
      if (car.isDining) diningService.dine(car.id)
      refuelingService.refuel(car.id)
      if (car.carType == "GAS") _gasCarsServed += 1
      else if (car.carType == "ELECTRIC") _electricCarsServed += 1
    }
  }

  def gasCarsServed: Int = _gasCarsServed
  def electricCarsServed: Int = _electricCarsServed
}
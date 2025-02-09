package carsystem

class Semaphore(private val stations: Map[String, CarStation]) {
  def receiveCar(car: Car): Unit = {
    stations.get(car.carType).foreach(_.addCar(car))
  }

  def processAll(): Unit = {
    stations.values.foreach(_.serveCars())
  }
}
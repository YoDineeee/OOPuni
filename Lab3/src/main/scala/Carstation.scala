import scala.collection.mutable.Queue

class Carstation(
                  diningService: Dineable,
                  refuelingServices: Map[String, Refuelable] // Maps carType (e.g., "GAS") to service
                ) {
  private val queue: Queue[Car] = Queue.empty[Car]

  // Add a car to the queue
  def addCar(car: Car): Unit = {
    queue.enqueue(car)
  }

  // Process all cars in the queue
  def serveCars(): Unit = {
    while (queue.nonEmpty) {
      val car = queue.dequeue()
      if (car.isDining) diningService.dine(car.id)

      // Get the correct refueling service based on carType
      refuelingServices.get(car.carType) match {
        case Some(service) => service.refuel(car.id)
        case None => println(s"No refueling service for ${car.carType} car ${car.id}.")
      }
    }
  }
}
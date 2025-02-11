package carsystem

import java.io.File
import java.nio.file.Files
import com.fasterxml.jackson.databind.ObjectMapper


class Semaphore {
  var files: Array[File] = _
  private val mapper = new ObjectMapper()

  
  private val (station1, station2, station3, station4) = {
    val queue1 = new LinearQueue[Car](30)
    val queue2 = new LinearQueue[Car](30)
    val queue3 = new LinearQueue[Car](30)
    val queue4 = new LinearQueue[Car](30)

    (
      new CarStation(queue1, new GasStation, new peopledinner),
      new CarStation(queue2, new GasStation, new RobotsDinner),
      new CarStation(queue3, new ElectricStation, new peopledinner),
      new CarStation(queue4, new ElectricStation, new RobotsDinner)
    )
  }

  private var electricConsumption = 0
  private var gasConsumption = 0
  private var peoplePassengers = 0
  private var robotsPassengers = 0

  def handleCars(): Unit = {
    files.foreach { file =>
      try {
        val content = Files.readString(file.toPath)
        val car = mapper.readValue(content, classOf[Car])

        
        (car.carType, car.passengers) match {
          case ("GAS", "PEOPLE") =>
            station1.addCar(car)
            println(s"Added car ${car.id} to station 1")
          case ("GAS", "ROBOTS") =>
            station2.addCar(car)
            println(s"Added car ${car.id} to station 2")
          case ("ELECTRIC", "PEOPLE") =>
            station3.addCar(car)
            println(s"Added car ${car.id} to station 3")
          case ("ELECTRIC", "ROBOTS") =>
            station4.addCar(car)
            println(s"Added car ${car.id} to station 4")
          case _ => 
        }

        
        car.carType match {
          case "ELECTRIC" => electricConsumption += car.consumption
          case "GAS" => gasConsumption += car.consumption
          case _ => 
        }

        
        car.passengers match {
          case "PEOPLE" => peoplePassengers += 1
          case "ROBOTS" => robotsPassengers += 1
          case _ => 
        }
      } catch {
        case e: Exception => throw new RuntimeException(s"Failed to process file ${file.getName}", e)
      }
    }

    
    List(station1, station2, station3, station4).foreach(_.serveCars())
  }

  def readFiles(folderPath: String): Unit = {
    val folder = new File(folderPath)
    files = folder.listFiles((_, name) => name.endsWith(".json"))

    if (files == null || files.isEmpty) {
      throw new RuntimeException(s"No JSON files found in folder: $folderPath")
    }
  }

  
  def getElectricConsumption: Int = electricConsumption
  def getGasConsumption: Int = gasConsumption
  def getPeoplePassengers: Int = peoplePassengers
  def getRobotsPassengers: Int = robotsPassengers
}
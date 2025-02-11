package carsystem

import java.io.File
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.{ConcurrentHashMap, Executors, ScheduledExecutorService, TimeUnit}


class Schedular(semaphore: Semaphore, generatorPath: String, folderPath: String) {
  private val scheduler: ScheduledExecutorService = Executors.newScheduledThreadPool(2)
  private val processingExecutor = Executors.newCachedThreadPool()
  private val processedFiles = ConcurrentHashMap.newKeySet[String]()
  private val generatorFinished = new AtomicBoolean(false)

  def start(): Unit = {
    scheduleGeneratorTask()
    scheduleReaderTask()
    addShutdownHook()
  }

  private def scheduleGeneratorTask(): Unit = {
    val generateTask = new Runnable {
      override def run(): Unit = try {
        println("\n[Generator] Running Python generator...")
        val processBuilder = new ProcessBuilder("python3", generatorPath)
        processBuilder.inheritIO()
        val process = processBuilder.start()
        process.waitFor()
        generatorFinished.set(true)
        println("[Generator] Finished generating files.")
      } catch {
        case e: Exception =>
          System.err.println(s"[Error] Failed to run Python generator: ${e.getMessage}")
          generatorFinished.set(true)
      }
    }

    scheduler.schedule(generateTask, 0, TimeUnit.SECONDS)
  }

  private def scheduleReaderTask(): Unit = {
    val readTask = new Runnable {
      override def run(): Unit = {
        val folder = new File(folderPath)
        val files = folder.listFiles((_, name) => name.endsWith(".json"))

        // Shutdown check
        if (generatorFinished.get) {
          if (files == null || files.isEmpty || files.forall(f => processedFiles.contains(f.getName))) {
            println("[Reader] No new files to process. Stopping scheduler.")
            scheduler.shutdown()
            processingExecutor.shutdown()
          }
        }

        if (files == null) return

        files.foreach { file =>
          if (!processedFiles.contains(file.getName) && isFileReady(file)) {
            if (processedFiles.add(file.getName)) {
              processingExecutor.submit(new Runnable {
                override def run(): Unit = {
                  try {
                    semaphore.readFiles("src/main/queue")
                  } catch {
                    case e: Exception =>
                      System.err.println(s"[Error] Processing ${file.getName}: ${e.getMessage}")
                      processedFiles.remove(file.getName) // Allow reprocessing on failure
                  }
                }
              })
            }
          }
        }
      }
    }

    scheduler.scheduleAtFixedRate(readTask, 1, 1, TimeUnit.SECONDS)
  }

  private def isFileReady(file: File): Boolean =
    file.length() > 0 && file.lastModified() < System.currentTimeMillis() - 500

  private def addShutdownHook(): Unit =
    Runtime.getRuntime.addShutdownHook(new Thread(() => {
      scheduler.shutdownNow()
      processingExecutor.shutdownNow()
      if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) println("Scheduler shutdown timed out.")
      if (!processingExecutor.awaitTermination(5, TimeUnit.SECONDS)) println("Processing shutdown timed out.")
      displayFinalStatistics()
    }))

  private def displayFinalStatistics(): Unit = {
    println("\n=== Final Statistics ===")
    println(s"Total cars recharged with electricity: ${ElectricStation.getCount}")
    println(s"Total cars refueled with gas: ${GasStation.getCount}")
    println(s"Total passengers types: People - ${semaphore.getPeoplePassengers}, Robots - ${semaphore.getRobotsPassengers}")
    println(s"Total passengers dine preference: Dining - ${CarStation.getDining}, Not Dining - ${CarStation.getNot_dining}")
    println(s"Total consumption: Electric - ${semaphore.getElectricConsumption}, Gas - ${semaphore.getGasConsumption}")
  }
}
package carsystem

object start extends App {
  val semaphore = new Semaphore()
  val generatorPath = "src/main/generator.py"
  private val readFolderPath = "src/main/queue"
  val scheduler = new Schedular(semaphore, generatorPath, readFolderPath)
  scheduler.start()

}

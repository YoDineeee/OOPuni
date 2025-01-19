
import scala.io.Source
import io.circe._
import io.circe.generic.auto._
import io.circe.parser._
import java.nio.file.{Files, Paths}
import scala.util.Using


object QueueTest extends App {
 private val path = Paths.get("src/main/queue")

  if (Files.exists(path) && Files.isDirectory(path)) {
    val files = Files.list(path).toArray().map(_.toString)

    // Parse and process the JSON files as usual
    val cars: Seq[car] = files.flatMap { file =>
      val jsonStr = Using(Source.fromFile(file)) { source =>
        source.getLines().mkString("\n")
      }.getOrElse {
        println(s"Failed to read file: $file")
        ""
      }

      decode[car](jsonStr) match {
        case Right(vehicle) => Some(vehicle)
        case Left(error) =>
          println(s"Error parsing file $file: $error")
          None
      }
    }.toSeq

    // Continue with your queue operations...
  } else {
    println("Error: The 'queue' directory does not exist or is not accessible.")
  }


  private val files = Files.list(path).toArray().map(_.toString)

  // Parse the JSON files into car objects
  private val cars: Seq[car] = files.flatMap { file =>
    val jsonStr = {
      val source = Source.fromFile(file)
      try {
        source.getLines().mkString("\n")
      } finally {
        source.close() // Ensures the resource is closed
      }
    }
    decode[car](jsonStr) match {
      case Right(vehicle) => Some(vehicle)
      case Left(error) =>
        println(s"Error parsing file $file: $error")
        None
    }
  }.toSeq

  // Test SimpleQueue
  private val Simple_Queue= new Simple_Queue[car]
  cars.foreach(Simple_Queue.enqueue)

  println("Testing SimpleQueue:")
  println(s"SimpleQueue size: ${Simple_Queue.size()}")
  println(s"SimpleQueue peek: ${Simple_Queue.peek()}")
  println(s"SimpleQueue dequeue: ${Simple_Queue.dequeue()}")
  println(s"SimpleQueue size after dequeue: ${Simple_Queue.size()}")
  println()

  // Test DeQueue
  private val DeQueue = new DeQueue[car]
  cars.foreach(DeQueue.enqueue)

  println("Testing DeQueue:")
  println(s"DeQueue size: ${DeQueue.size()}")
  println(s"DeQueue peek: ${DeQueue.peek()}")
  println(s"DeQueue dequeue: ${DeQueue.dequeue()}")
  println(s"DeQueue size after dequeue: ${DeQueue.size()}")
  println()

  // Test HeapQueue (min-heap or max-heap depending on ordering)
  private val Heap_queue = new Heap_queue[car]()

  println("Testing HeapQueue:")
  println(s"HeapQueue size: ${Heap_queue.size()}")
  println(s"HeapQueue peek: ${Heap_queue.peek()}")
  println(s"HeapQueue dequeue: ${Heap_queue.dequeue()}")
  println(s"HeapQueue size after dequeue: ${Heap_queue.size()}")
}

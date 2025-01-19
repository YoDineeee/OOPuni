import  scala.collection.mutable.Queue

class Simple_Queue[T] extends AbstractQueue[T] {

  private val queue: Queue[T] = Queue.empty[T]


  override def enqueue(element: T): Unit = {
    queue.enqueue(element)
    count += 1
  }

  
  override def dequeue(): T = {
    if (is_empty()) throw new NoSuchElementException("Queue is empty")
    count -= 1
    queue.dequeue()
  }

 
  override def peek(): T = {
    if (is_empty()) throw new NoSuchElementException("Queue is empty")
    queue.front
  }
}
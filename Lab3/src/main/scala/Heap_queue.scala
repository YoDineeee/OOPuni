import scala.collection.mutable.PriorityQueue


// Heap_queue implementation
class Heap_queue[T](implicit ord: Ordering[T]) extends AbstractQueue[T]  {
    

  // Enqueue an element into the heap queue
  override def enqueue(element: T): Unit = {
    heap.enqueue(element)
    count += 1
  }

  // Dequeue an element from the heap queue
  override def dequeue(): T = {
    if (is_empty()) throw new NoSuchElementException("Queue is empty")
    count -= 1
    heap.dequeue()
  }


  def peek(): T = {
    if (is_empty()) throw new NoSuchElementException("peek on empty heap")
    else heap.head
  }

  // Check if the queue is empty
  override def is_empty(): Boolean = heap.isEmpty
}

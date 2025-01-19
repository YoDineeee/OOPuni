import scala.collection.mutable.ArrayDeque

class DeQueue[T] extends AbstractQueue[T]  {
  private val deque: ArrayDeque[T] = ArrayDeque.empty[T]

  override def enqueue(element: T): Unit = {
    deque.append(element) 
    count += 1
  }

  override def dequeue(): T = {
    if (is_empty()) throw new NoSuchElementException("Queue is empty")
    count -= 1
    deque.removeHead() 
  }

  override def peek(): T = {
    if (is_empty()) throw new NoSuchElementException("Queue is empty")
    deque.head 
  }

  // Additional Deque Operations
  def enqueueFront(element: T): Unit = {
    deque.prepend(element) 
    count += 1
  }

  def dequeueBack(): T = {
    if (is_empty()) throw new NoSuchElementException("Queue is empty")
    count -= 1
    deque.removeLast() 
  }
}

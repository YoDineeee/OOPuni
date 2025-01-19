abstract class AbstractQueue[T] extends Queue[T]{
  protected var count: Int = 0


  override def is_empty(): Boolean = count == 0
  override def size(): Int = count 

  def enqueue(element: T): Unit //adding an element to the queue
  def dequeue(): T //deleting an element to the queue
  def peek(): T  //peeking 
  

}

package carsystem
import scala.reflect.ClassTag
import java.util.NoSuchElementException

class CircularQueue[T: ClassTag](initialSize: Int) extends Queue[T] {
  private var front = -1
  private var rear = -1
  private var nums = Array.ofDim[T](initialSize)

  override def enqueue(item: T): Unit = {
    if (isFull) resize()
    if (isEmpty) front = 0

    rear = (rear + 1) % nums.length
    nums(rear) = item
  }

  override def dequeue(): T = {
    if (isEmpty) throw new NoSuchElementException("Queue is empty")

    val temp = nums(front)
    if (front == rear) {
      front = -1
      rear = -1
    } else {
      front = (front + 1) % nums.length
    }
    temp
  }

  override def peek: T = {
    if (isEmpty) throw new NoSuchElementException("Queue is empty")
    nums(front)
  }

  override def isEmpty: Boolean = front == -1

  override def isFull: Boolean = !isEmpty && (rear + 1) % nums.length == front

  private def resize(): Unit = {
    val newSize = nums.length * 2
    val tempArr = Array.ofDim[T](newSize)

    var i = 0
    var j = front
    var firstIteration = true

    while (firstIteration || j != front) {
      firstIteration = false
      tempArr(i) = nums(j)
      i += 1
      j = (j + 1) % nums.length
    }

    front = 0
    rear = nums.length - 1
    nums = tempArr
  }

  // Additional method for debugging/insight
  def currentSize: Int = nums.length
}

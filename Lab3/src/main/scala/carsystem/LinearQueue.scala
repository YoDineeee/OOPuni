package carsystem

import scala.reflect.ClassTag
import java.util.NoSuchElementException
import scala.collection.mutable

class LinearQueue[T: ClassTag](initialSize: Int) extends mutable.Queue[T] {
  private var frontIndex = -1
  private var rearIndex = -1
  private val nums = Array.ofDim[T](initialSize)

  override def enqueue(elem: T): this.type = {
    if (isFull) {
      throw new IllegalStateException("Queue is full")
    }
    if (isEmpty) {
      frontIndex = 0
    }
    rearIndex += 1
    nums(rearIndex) = elem
    this // Return the current instance to allow method chaining
  }

  def enqueueAll(elems: T*): Unit = {
    elems.foreach(enqueue)
  }

  override def dequeue(): T = {
    if (isEmpty) {
      throw new NoSuchElementException("Queue is empty")
    }
    val temp = nums(frontIndex)
    if (frontIndex == rearIndex) {
      frontIndex = -1
      rearIndex = -1
    } else {
      frontIndex += 1
    }
    temp
  }

  def peek: T = {
    if (isEmpty) {
      throw new NoSuchElementException("Queue is empty")
    }
    nums(frontIndex)
  }

  override def isEmpty: Boolean = frontIndex == -1

  def isFull: Boolean = rearIndex == nums.length - 1

  private def currentSize: Int = if (isEmpty) 0 else rearIndex - frontIndex + 1

  override def iterator: Iterator[T] = new Iterator[T] {
    private var current = frontIndex
    override def hasNext: Boolean = current != -1 && current <= rearIndex
    override def next(): T = {
      if (!hasNext) throw new NoSuchElementException("No more elements")
      val res = nums(current)
      current += 1
      res
    }
  }

  override def length: Int = currentSize
}
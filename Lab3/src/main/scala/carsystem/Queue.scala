package carsystem

trait Queue[T] {
  def enqueue(item: T): Unit
  def dequeue(): T
  def peek: T
  def isEmpty: Boolean
  def isFull: Boolean
}
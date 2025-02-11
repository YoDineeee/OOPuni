package carsystem
import scala.beans.BeanProperty

class Car {
  @BeanProperty var id: Int = _
  @BeanProperty var carType: String = _
  @BeanProperty var passengers: String = _
  private var _isDining: Boolean = _
  @BeanProperty var consumption: Int = _

  // Custom getter and setter for isDining to match JavaBean naming
  def isDining: Boolean = _isDining
  def setIsDining(isDining: Boolean): Unit = _isDining = isDining

  override def toString: String =
    s"Car(id=$id, type='${`carType`}', passengers='$passengers', isDining=$isDining, consumption=$consumption)"
}
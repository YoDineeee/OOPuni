import Barista.Barista

object Main {
  def main(args: Array[String]): Unit = {
    val barista = new Barista
    barista.makeCoffees(List("Cappuccino", "SyrupCappuccino", "PumpkinSpiceLatte"))
  }
}


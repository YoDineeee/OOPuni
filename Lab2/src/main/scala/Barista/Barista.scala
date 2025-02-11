package Barista

import Coffee._


class Barista {
  def makeCoffees(coffeeOrders: List[String]): Unit = {
    coffeeOrders.foreach { order =>
      val coffee = order match {
        case "Americano" =>
          new Americano(Intensity.NORMAL, 200)
        case "Cappuccino" =>
          new Cappuccino(Intensity.NORMAL, 150, 100)
        case "PumpkinSpiceLatte" =>
          new PumkinSpiceLatte(Intensity.STRONG, 100, 150, SyrupType.VANILLA, 50)
        case "SyrupCappuccino" =>
          new SyrupCappuccino(Intensity.LIGHT, 100, 150, SyrupType.CARAMEL)
        case _ =>
          println(s"Unknown coffee type: $order")
          null
      }

      if (coffee != null) {
        coffee match {
          case americano: Americano =>
            americano.makeAmericano()
          case cappuccino: Cappuccino =>
            cappuccino.makeCappuccino()
          case syrupCappuccino: SyrupCappuccino =>
            syrupCappuccino.makeRecipe() 
          case pumpkinSpiceLatte: PumkinSpiceLatte =>
            pumpkinSpiceLatte.makePumpkinSpiceLatte()
          case _ =>
            println("Something went wrong")
        }
        coffee.printCoffeeDetails()
      }
    }
  }
}
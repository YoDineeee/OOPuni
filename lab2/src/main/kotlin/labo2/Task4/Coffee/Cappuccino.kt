package labo2.Task4.Coffee


import  org.example.labo2.Task1.Intensity
import labo2.Task4.CoffeeType


internal open class Cappuccino(
    private var intensity: Intensity,
    private var mlOfMilk: Int,
    private val coffee: String = "Cappuccino"
) : Coffee(intensity, coffee) {
    // Inheriting, overriding printCoffeeDetails from Coffee and making it a base class
    public override fun printCoffeeDetails() {
        super.printCoffeeDetails()
        println("Milk: $mlOfMilk ml")
    }
    // Method to print recipe of Cappuccino
    public fun makeCappuccino(): Cappuccino {
        super.makeCoffee()
        println("Adding $mlOfMilk ml of milk")
        return this
    }
}
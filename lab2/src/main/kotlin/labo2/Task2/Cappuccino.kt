package org.example.labo2.Task2
import   org.example.labo2.Task1.Intensity

open class Cappuccino(
    private var intensity: Intensity,
    private var mlOfMilk: Int,
    private val coffee: String = "Cappuccino"
) : Coffee(intensity, coffee) {
    // Inheriting, overriding printCoffeeDetails from Coffee and making it a base class
    public override fun printCoffeeDetails() {
        super.printCoffeeDetails()
        println("Milk: $mlOfMilk ml")
    }
}
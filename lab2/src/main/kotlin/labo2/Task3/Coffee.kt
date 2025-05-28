package org.example.labo2.Task3

import org.example.labo2.Task1.Intensity

// Parent class Coffee
open class Coffee(
    private var coffeeIntensity: Intensity,
    private val name: String = "Coffee"
) {
    // Creating base function printCoffeeDetails
    public open fun printCoffeeDetails() {
        println("Recipe for $name")
        println("Coffee intensity: $coffeeIntensity")
    }
    // Method to print recipe of Coffee
    public fun makeCoffee(): Coffee {
        println("Making $name")
        println("Setting intensity to $coffeeIntensity")
        return Coffee(coffeeIntensity)
    }
}
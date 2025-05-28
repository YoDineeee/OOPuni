package labo2.Task4.Coffee


import  org.example.labo2.Task1.Intensity
import labo2.Task4.CoffeeType

// Parent class Coffee
internal open class Coffee(
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
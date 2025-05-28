package labo2.Task4
import  org.example.labo2.Task1.Intensity


data class CoffeeOrder(
    val coffeeType: String,
    val intensity: Intensity,
    val mlOfWater: Int = 0,
    val mlOfMilk: Int = 0,
    val mgOfPumpkinSpice: Int = 0
)
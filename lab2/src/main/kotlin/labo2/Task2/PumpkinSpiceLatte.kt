package org.example.labo2.Task2
import  org.example.labo2.Task1.Intensity

class PumpkinSpiceLatte(
    private var intensityOfCoffee: Intensity,
    private var mlOfMilk: Int,
    private var mgOfPumpkinSpice: Int,
    private val name: String = "PumpkinSpiceLatte"
) : Cappuccino(intensityOfCoffee, mlOfMilk, name) {
    // Inheriting and overriding printCofeeDetails from Cappuccino
    public override fun printCoffeeDetails() {
        super.printCoffeeDetails()
        println("Pumpkin Spice: $mgOfPumpkinSpice mg")
    }
}
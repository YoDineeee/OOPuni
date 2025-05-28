package org.example.labo2.Task2

import  org.example.labo2.Task1.Intensity
import  org.example.labo2.Task1.SyrupType

class SyrupCappuccino(
    private var intensityCoffe: Intensity,
    private var mltrOfMilk: Int,
    private var syrup: SyrupType,
    private val coffee: String = "SyrupCappuccino"
) : Cappuccino(intensityCoffe, mltrOfMilk, coffee) {
    // Inheriting and overriding printCoffeeDetails from Cappuccino
    public override fun printCoffeeDetails() {
        super.printCoffeeDetails()
        println("Syrup type: $syrup")
    }
}
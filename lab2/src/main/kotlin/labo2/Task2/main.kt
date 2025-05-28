package org.example.labo2.Task2

import  org.example.labo2.Task1.Intensity
import  org.example.labo2.Task1.SyrupType

fun main() {
    // Test data
    val coffee = Coffee(Intensity.STRONG)
    coffee.printCoffeeDetails()
    val cappuccino = Cappuccino(Intensity.LIGHT, 250)
    cappuccino.printCoffeeDetails()
    val pumpkinSpiceLatte = PumpkinSpiceLatte(Intensity.NORMAL, 250, 30)
    pumpkinSpiceLatte.printCoffeeDetails()
    val syrupCappuccino = SyrupCappuccino(Intensity.NORMAL, 250, SyrupType.CARAMEL)
    syrupCappuccino.printCoffeeDetails()
    val americano = Americano(Intensity.STRONG, 150)
    americano.printCoffeeDetails()

}
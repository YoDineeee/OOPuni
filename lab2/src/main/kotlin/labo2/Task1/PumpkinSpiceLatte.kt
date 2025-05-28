package org.example.labo2.Task1

class PumpkinSpiceLatte(
    private var intensityOfCoffee: Intensity,
    private var mlOfMilk: Int,
    private var mgOfPumpkinSpice: Int,
    private val name: String = "PumpkinSpiceLatte"
) : Cappuccino(intensityOfCoffee, mlOfMilk, name) {
    //pass
}
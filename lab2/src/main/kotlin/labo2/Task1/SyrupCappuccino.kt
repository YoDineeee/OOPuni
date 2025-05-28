package org.example.labo2.Task1

class SyrupCappuccino(
    private var intensityCoffe: Intensity,
    private var mltrOfMilk: Int,
    private var syrup: SyrupType,
    private val coffee: String = "SyrupCappuccino"
) : Cappuccino(intensityCoffe, mltrOfMilk, coffee) {
    //pass
}
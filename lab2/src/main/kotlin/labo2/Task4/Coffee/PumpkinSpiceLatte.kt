package labo2.Task4.Coffee
import  org.example.labo2.Task1.Intensity

internal class PumpkinSpiceLatte(
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
    // Method to print recipe of PumpkinSpiceLatte
    public fun makePumpkinSpiceLatte(): PumpkinSpiceLatte {
        super.makeCappuccino()
        println("Adding $mgOfPumpkinSpice mg of pumpkin spice")
        return this
    }
}
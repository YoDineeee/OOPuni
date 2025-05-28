package labo2.Task4.Coffee


import org.example.labo2.Task1.Intensity
import org.example.labo2.Task1.SyrupType
import labo2.Task4.CoffeeType

// Class for a barista
class Barista(
    val availableCoffee: List<CoffeeType>,
    val availableIntensities: List<Intensity>,
    val availableSyrups: List<SyrupType>
) {
    // Method to take user input used later in taking orders
    private fun <T> takeUserInput(prompt: String, options: List<T>): T {
        println(prompt)
        for (i in options.indices) {
            println("${i + 1}. ${options[i]}")
        }
        var choice: Int
        do {
            println("Your choice must be a number between 1 and ${options.size}.")
            choice = readLine()!!.toInt()
        } while (choice !in 1..options.size)
        return options[choice - 1]
    }
    // Method to take order of the kind of coffee
    private fun takeCoffeeKind(): CoffeeType {
        return takeUserInput("What kind of coffee would you like?", availableCoffee)
    }
    // Method to take order of the coffee intensity
    private fun takeIntensity(): Intensity {
        return takeUserInput("What kind of intensity would you like?", availableIntensities)
    }
    // Method to take order of the syrup kind for SyrupCappuccino
    private fun takeSyrupType(): SyrupType {
        return takeUserInput("What kind of syrup would you like?", availableSyrups)
    }
    // Method to take order of the amount of water in americano orders
    private fun takeMililitersOfWater(): Int {
        var mlOfWater: Int;
        do {
            println("How many ml of water would you like?")
            mlOfWater = readLine()!!.toInt()
        } while (mlOfWater <= 0)
        return mlOfWater

    }
    // Method to take order of the amount of milk in cappuccino orders
    private fun takeMililitersOfMilk(): Int {
        var mlOfMilk: Int;
        do {
            println("How many ml of milk would you like?")
            mlOfMilk = readLine()!!.toInt()
        } while (mlOfMilk <= 0)
        return mlOfMilk
    }
    // Method to take order of the amount of pumpkin spice in PumpkinSpiceLatte orders
    private fun takeMiligramsOfPumpkinSpice(): Int {
        var mgOfPumpkinSpice: Int;
        do {
            println("How many mg of pumpkin spice would you like?")
            mgOfPumpkinSpice = readLine()!!.toInt()
        } while (mgOfPumpkinSpice <= 0)
        return mgOfPumpkinSpice
    }
    // Internal method to take orders of coffee
    internal fun takeOrder(): Coffee? {
        println("Welcome to the Coffee Shop!")
        var coffeeKind = takeCoffeeKind()
        var coffeeIntensity = takeIntensity()
        when (coffeeKind) {
            CoffeeType.AMERICANO -> {
                val mlOfWater = takeMililitersOfWater()
                val americano = Americano(coffeeIntensity, mlOfWater)
                return americano.makeAmericano()
            }
            CoffeeType.CAPPUCCINO -> {
                var mlOfMilk = takeMililitersOfMilk()
                var cappuccino = Cappuccino(coffeeIntensity, mlOfMilk)
                return cappuccino.makeCappuccino()
            }
            CoffeeType.PUMPKIN_SPICE_LATTE -> {
                var mlOfMilk = takeMililitersOfMilk()
                var mgOfPumpkinSpice = takeMiligramsOfPumpkinSpice()
                var pumpkinSpiceLatte = PumpkinSpiceLatte(coffeeIntensity,mlOfMilk,mgOfPumpkinSpice)
                return pumpkinSpiceLatte.makePumpkinSpiceLatte()
            }
            CoffeeType.SYRUP_CAPPUCCINO -> {
                var mlOfMilk = takeMililitersOfMilk()
                var syrup = takeSyrupType()
                var syrupCapuccino = SyrupCappuccino(coffeeIntensity, mlOfMilk, syrup)
                return syrupCapuccino.makeSyrupCappuccino()
            }
            else -> {
                println("Sorry! We do not currently serve this coffee type.")
                return null
            }
        }
    }
    // Public method to say a wish
    public fun sayWish() {
        var randomNumber = (0..3).random()
        when (randomNumber) {
            0 -> println("Have a brew-tiful day!")
            1 -> println("Take life one sip at a time!")
            2 -> println("May your coffee be strong and your day be smooth!")
            3 -> println("Have a frappé-tastic day!")
        }
    }
}
package labo1.Task4


import labo1.Task2.FileReader
import labo1.Task2.InfoDisplay
import labo1.Task2.TextData

import java.io.File

fun main(args: Array<String>) {
    // Instantiate a FileReader object
    val reader = FileReader()
    // Check if the command line arguments satisfy the lab condition
    if (args.size >= 2 && args.size % 2 == 0) {
        // Instantiate an InfoDisplay object to print information
        val printer = InfoDisplay()
        for (i in 0 until args.size step 2) {
            // Name of the file sent as a command line argument
            val name = args[i]
            // Filepath sent as a command line argument
            val path = args[i + 1]
            // Create a TextData object using the default constructor
            val text = TextData(fileName = name, text = reader.readFileIntoString(path))
            // Call the methods of the TextData using the printer object
            printer.displayInformation(text)
        }
    } else {

        error("Command-line arguments need to have the structure: nameOfTheFile pathToTheFile.")

    }
}
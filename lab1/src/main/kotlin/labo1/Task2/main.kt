package labo1.Task2


import java.io.File

fun main(args: Array<String>) {
    // Instantiate a FileReader object
    val reader = FileReader()
    // Check if the command line arguments satisfy the lab condition
    if (args.size == 2) {
        // Instantiate an InfoDisplay object to print information
        val printer = InfoDisplay()
        // Name of the file sent as a command line argument
        val name = args[0]
        // Filepath sent as a command line argument
        val path = args[1]
        // Create a TextData object using the default constructor
        val text1 = TextData(fileName = name, text = reader.readFileIntoString(path))
        // Call the methods of the TextData using the printer object
        printer.displayInformation(text1)
        // Create a TextData object using the secondary constructor (which in java would have been TextData(String text))
        val text2 = TextData("Hello, people!")
        // Call the methods of the TextData object using the printer object
        printer.displayInformation(text2)
    } else {
        // if the command line argument don't satisfy the lab condition, throw an error
        error("Command-line arguments need to have the structure: nameOfTheFile pathToTheFile.")
        // example of cmd line arguments: input.txt src/main/resources/Lab1/input.txt
    }
}
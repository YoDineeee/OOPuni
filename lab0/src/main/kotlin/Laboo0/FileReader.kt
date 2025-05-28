package Laboo0

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File

// Class for file reading and parsing
class FileReader(
) {
    // Method to read a JSON from a file
    fun readJson(filePath: String): String {
        // Variable for filepath
        val file = File(filePath)
        // Check if file exists
        if (file.exists()) {
            // Read the content
            val text = file.readText()
            if (text.isNotEmpty()) {
                // If the content is not empty, return it
                return text
            } else {
                // If the content is empty, raise an error
                error("File cannot be empty")
            }
        } else {
            // If the file is not found, raise an error
            error("File not found!")
        }
    }

    // Method to deserialize a JSON
    fun parseJson(text: String): List<Creature> {
        // Create an instance of the JacksonObjectMapper
        val mapper = jacksonObjectMapper()
        // Deserialize the creatures
        val creatureList: CreatureList = mapper.readValue(text)
        // Return the list of creatures
        return creatureList.data
    }
}
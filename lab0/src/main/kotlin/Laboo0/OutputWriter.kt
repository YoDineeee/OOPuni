package Laboo0


import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.File
import java.util.*

// Class to write the output
class OutputWriter() {
    // Method to write to files
    fun writeToOutputFiles(path: String, universes: List<Universe>) {
        // Use Jackson Object Mapper to serialize
        val mapper = jacksonObjectMapper()
        for (universe in universes) {
            // Store data in the files universeName.json
            val outputFile = File("$path/${universe.name.lowercase(Locale.getDefault())}.json")
            // Create the parent directory if it doesn't exist
            outputFile.parentFile.mkdirs()
            // Write in the file
            outputFile.writeText(mapper.writeValueAsString(CreatureList(universe.individuals)))
        }
    }
}
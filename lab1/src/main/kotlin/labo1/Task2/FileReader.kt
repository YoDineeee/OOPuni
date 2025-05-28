package labo1.Task2

import kotlin.io.path.Path
import kotlin.io.path.readText

class FileReader() {
    //+ String readFileIntoString(String path)
    public fun readFileIntoString(path: String): String {
        // Read the text from the file
        val text = Path(path).readText()
        if (text.isNotBlank()) {
            return text
        } else {
            // Throw an error if the file is empty
            error("File is empty.")
        }
    }
}
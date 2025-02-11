import java.nio.file.{Files, Paths}
import java.io.IOException

object main {
  def main(args: Array[String]): Unit = {
    if (args.isEmpty) {
      println("Please provide the file path as a command-line argument.")
      return
    }

    args.foreach { filePath =>
      try {
        val fileContent = FileReader.readFileIntoString(filePath)
        println(s"Processing file: $filePath")

        val textData = new TextData(filePath, fileContent)

        println(s"File Name: ${textData.getFileName}")
        println(s"Text: ${textData.getText}")
        println()
        println(s"Number of Vowels: ${textData.getNumberOfVowels}")
        println(s"Number of Consonants: ${textData.getNumberOfConsonants}")
        println(s"Number of Letters: ${textData.getNumberOfLetters}")
        println(s"Number of Sentences: ${textData.getNumberOfSentences}")
        println(s"Longest Word: ${textData.getLongestWord}")

      } catch {
        case e: IOException =>
          println(s"An error occurred while reading the file: ${e.getMessage}")
      }
    }
  }
}
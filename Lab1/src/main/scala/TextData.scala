class TextData(fileName: String, text: String) {
  private var numberOfVowels = 0
  private var numberOfConsonants = 0
  private var numberOfLetters = 0
  private var numberOfSentences = 0
  private var longestWord = ""

  // Analyze text upon initialization
  analyzeText()

  private def analyzeText(): Unit = {
    val words = text.split("\\s+")

    // Find longest word
    words.foreach { word =>
      if (word.length > longestWord.length) {
        longestWord = word
      }
    }

    text.foreach { ch =>
      // Count letters, vowels, and consonants
      if (ch.isLetter) {
        numberOfLetters += 1
        if ("AEIOUaeiou".contains(ch)) {
          numberOfVowels += 1
        } else {
          numberOfConsonants += 1
        }
      } else if (ch == '.' || ch == '!' || ch == '?') { // Check for end of sentence
        numberOfSentences += 1
      }
    }
  }

  def getFileName: String = fileName
  def getText: String = text
  def getNumberOfVowels: Int = numberOfVowels
  def getNumberOfConsonants: Int = numberOfConsonants
  def getNumberOfLetters: Int = numberOfLetters
  def getNumberOfSentences: Int = numberOfSentences
  def getLongestWord: String = longestWord
}
import scala.io.Source
import play.api.libs.json.{Json, JsValue}

class ReadFile {

  // Parses the JSON file and returns a list of Creatură instances
  def readJsonFile(filePath: String): List[Creatură] = {
    val source = Source.fromFile(filePath)
    try {
      val jsonString = source.getLines.mkString
      println(s"Read JSON String: $jsonString") // Debugging output
      val json: JsValue = Json.parse(jsonString)

      // Convert JSON array to List[Creatură]
      json.as[List[Creatură]] // This now works due to the implicit Reads
    } catch {
      case e: Exception =>
        println(s"Error processing JSON: ${e.getMessage}")
        throw e
    } finally {
      source.close()
    }
  }
}

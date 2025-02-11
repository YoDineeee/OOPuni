import java.nio.file.{Files, Paths}
import java.io.IOException

object FileReader {
  @throws[IOException]
  def readFileIntoString(path: String): String = {
    new String(Files.readAllBytes(Paths.get(path)))
  }
}
import com.fasterxml.jackson.databind.{JsonNode, ObjectMapper}
import org.scalatest._
import org.scalatest.BeforeAndAfterEach
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito._
import java.io.File

class FileReadTest extends AnyFunSuite with BeforeAndAfterEach with MockitoSugar {

  private var mapper: ObjectMapper = _
  private var inputFile: File = _
  private var data: JsonNode = _

  override def beforeEach(): Unit = {
    mapper = new ObjectMapper()

    val jsonContent = """{ "id": 1, "consumption": 10, "isDining": true, "passengers": "PEOPLE", "type": "GAS" }"""
    data = mapper.readTree(jsonContent)

    inputFile = mock[File]
    when(inputFile.exists()).thenReturn(true)
  }

  test("Read file data correctly") {
    val id = data.get("id").asInt()
    val consumption = data.get("consumption").asInt()
    val isDining = data.get("isDining").asBoolean()
    val passengers = data.get("passengers").asText()
    val `type` = data.get("type").asText()

    assert(id == 1)
    assert(consumption == 10)
    assert(isDining)
    assert(passengers == "PEOPLE")
    assert(`type` == "GAS")
  }
}
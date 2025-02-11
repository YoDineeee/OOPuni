import java.io.{File, FileWriter}
import java.nio.file.{Files, Paths}
import play.api.libs.json.{Json, JsObject, Writes}

class JudgeRoom {

  // Define the output directory for universe files
  val outputDir = "src/main/resources/Output"
  Files.createDirectories(Paths.get(outputDir)) // Ensure the output directory exists

  // Main method to classify and store creatures in appropriate universe files
  def classifyAndStoreCreatures(creatures: List[Creatură]): Unit = {
    creatures.foreach { creature =>
      determineUniverse(creature).foreach { universe =>
        saveCreatureToFile(creature, universe)
      }
    }
  }

  // Determines the universe for a given creature based on rules
  def determineUniverse(creature: Creatură): Option[String] = {
    creature match {
      case c if isDwarf(c) => Some("Lord of Rings Universe (Dwarf)")
      case c if isElf(c) => Some("Lord of Rings Universe (Elf)")
      case c if isBetelGeuse(c) => Some("Hitchhiker Universe (BetelGeuse)")
      case c if isVogsphere(c) => Some("Hitchhiker Universe (Vogsphere)")
      case c if isAsgardian(c) => Some("Marvel Universe (Asgardian)")
      case c if isEwoke(c) => Some("StarWars Universe (Ewoke)")
      case c if isWookie(c) => Some("StarWars Universe (Wookie)")
      case _ => None
    }
  }

  // Helper methods for each classification rule
  private def isDwarf(creature: Creatură): Boolean = {
    creature.isHumanoid &&
      creature.age >= 0 && creature.age <= 200 &&
      creature.traits.contains("SHORT") &&
      creature.traits.contains("BULKY")
  }

  private def isElf(creature: Creatură): Boolean = {
    creature.isHumanoid &&
      creature.age == 0 && // Assuming age 0 signifies a young elf
      creature.traits.contains("POINTY_EARS") &&
      creature.traits.contains("BLONDE")
  }

  private def isBetelGeuse(creature: Creatură): Boolean = {
    creature.isHumanoid &&
      creature.age >= 0 && creature.age <= 100 &&
      (creature.traits.contains("EXTRA_ARMS") || creature.traits.contains("EXTRA_HEAD"))
  }

  private def isVogsphere(creature: Creatură): Boolean = {
    !creature.isHumanoid &&
      creature.age >= 0 && creature.age <= 200 &&
      creature.traits.contains("GREEN") &&
      creature.traits.contains("BULKY")
  }

  private def isAsgardian(creature: Creatură): Boolean = {
    creature.isHumanoid &&
      creature.age >= 0 && creature.age <= 5000 &&
      creature.traits.contains("TALL") &&
      creature.traits.contains("BLONDE")
  }

  private def isEwoke(creature: Creatură): Boolean = {
    !creature.isHumanoid &&
      creature.age >= 0 && creature.age <= 60 &&
      creature.traits.contains("SHORT") &&
      creature.traits.contains("HAIRY")
  }

  private def isWookie(creature: Creatură): Boolean = {
    !creature.isHumanoid &&
      creature.age >= 0 && creature.age <= 400 &&
      creature.traits.contains("TALL") &&
      creature.traits.contains("HAIRY")
  }

  // Saves a creature's details to the specified universe file
  private def saveCreatureToFile(creature: Creatură, universe: String): Unit = {
    val filePath = s"$outputDir/$universe.json"
    val file = new File(filePath)
    val writer = new FileWriter(file, true)

    val jsonWithId: JsObject = Json.obj(
      "id" -> creature.id,
      "isHumanoid" -> creature.isHumanoid,
      "age" -> creature.age,
      "planet" -> creature.planet,
      "traits" -> creature.traits
    )

    writer.write(Json.prettyPrint(jsonWithId) + "\n")
    writer.close()
  }
}
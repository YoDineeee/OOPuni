import play.api.libs.json.{Json, OFormat}

case class Creature(
                     id: Int,
                     isHumanoid: Boolean,
                     planet: String,
                     age: Int,
                     traits: List[String]
                   )

object Creature {
  // Ensure implicit Reads and Writes are defined
  implicit val format: OFormat[Creatură] = Json.format[Creature]
}


case class car(
                id: Int,
                `type`: String,
                passengers: String,
                isDining: Boolean,
                consumption: Int
              )

// Define an implicit Ordering for car
object car {
  implicit val carOrdering: Ordering[car] = Ordering.by(_.id)
 
}

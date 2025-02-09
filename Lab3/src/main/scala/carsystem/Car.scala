package carsystem

case class Car(
                id: String,
                carType: String,      // "GAS" or "ELECTRIC"
                passengers: String,   // "PEOPLE" or "ROBOTS"
                isDining: Boolean,
                consumption: Int
              )

class Rigister {
  val services: Map[String, Refuelable] = Map(
    "GAS" -> new GasRefuelService,
    "ELECTRIC" -> new ElectricRefuelService
  )

}

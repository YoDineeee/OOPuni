object Main extends App {
  // Instantiate the ReadFile and JudgeRoom classes
  val readFile = new ReadFile()
  val judgeRoom = new JudgeRoom()

  // Path to your JSON file
  val filePath = "src/main/resources/input.json" // Replace with the actual path to your JSON file

  // Read creatures from the JSON file
  val creatures = readFile.readJsonFile(filePath)

  // Classify and store the creatures
  judgeRoom.classifyAndStoreCreatures(creatures)
}
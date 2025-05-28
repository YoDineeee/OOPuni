package labo1.Task1

class Display(
    private var width: Int,
    private var height: Int,
    private var ppi: Float,
    private var model: String,
) {
    // Instantiate an ObjectComparison instance to use it in the methods of the Display class
    private val objectComparer = ValueComparer()
    // Method to compare size
    fun compareSize(m: Display) {

        val selfArea = width * height
        val mArea = m.width * m.height
        objectComparer.compareValues(selfArea.toFloat(), mArea.toFloat(), "size", model, m.model)

    }
    // Method to compare sharpness
    fun compareSharpness(m: Display) {
        objectComparer.compareValues(ppi, m.ppi, "sharpness", model, m.model)
    }
    // Method to compare both sharpness and size
    fun compareWithMonitor(m: Display) {
        compareSize(m)
        compareSharpness(m)
    }
    // Getter function for name for Task #3
    fun getName(): String {
        return model
    }
}
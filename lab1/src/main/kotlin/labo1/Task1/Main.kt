package labo1.Task1
import labo1.Task3.MonitorComparer


fun main() {
    // Instantiate 3 objects of the Display class
    val monitors = listOf(
        Display(1600, 900, 100.5f, "ASUS"),
        Display(1920, 1200, 106.99f, "Samsung"),
        Display(2560, 1080, 98.0f, "Dell")
    )
    // Compare the objects in between them
    val comparer = MonitorComparer()
    comparer.compareMonitors(monitors)
}
package labo1.Task1

class ValueComparer {
    // Method to compare values
    public fun compareValues(value1: Float, value2: Float, criteria: String, name1: String, name2: String) {
        when {
            value1 == value2 -> println("The $criteria of the $name1 monitor is equal to the $criteria of $name2 monitor.")
            value1 > value2 -> println("The $criteria of the $name1 monitor is bigger than the $criteria of $name2 monitor.")
            value1 < value2 -> println("The $criteria of the $name1 monitor is smaller than the $criteria of $name2 monitor.")
        }
    }
}
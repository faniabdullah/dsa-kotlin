package algorithms.sorting

class QuickSortIteration {

    fun quickSort(intArray: IntArray, low: Int, high: Int) {
        if (low < high) {
            val pi = partition(intArray, low, high)
            quickSort(intArray, low, pi - 1)
            quickSort(intArray, pi + 1, high)
        }
    }

    private fun partition(intArray: IntArray, low: Int, high: Int): Int {
        var indexPartition = low - 1
        val pipot = intArray[high]
        println("$pipot that's pipot ${intArray.contentToString()}")
        for (i in low..high) {
            if (intArray[i] <= pipot) {
                indexPartition++
                val temp = intArray[indexPartition]
                intArray[indexPartition] = intArray[i]
                intArray[i] = temp

            }
        }


        println(intArray.contentToString())
        return indexPartition
    }


}

fun main() {
    val quickSortIteration = QuickSortIteration()
    val array = intArrayOf(1, 2, 3, 5, 4, 6, 8, 7)
    quickSortIteration.quickSort(array, 0, array.size - 1)
    println(array.contentToString())
}
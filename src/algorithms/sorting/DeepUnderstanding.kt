package algorithms.sorting

import kotlin.random.Random

class DeepUnderstanding {
    // my hold on sorting is bubble sort and quick sort

    fun bubbleSort(intArray: IntArray) {
        var swapped: Boolean
        for (i in intArray.indices) {
            swapped = false
            for (j in 0 until intArray.size - i - 1) {
                if (intArray[j] > intArray[j + 1]) {
                    val temp = intArray[j]
                    intArray[j] = intArray[j + 1]
                    intArray[j + 1] = temp
                    swapped = true
                }
            }
            if (!swapped) {
                break
            }
        }
    }

    fun bubbleSortUnderstanding(intArray: IntArray) {
        var swapElement = false
        for (i in intArray.indices) {
            swapElement = false
            for (j in 0 until intArray.size - 1 - i) {
                if (intArray[j] > intArray[j + 1]) {
                    val temp = intArray[j]
                    intArray[j] = intArray[j + 1]
                    intArray[j + 1] = temp
                }
                swapElement = true
            }
            if (!swapElement) {
                break
            }
        }
    }

    fun quickSort(intArray: IntArray, low: Int, height: Int) {
        if (low < height) {
            val partition = partition(intArray, low, height)
            quickSort(intArray, low, partition - 1)
            quickSort(intArray, partition + 1, height)
        }
    }

    private fun partition(intArray: IntArray, low: Int, height: Int): Int {
        val pivot = intArray[height]
        var indexPivot = low - 1
        for (i in low..height) {
            if (intArray[i] <= pivot) {
                indexPivot++
                val temp = intArray[indexPivot]
                intArray[indexPivot] = intArray[i]
                intArray[i] = temp
            }
        }

        return indexPivot
    }

    fun quickSortUnderStanding(intArray: IntArray, low: Int, height: Int) {
        if (low < height) {
            val pi = partitionUnderstanding(intArray, low, height)
            quickSortUnderStanding(intArray, low, pi - 1)
            quickSortUnderStanding(intArray, pi + 1, height)
        }
    }

    private fun partitionUnderstanding(intArray: IntArray, low: Int, height: Int): Int {
        val pivot = intArray[height]
        var indexPivot = low - 1
        for (i in low..height) {
            if (intArray[i] <= pivot) {
                indexPivot++
                val temp = intArray[indexPivot]
                intArray[indexPivot] = intArray[i]
                intArray[i] = temp
            }
        }
        return indexPivot
    }

}


fun main() {

    val numbers = IntArray(10) { Random.nextInt(0, 9) }

    println(numbers.contentToString())
    val deepUnderstanding = DeepUnderstanding()
    deepUnderstanding.quickSort(numbers, 0, numbers.size - 1)
    println(numbers.contentToString())
}
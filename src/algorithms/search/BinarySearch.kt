package algorithms.search

class BinarySearch {
    fun binarySearch(arr: IntArray, key: Int): Int {
        var left = 0
        var right = arr.size - 1
        var middle = right / 2

        while (left <= right) {
            when {
                arr[middle] == key -> {
                    return middle
                }
                key > arr[middle] -> {
                    left = middle + 1
                }
                key < arr[middle] -> {
                    right = middle - 1
                }
            }

            middle = (left + right) / 2
        }

        return -1
    }
}

fun main() {
    val binarySearch = BinarySearch()
    val array = intArrayOf(2, 5, 8, 12, 16, 23, 38, 56, 72, 91)
    val result = binarySearch.binarySearch(array, 56)
    println(result)
    val result2 = binarySearch.binarySearch(array, 100)
    println(result2)
}
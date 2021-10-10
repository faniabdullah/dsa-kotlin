package algorithms.recursive

class BinarySearchRecursive {
    fun binarySearch(
        intArray: IntArray, first: Int,
        last: Int, target: Int
    ): Int {
        if (last >= first) {
            val mid: Int = first + (last - first) / 2
            if (intArray[mid] == target) return mid
            if (intArray[mid] > target) return binarySearch(intArray, first, mid - 1, target)
            return binarySearch(intArray, mid + 1, last, target)
        }

        return -1
    }
}

fun main() {
    val arraySearch = intArrayOf(2, 5, 8, 12, 16, 23, 38, 56, 72, 91)
    val result = BinarySearchRecursive()
        .binarySearch(arraySearch, 0, arraySearch.size - 1, 100)
    println(result)
}
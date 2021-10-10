package algorithms.search

class LinearSearch {

    fun linearSearch(arr: IntArray, key: Int): Int {
        for (i in arr.indices) {
            if (arr[i] == key) {
                return i
            }
        }
        return -1
    }
}
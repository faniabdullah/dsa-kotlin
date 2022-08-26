package algorithms.sliding_window


class SlidingWindow {
    fun maximumOfValue(arr: IntArray, k: Int): Int {
        var maxSum = 0
        for (i in 0 until k) {
            maxSum += arr[i]
        }
        var windowSum = maxSum
        for (i in k until arr.size) {
            windowSum += arr[i] - arr[i - k]
            maxSum = maxOf(maxSum, windowSum)
        }
        return maxSum
    }
}




fun main() {
    println(
        SlidingWindow().maximumOfValue
            (
            intArrayOf(1, 4, 2, 10, 2, 3, 1, 0, 20),
            4
        )
    )
}
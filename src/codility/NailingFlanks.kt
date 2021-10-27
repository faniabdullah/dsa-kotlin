package codility

import java.util.*


class NailingFlanks {

    fun solution(A: IntArray, B: IntArray, C: IntArray): Int {
        // the main algorithm is that getting the minimal index of nails which
        // is needed to nail every plank by using the binary search
        val N = A.size
        val M = C.size
        // two dimension array to save the original index of array C
        val sortedNail = Array(M) { IntArray(2) }
        for (i in 0 until M) {
            sortedNail[i][0] = C[i]
            sortedNail[i][1] = i
        }
        // use the lambda expression to sort two dimension array
        Arrays.sort(sortedNail) { x: IntArray, y: IntArray -> x[0] - y[0] }
        var result = 0
        for (i in 0 until N) { //find the earlist position that can nail each plank, and the max value for all planks is the result
            result = getMinIndex(A[i], B[i], sortedNail, result)
            if (result == -1) return -1
        }
        return result + 1
    }

    // for each plank , we can use binary search to get the minimal index of the
    // sorted array of nails, and we should check the candidate nails to get the
    // minimal index of the original array of nails.
    private fun getMinIndex(startPlank: Int, endPlank: Int, nail: Array<IntArray>, preIndex: Int): Int {
        var min = 0
        var max = nail.size - 1
        var minIndex = -1
        while (min <= max) {
            val mid = (min + max) / 2
            if (nail[mid][0] < startPlank) min = mid + 1 else if (nail[mid][0] > endPlank) max = mid - 1 else {
                max = mid - 1
                minIndex = mid
            }
        }
        if (minIndex == -1) return -1
        var minIndexOrigin = nail[minIndex][1]
        //find the smallest original position of nail that can nail the plank
        for (i in minIndex until nail.size) {
            if (nail[i][0] > endPlank) break
            minIndexOrigin = Math.min(minIndexOrigin, nail[i][1])
            // we need the maximal index of nails to nail every plank, so the
            // smaller index can be omitted
            if (minIndexOrigin <= preIndex) return preIndex
        }
        return minIndexOrigin
    }
}

fun main() {
    println(NailingFlanks().solution(intArrayOf(1, 4, 5, 8), intArrayOf(4, 5, 9, 10), intArrayOf(4, 6, 7, 10, 2)))
}
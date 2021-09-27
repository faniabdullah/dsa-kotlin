package leetcode_badge.data_structure

import java.util.*

class Day4 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

        for (i in matrix.indices) {
            if (matrix[i][0] == target) return true
            if (matrix[i][0] > target) {
                return false
            } else if (matrix[i][0] < target) {
                var left = 0
                var right = matrix[i].size - 1
                while (left <= right) {
                    val mid = left + (right - left) / 2
                    if (matrix[i][mid] == target) {
                        return true
                    } else if (target > matrix[i][mid]) {
                        left = mid + 1
                    } else {
                        right = mid - 1
                    }
                }
            }
        }




        return false
    }

    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0
        intervals.sortWith(compareBy({ it.first() }, { it.last() }))
        var count = 0
        var temp = intervals.first().last()
        for (i in 1..intervals.lastIndex) {
            if (intervals[i].first() >= temp) {
                temp = intervals[i].last()
            } else {
                count++
                temp = minOf(intervals[i].last(), temp)
            }
        }
        return count
    }
}

fun main() {
    val matrix =
        arrayOf(
            intArrayOf(5),
            intArrayOf(6),
        )
    println(Day4().searchMatrix(matrix, 6))
}
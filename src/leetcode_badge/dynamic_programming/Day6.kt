package leetcode_badge.dynamic_programming

class Day6 {
    fun maxProduct(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var min = nums[0]
        var max = nums[0]
        var res = nums[0]

        for (i in 1 until nums.size) {
            val tmp = max
            val n = nums[i]


            max = maxOf(max * n, maxOf(min * n, n))
            min = minOf(tmp * n, minOf(min * n, n))

            res = maxOf(res, max)
        }

        return res
    }
}

fun main() {
    println(Day6().maxProduct(intArrayOf(-2, 0, -1, 6, 7, -7, -8, 9, 100)))
}
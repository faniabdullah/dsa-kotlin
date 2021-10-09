package leetcode_study_badge.dynamic_programming

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

    fun getMaxLen(nums: IntArray): Int {
        val len: Int = nums.size
        var max = 0
        val fneg = IntArray(len + 1) // the length of longest negative product sub-array

        val fpos = IntArray(len + 1) // the length of longest positive product sub-array


        for (i in 1..len) {
            if (nums[i - 1] > 0) {
                // when positive subarray meets a positive number, the length will be increased by one at all case
                // the negative subarray will be increased only if it is not empty.
                fpos[i] = fpos[i - 1] + 1
                fneg[i] = if (fneg[i - 1] > 0) fneg[i - 1] + 1 else 0
            } else if (nums[i - 1] < 0) {
                // the positive subarray will be increased only if the previous product is negative
                // the negative subarray will be increased only if the previous product is positive
                fpos[i] = if (fneg[i - 1] > 0) fneg[i - 1] + 1 else 0
                fneg[i] = fpos[i - 1] + 1
            }
            max = maxOf(fpos[i], max)
        }
        return max
    }
}

fun main() {
    println(Day6().getMaxLen(intArrayOf(2, 8, 2, 3, 5, 4, -2, 10, 0, 1, 2, -3, 4, 5, 6, 7, 8, -9, 10)))
}
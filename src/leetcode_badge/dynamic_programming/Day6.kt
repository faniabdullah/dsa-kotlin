package leetcode_badge.dynamic_programming

class Day6 {
    fun maxProduct(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        if (nums.size == 2) {
            return maxOf(nums[0], nums[1], nums[0] * nums[1])
        }
        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        var temp = 0
        var negativeIndexedValue = 0
        for (i in 1 until nums.size) {
            if (nums[i] < 0) {
                negativeIndexedValue++
            }
        }
        for (i in 1 until nums.size) {
            if (nums[i] == 0) {
                negativeIndexedValue--
                dp[i] = 1
            } else {
                if (negativeIndexedValue % 2 == 0) {
                    dp[i] = nums[i] * dp[i - 1]
                } else {

                }
            }


            if (dp[i] == 0) dp[i] = 1
            temp = maxOf(temp, temp * nums[i], nums[i])
        }
        println(dp.contentToString())
        println(temp)
        return dp.maxOrNull() as Int
    }
}

fun main() {
    println(Day6().maxProduct(intArrayOf(-2, 0, -1, 6, 7, -7, -8, 9, 100)))
}
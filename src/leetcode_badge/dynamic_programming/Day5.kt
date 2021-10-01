package leetcode_badge.dynamic_programming

class Day5 {
    fun maxSubArray(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        dp[0] = maxOf(nums[0] + nums[nums.size - 1], nums[0])
        var maxDP = dp[0]
        for (i in 1 until nums.size) {
            if (i == nums.lastIndex) {
                dp[i] = maxOf(dp[i - 1],nums[i] + nums[i - 1])
            } else {
                dp[i] = maxOf(dp[i - 1] + nums[i] , nums[i] + nums[i - 1])
            }
            maxDP = maxOf(maxDP, dp[i], nums[i])
        }
        return maxDP

    }
}

fun main() {
    println(Day5().maxSubArray(intArrayOf(-2, 2, -2, 9)))

    println(Day5().maxSubArray(intArrayOf(-5, 3, 5)))
}
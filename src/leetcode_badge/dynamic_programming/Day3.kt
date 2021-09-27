package leetcode_badge.dynamic_programming

class Day3 {
    fun rob(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = nums[1]
        for (i in 0..nums.size - 2 step 2) {
            dp[i] = maxOf(nums[i + 2], nums[i + 3])
        }
        return nums[0]
    }
}
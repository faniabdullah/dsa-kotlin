package leetcode_study_badge.dynamic_programming

class Day4 {
    fun canJump(nums: IntArray): Boolean {
        if (nums.size == 1) return true
        if (nums[0] == 0) return false
        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        for (i in 1 until nums.size) {
            dp[i] = maxOf(dp[i - 1] - 1, nums[i])
            if (dp[i] == 0 && i != nums.lastIndex) return false
        }

        return true
    }


    fun canJumpO1space(nums: IntArray): Boolean {
        if (nums.size == 1) return true
        if (nums[0] == 0) return false
        var state = nums[0]
        for (i in 1 until nums.size) {
            state = maxOf(state - 1, nums[i])
            if (state == 0 && i != nums.lastIndex) return false
        }

        return true
    }


    fun canJump2(nums: IntArray): Int {
        if (nums.size == 1) return 0
        if (nums.size == 2) return 2

        var state = nums[0]
        var carry = 1
        var counter = 2
        for (i in 1 until nums.size) {
            state -= 1
            carry = maxOf(carry, nums[i])

            if (nums[i] + i == nums.lastIndex) {
                counter++
                break
            } else {
                if (state == 0 && nums[i] + i == nums.lastIndex) {
                    state = carry
                    counter += 2
                }
            }
        }

        return counter
    }

    fun jump(nums: IntArray): Int {
        var curr = 0
        var step = 0
        var last = 0
        for (i in nums.indices) {
            if (i > last) {
                last = curr
                step++
                if (last >= nums.size) return step
            }
            curr = maxOf(curr, i + nums[i])
        }
        return step
    }

    fun jump2(nums: IntArray): Int { // dp solution
        val n = nums.size
        val dp = Array(n) { 0 }
        dp[0] = 0
        for (i in 1 until n) {
            var curr = Integer.MAX_VALUE
            for (j in i - 1 downTo 0) {
                if (nums[j] >= i - j)
                    curr = minOf(curr, dp[j] + 1)
            }
            dp[i] = curr
        }
        return dp[n - 1]
    }

}

fun main() {
    println(Day4().canJump2(intArrayOf(1, 2, 3)))
}
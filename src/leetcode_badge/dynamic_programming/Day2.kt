package leetcode_badge.dynamic_programming

class Day2 {
    // https://leetcode.com/problems/climbing-stairs/
    // Bottom up
    fun climbStairs(n: Int): Int {
        if (n <= 3) return n
        var one = 1
        var two = 2
        var result = one + two
        for (i in 3..n) {
            result = one + two
            one = two
            two = result
        }
        return result
    }

    fun minCostClimbingStairs(cost: IntArray): Int {
        val n: Int = cost.size
        val dp = IntArray(n + 1)
        dp[n - 1] = cost[n - 1]
        for (i in n - 2 downTo 0) {
            dp[i] = cost[i] + minOf(dp[i + 1], dp[i + 2])
        }
        return minOf(dp[0], dp[1])
    }

}

fun main() {
    println(Day2().minCostClimbingStairs(intArrayOf(0, 1, 2, 2)))
}
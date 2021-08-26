package dynamicprogramming

class RobberHouse {
    fun rob(nums: IntArray): Int {
        var dp = nums.clone()

        // not consider the last
        for (i in 0..nums.size - 2) {
            for (j in i + 2..nums.size - 2) {
                dp[j] = maxOf(dp[j], nums[j] + dp[i])
            }
        }

        var maxI = 0
        dp.forEach {
            maxI = maxOf(it, maxI)
        }

        dp = nums.clone()

        for (i in 1 until nums.size) {
            for (j in i + 2 until nums.size) {
                dp[j] = maxOf(dp[j], nums[j] + dp[i])
            }
        }
        dp.forEach {
            maxI = maxOf(it, maxI)
        }

        return maxI
    }
}

fun main() {
    val robberHouse = RobberHouse()
    println(robberHouse.rob(intArrayOf(2, 3, 2, 4, 5)))
}
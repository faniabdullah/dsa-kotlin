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
        maxI = maxOf(dp.max() as Int, maxI)
        return maxI
    }

    fun rob1(nums: IntArray): Int {
        val dp = nums.clone()

        // not consider the last
        for (i in nums.indices) {
            for (j in i + 2 until nums.size) {
                dp[j] = maxOf(dp[j], nums[j] + dp[i])
                println(dp[j])
                println(i)
            }
        }
        println(dp.contentToString())

        var maxI = 0
        dp.forEach {
            maxI = maxOf(it, maxI)
        }
        return maxI
    }
}

fun main() {
    val robberHouse = RobberHouse()
    println("result " + robberHouse.rob1(intArrayOf(2, 1, 1, 2)))

}
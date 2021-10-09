package leetcode_study_badge.dynamic_programming

class Day3 {
    // https://leetcode.com/problems/house-robber/
    fun rob(nums: IntArray): Int {
        val dp = nums.clone()

        for (i in nums.indices) {
            for (j in i + 2 until nums.size) {
                dp[j] = maxOf(dp[j], nums[j] + dp[i])
            }
        }
        var maxI = 0
        dp.forEach {
            maxI = maxOf(it, maxI)
        }
        return maxI
    }

    // optimizing
    fun houseRob(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        if (nums.size == 1) return nums[0]
        if (nums.size == 2) return maxOf(nums[0], nums[1])
        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = maxOf(nums[0], nums[1])
        for (i in 2 until dp.size) {
            dp[i] = maxOf(nums[i] + dp[i - 2], dp[i - 1])
        }
        return dp[nums.size - 1]
    }

    fun houseRob2NotStabil(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        if (nums.size == 1) return nums[0]
        if (nums.size == 2) return maxOf(nums[0], nums[1])
        if (nums.size == 2) return maxOf(nums[0], nums[1], nums[3])
        val dp = IntArray(nums.size)
        dp[1] = nums[1]
        dp[2] = maxOf(nums[1], nums[2])
        for (i in 3 until nums.size) {
            dp[i] = maxOf(nums[i] + dp[i - 2], dp[i - 1])
        }
        val maxOne = dp.maxOrNull() ?: 0
        dp[nums.size - 1] = 0
        dp[0] = nums[0]
        dp[1] = nums[1]
        for (i in 2 until nums.size - 1) {
            dp[i] = maxOf(nums[i] + dp[i - 2], dp[i - 1])
        }
        val maxTwo = dp.maxOrNull() ?: 0
        return maxOf(maxOne, maxTwo)
    }

    fun houseRob2Stabil(nums: IntArray): Int {
        var dp = nums.clone()

        for (i in 0..nums.size - 2) {
            for (j in i + 2..nums.size - 2) {
                dp[j] = maxOf(dp[j], nums[j] + dp[i])
            }
        }

        var maxI = 0
        dp.forEach {
            maxI = maxOf(it, maxI)
        }

        println(dp.contentToString())
        dp = nums.clone()

        for (i in 1 until nums.size) {
            for (j in i + 2 until nums.size) {
                dp[j] = maxOf(dp[j], nums[j] + dp[i])
            }
        }
        maxI = maxOf(dp.maxOrNull() as Int, maxI)



        return maxI

    }

    fun deleteAndEarn(nums: IntArray): Int {
        val hashMap = HashMap<Int, Int>()
        nums.forEach {
            hashMap[it] = hashMap.getOrDefault(it, 0) + 1
        }
        val dp = IntArray(nums.size) { -1 }
        repeat(nums.count()) {
            val map = hashMap.clone()
            dp[it] = earn(map as HashMap<Int, Int>, nums[it])
        }
        println(dp.contentToString())
        return dp.maxOrNull() ?: 0
    }

    private fun earn(hashMap: HashMap<Int, Int>, value: Int): Int {
        hashMap.remove(value - 1)
        hashMap.remove(value + 1)
        hashMap[value] = hashMap.getOrDefault(value, 1) - 1
        if (hashMap[value] == 0) hashMap.remove(value)

        if (hashMap.isEmpty()) {
            return value
        } else {
            val firstKey = hashMap.keys.toList()[0]
            return value + earn(hashMap, firstKey)
        }
    }

    fun deleteAndEarnDP(nums: IntArray): Int {
        val count = IntArray(10001)
        for (x in nums) count[x]++
        var avoid = 0
        var using = 0
        var prev = -1

        for (k in 0..10000) if (count[k] > 0) {
            val m = Math.max(avoid, using)
            if (k - 1 != prev) {
                using = k * count[k] + m
                avoid = m
            } else {
                using = k * count[k] + avoid
                avoid = m
            }
            prev = k
        }
        return maxOf(avoid, using)
    }
}

fun main() {
    println(Day3().deleteAndEarnDP(intArrayOf(3, 4, 2)))
}
package dynamicprogramming


class LongestIncreasingSubsequence {
    fun lis(intArray: IntArray): Int {
        val sizeTable = intArray.size
        val lookupTable = IntArray(sizeTable) { 1 }

        for (i in 1 until intArray.size) {
            for (j in 0 until i) {
                if (intArray[i] > intArray[j] &&
                    lookupTable[i] < lookupTable[j] + 1
                ) {
                    lookupTable[i] = lookupTable[i] + 1
                }
            }
        }


        var counter = 0
        println(lookupTable.contentToString())
        for (i in 0 until sizeTable) {
            counter = maxOf(counter, lookupTable[i])
        }

        return counter
    }

    fun increasingTriplet(nums: IntArray): Boolean {
        var first: Int? = null
        var second: Int? = null
        nums.forEach {
            when {
                first == null -> {
                    first = nums[it]
                }
                it <= first as Int -> {
                    first = nums[it]
                }
                second == null -> {
                    second = nums[it]
                }
                it <= second as Int -> {
                    second = it
                }
                else -> {
                    return true
                }
            }
        }

        return false
    }

    fun longestIncreasingSubSequence(intArray: IntArray): Int {
        val lookupTable = IntArray(intArray.size) { 1 }

        for (i in 1 until intArray.size) {
            for (j in 0 until i) {
                if (intArray[i] > intArray[j] &&
                    lookupTable[i] < lookupTable[j] + 1
                ) {

                    lookupTable[i] = lookupTable[i] + 1
                }
            }
        }

        println(lookupTable.contentToString())

        var max = 0
        lookupTable.forEach {
            max = maxOf(max, it)
        }

        return max
    }

    private val lookupTable = IntArray(200) { -1 }
    private val nell = -1
    fun climbingStairMemoization(n: Int): Int {
        if (lookupTable[n] == nell) {
            if (n <= 1) {
                return 1
            }
            lookupTable[n] = climbingStairMemoization(n - 1) + climbingStairMemoization(n - 2)
        }

        return lookupTable[n]
    }

    fun climbingStairBottomUp(n: Int): Int {
        if (n <= 1) {
            return 1
        }
        val dp = IntArray(n + 1)
        dp[1] = 1
        dp[2] = 2
        for (i in 3..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        return dp[n]
    }
}

fun main() {
//    val lisOFArray = LongestIncreasingSubsequence()
//        .lis(intArrayOf(0, 1, 0, 3, 2, 3))
//    val lisOFArray2 = LongestIncreasingSubsequence()
//        .longestIncreasingSubSequence(intArrayOf(0, 1, 0, 3, 2, 3))
    val nameClass = LongestIncreasingSubsequence()

    println(nameClass.climbingStairMemoization(2))
    println(nameClass.climbingStairMemoization(3))
    println(nameClass.climbingStairMemoization(4))
    println(nameClass.climbingStairMemoization(5))
    println(nameClass.climbingStairMemoization(6))
    println(nameClass.climbingStairMemoization(7))
    println(nameClass.climbingStairMemoization(8))
    println(nameClass.climbingStairMemoization(9))

    println(nameClass.climbingStairMemoization(10))

    println(nameClass.climbingStairMemoization(11))
    println()
    println(55 + 89)
}
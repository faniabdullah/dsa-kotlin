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
}

fun main() {
    val lisOFArray = LongestIncreasingSubsequence()
        .lis(intArrayOf(0, 1, 0, 3, 2, 3))


    val lisOFArray2 = LongestIncreasingSubsequence()
        .longestIncreasingSubSequence(intArrayOf(0, 1, 0, 3, 2, 3))

    println(lisOFArray)
    println(lisOFArray2)
}
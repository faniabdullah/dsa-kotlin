package dynamicprogramming


class LongestIncreasingSubsequence {
    fun lis(intArray: IntArray): Int {
        val sizeTable = intArray.size
        val lookupTable = IntArray(sizeTable) { 1 }

        for (i in 1 until sizeTable) {
            for (j in 0 until i) {
                if (intArray[i] > intArray[j] && lookupTable[i] < lookupTable[j] + 1) {
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
        if (nums.size < 3) return false
        var counter = 0
        repeat(nums.count()) {
            val j = it + 1
            val k = j + 1
            if (j != nums.lastIndex) {
                if (nums[it] < nums[j] && nums[j] < nums[k]) return true
                if (nums[it] < nums[j]) counter++
                if (nums[j] < nums[k]) counter++
            }

        }
        return counter == 3
    }
}

fun main() {
    val lisOFArray = LongestIncreasingSubsequence()
        .lis(intArrayOf(0, 1, 0, 3, 2, 3))
    println(lisOFArray)
}
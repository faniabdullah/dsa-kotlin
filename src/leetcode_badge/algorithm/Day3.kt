package leetcode_badge.algorithm

class Day3 {
    fun moveZeroesGood(nums: IntArray) {
        var lastNonZeroFoundAt = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i]
            }
        }
        if (lastNonZeroFoundAt != 0) {
            for (i in lastNonZeroFoundAt until nums.size) {
                nums[i] = 0
            }
        }

    }
}

fun main() {
    val intArray = intArrayOf(
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        1,
        0,
        3,
        1,
        2,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0
    )
    println(intArray.contentToString())
}
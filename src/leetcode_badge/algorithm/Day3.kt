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

    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var l = 0
        var r = numbers.size - 1
        while (l < r) {
            val sum = numbers[l] + numbers[r]
            if (sum > target) r--
            else if (sum < target) l++
            else return intArrayOf(l + 1, r + 1)
        }
        return intArrayOf(-1, -1)
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
package leetcode_badge.data_structure


class Day5 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val newNums = IntArray(nums.size) { 1 }
        var fromStartProduct = 1
        var fromEndProduct = 1
        for (i in nums.indices) {
            newNums[i] *= fromStartProduct
            newNums[nums.size - 1 - i] *= fromEndProduct
            fromStartProduct *= nums[i]
            fromEndProduct *= nums[nums.size - 1 - i]
        }
        return newNums
    }


    fun subarraySum(nums: IntArray, k: Int): Int {
        var count = 0
        var sum = 0
        val map = HashMap<Int, Int>()
        map[0] = 1
        for (i in nums.indices) {
            sum += nums[i]
            if (map.containsKey(sum - k)) count += map[sum - k]!!
            map[sum] = map.getOrDefault(sum, 0) + 1
        }
        return count
    }

}

fun main() {
    Day5().productExceptSelf(intArrayOf(1, 2, 3, 4))
}
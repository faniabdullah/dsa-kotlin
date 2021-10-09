package leetcode_study_badge.data_structure


class Day5 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val newNums = IntArray(nums.size) { 1 }
        var startIndexValue = 1
        var endIndexValue = 1
        for (i in nums.indices) {
            newNums[i] *= startIndexValue
            newNums[nums.lastIndex - i] = endIndexValue
            startIndexValue *= nums[i]
            endIndexValue *= nums[nums.lastIndex - i]
        }

        return nums
    }


    fun subarraySum(nums: IntArray, k: Int): Int {
        val hashMap = HashMap<Int, Int>()
        var counter = 0
        var sum = 0
        for (i in nums) {
            sum += nums[i]
            if (hashMap.containsKey(sum - k)) counter += hashMap[sum - k] as Int
            hashMap[sum] = hashMap.getOrDefault(sum, 0) + 1

            counter++
        }
        return counter
    }

}

fun main() {
    Day5().productExceptSelf(intArrayOf(1, 2, 3, 4))
}
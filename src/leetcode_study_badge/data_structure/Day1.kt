package leetcode_study_badge.data_structure

import java.util.*


class Day1 {
    fun singleNumber(nums: IntArray): Int {
        /*
             https://leetcode.com/problems/single-number/

             TC: O(N)
             SC: O(1)
             // XOR of A XOR A = 0, so all duplicates will cancel each other,
            // leaving the non duplicate
         */
        var singleNumber = 0
        nums.forEach {
            singleNumber = singleNumber.xor(it)
        }
        return singleNumber

    }

    fun majorityElement(nums: IntArray): Int {
        nums.sort()
        return nums[nums.size / 2]
    }

    /*
    // https://leetcode.com/problems/3sum/
        Input: nums = [-1,0,1,2,-1,-4]
        Output: [[-1,-1,2],[-1,0,1]]
        -4 -1 -1 0 1 2


    */
    fun threeSum(nums: IntArray): List<List<Int>> {
        var res = HashSet<List<Int>>()
        nums.sort()
        for (i in 0 until nums.lastIndex-1){
            var j = i+1
            var k = nums.lastIndex
            var tmp = - nums[i]
            while (j < k){
                var sum = nums[j] + nums[k]
                when {
                    sum == tmp -> {
                        res.add(listOf(nums[i],nums[j],nums[k]))
                        j++
                        k--
                    }
                    sum < tmp ->{
                        j++
                    }
                    else ->{
                        k--
                    }
                }
            }
        }
        return res.toList()
    }
}

fun main() {
    println(Day1().singleNumber(intArrayOf(2, 2, 13, 5, 7, 8, 8, 7, 13)))
    println(Day1().threeSum(intArrayOf(-2,0,1,1,2)))
}
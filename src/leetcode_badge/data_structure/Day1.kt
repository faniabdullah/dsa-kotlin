package leetcode_badge.data_structure

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
}

fun main(){
    println(Day1().singleNumber(intArrayOf(2,2,13,5,7,8,8,7,13)))
    println(Day1().singleNumber(intArrayOf(2,2,13,5,7,8,8,7,13)))
}
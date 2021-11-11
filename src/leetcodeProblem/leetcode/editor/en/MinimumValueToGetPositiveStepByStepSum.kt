//Given an array of integers nums, you start with an initial positive value
//startValue. 
//
// In each iteration, you calculate the step by step sum of startValue plus 
//elements in nums (from left to right). 
//
// Return the minimum positive value of startValue such that the step by step 
//sum is never less than 1. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-3,2,-3,4,2]
//Output: 5
//Explanation: If you choose startValue = 4, in the third iteration your step 
//by step sum is less than 1.
//                step by step sum
//                startValue = 4 | startValue = 5 | nums
//                  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
//                  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
//                  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
//                  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
//                  (4 +2 ) = 6  | (5 +2 ) = 7    |   2
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2]
//Output: 1
//Explanation: Minimum start value should be positive. 
// 
//
// Example 3: 
//
// 
//Input: nums = [1,-2,-3]
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// -100 <= nums[i] <= 100 
// Related Topics Array Prefix Sum 👍 693 👎 181


package leetcodeProblem.leetcode.editor.en

class MinimumValueToGetPositiveStepByStepSum {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun minStartValue(nums: IntArray): Int {
            var countStartValue = if (nums[0] < 1) 1 else nums[0]
            var startValue = countStartValue
            var sumStep = 0
            var i = 0
            while (i < nums.size) {
                sumStep = startValue + nums[i]
                startValue = sumStep
                i++
                if (startValue < 1) {
                    countStartValue = startValue + 1
                    startValue = countStartValue
                    i = 0
                }
            }
            return countStartValue
        }
         // O(n) prefix sum
        fun minStarValueOn( nums: IntArray) : Int{
            var minVal = 0
            var total = 0

            // Iterate over the array and get the minimum step-by-step total.

            // Iterate over the array and get the minimum step-by-step total.
            for (num in nums) {
                total += num
                minVal = Math.min(minVal, total)
            }

            // We have to let the minimum step-by-step total equals to 1,
            // by increasing the startValue from 0 to -minVal + 1,
            // which is just the minimum startValue we want.

            // We have to let the minimum step-by-step total equals to 1,
            // by increasing the startValue from 0 to -minVal + 1,
            // which is just the minimum startValue we want.
            return -minVal + 1
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  


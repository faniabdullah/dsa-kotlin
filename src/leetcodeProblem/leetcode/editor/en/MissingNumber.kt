//Given an array nums containing n distinct numbers in the range [0, n], return
//the only number in the range that is missing from the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,0,1]
//Output: 2
//Explanation: n = 3 since there are 3 numbers, so all numbers are in the range 
//[0,3]. 2 is the missing number in the range since it does not appear in nums.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1]
//Output: 2
//Explanation: n = 2 since there are 2 numbers, so all numbers are in the range 
//[0,2]. 2 is the missing number in the range since it does not appear in nums.
// 
//
// Example 3: 
//
// 
//Input: nums = [9,6,4,2,3,5,7,0,1]
//Output: 8
//Explanation: n = 9 since there are 9 numbers, so all numbers are in the range 
//[0,9]. 8 is the missing number in the range since it does not appear in nums.
// 
//
// Example 4: 
//
// 
//Input: nums = [0]
//Output: 1
//Explanation: n = 1 since there is 1 number, so all numbers are in the range [0
//,1]. 1 is the missing number in the range since it does not appear in nums.
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 10⁴ 
// 0 <= nums[i] <= n 
// All the numbers of nums are unique. 
// 
//
// 
// Follow up: Could you implement a solution using only O(1) extra space 
//complexity and O(n) runtime complexity? 
// Related Topics Array Hash Table Math Bit Manipulation Sorting 👍 4009 👎 2686
//


package leetcodeProblem.leetcode.editor.en

class MissingNumber {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun missingNumber(nums: IntArray): Int {
            val n = nums.size
            val total = n * (n + 1) / 2
            var sum = 0
            for (num in nums) {
                sum += num
            }
            return total - sum
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  


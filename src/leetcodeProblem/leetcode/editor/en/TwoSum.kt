//Given an array of integers nums and an integer target, return indices of the
//two numbers such that they add up to target. 
//
// You may assume that each input would have exactly one solution, and you may 
//not use the same element twice. 
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
// 
//
// Example 3: 
//
// 
//Input: nums = [3,3], target = 6
//Output: [0,1]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// Only one valid answer exists. 
// 
//
// 
//Follow-up: Can you come up with an algorithm that is less than O(n²) time 
//complexity? Related Topics Array Hash Table 👍 25239 👎 820


package leetcodeProblem.leetcode.editor.en

class TwoSum {
    fun solution() {
    }

    //below code is used to auto submit to leetcode.com (using ide plugin)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun twoSum(nums: IntArray, target: Int): IntArray {
            val mutableMap = mutableMapOf<Int, Int>()
            nums.forEachIndexed { index, it ->
                if (mutableMap.containsKey(target - it)) {
                    return intArrayOf(mutableMap[target - it] ?: 0, index)
                } else {
                    mutableMap[it] = index
                }
            }
            return intArrayOf()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  


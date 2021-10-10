//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[
//k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
// Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
// Example 2: 
// Input: nums = []
//Output: []
// Example 3: 
// Input: nums = [0]
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics Array Two Pointers Sorting 👍 13427 👎 1296


package leetcodeProblem.leetcode.editor.en

class ThreeSum {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun threeSum(nums: IntArray): List<List<Int>> {
            var res = HashSet<List<Int>>()
            nums.sort()
            for (i in 0 until nums.lastIndex - 1) {
                var j = i + 1
                var k = nums.lastIndex
                val tmp = -nums[i]
                while (j < k) {
                    val sum = nums[j] + nums[k]
                    when {
                        sum == tmp -> {
                            res.add(listOf(nums[i], nums[j], nums[k]))
                            j++
                            k--
                        }
                        sum < tmp -> {
                            j++
                        }
                        else -> {
                            k--
                        }
                    }
                }
            }
            return res.toList()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  


//Given an array nums of n integers where nums[i] is in the range [1, n],
//return an array of all the integers in the range [1, n] that do not appear in nums. 
//
// 
// Example 1: 
// Input: nums = [4,3,2,7,8,2,3,1]
//Output: [5,6]
// Example 2: 
// Input: nums = [1,1]
//Output: [2]
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i] <= n 
// 
//
// 
// Follow up: Could you do it without extra space and in O(n) runtime? You may 
//assume the returned list does not count as extra space. 
// Related Topics Array Hash Table 👍 5425 👎 345


package leetcodeProblem.leetcode.editor.en

class FindAllNumbersDisappearedInAnArray {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findDisappearedNumbers(nums: IntArray): List<Int> {
            val n = nums.size
            val list = mutableListOf<Int>()
            for (i in 1..n) {
                if (!nums.contains(i)) {
                    list.add(i)
                }
            }
            return list
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  


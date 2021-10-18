//Given an integer array nums, return true if any value appears at least twice
//in the array, and return false if every element is distinct. 
//
// 
// Example 1: 
// Input: nums = [1,2,3,1]
//Output: true
// Example 2: 
// Input: nums = [1,2,3,4]
//Output: false
// Example 3: 
// Input: nums = [1,1,1,3,3,4,3,2,4,2]
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics Array Hash Table Sorting 👍 2676 👎 891


package leetcodeProblem.leetcode.editor.en

class ContainsDuplicate {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun containsDuplicate(nums: IntArray): Boolean {
            val hashMap: HashMap<Int, Int> = HashMap()
            for (i in nums.indices) {
                if (hashMap.containsKey(nums[i])) return true else hashMap[nums[i]] = 1
            }

            return false
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  


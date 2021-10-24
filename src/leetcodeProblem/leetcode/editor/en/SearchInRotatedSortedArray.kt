//There is an integer array nums sorted in ascending order (with distinct
//values). 
//
// Prior to being passed to your function, nums is possibly rotated at an 
//unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k]
//, nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For 
//example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0
//,1,2]. 
//
// Given the array nums after the possible rotation and an integer target, 
//return the index of target if it is in nums, or -1 if it is not in nums. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// All values of nums are unique. 
// nums is an ascending array that is possibly rotated. 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics Array Binary Search 👍 10540 👎 772


package leetcodeProblem.leetcode.editor.en

class SearchInRotatedSortedArray {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun search(nums: IntArray, target: Int): Int {
            var l = 0
            var r = nums.size - 1

            while (l <= r) {
                val m = l + (r - l) / 2
                if (nums[m] == target) {
                    return m
                }

                if (nums[l] <= nums[m]) {
                    if (target > nums[m] || target < nums[l]) l = m + 1 else r = m - 1
                } else {
                    if (target < nums[m] || target > nums[r]) r = m - 1 else l = m + 1
                }
            }

            return -1
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  


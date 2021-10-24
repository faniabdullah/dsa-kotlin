//Given an array of integers nums sorted in non-decreasing order, find the
//starting and ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums is a non-decreasing array. 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics Array Binary Search 👍 7758 👎 246


package leetcodeProblem.leetcode.editor.en

class FindFirstAndLastPositionOfElementInSortedArray {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun searchRange(nums: IntArray, target: Int): IntArray {
            var findFirst = -1
            var findLast = -1
            var l = 0
            var r = nums.size - 1
            while (l <= r) {
                val middle = l + (r - l) / 2
                if (nums[middle] == target) {
                    for (i in middle..nums.size) {
                        if (nums[i] != target) {
                            findLast = i - 1
                            break
                        }
                    }
                    for (i in middle downTo 0) {
                        if (nums[i] != target) {
                            findFirst = i + 1
                            break
                        }
                    }
                    break
                } else if (nums[middle] > target) {
                    r = middle - 1
                } else {
                    l = middle + 1
                }
            }
            return intArrayOf(findFirst, findLast)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {
    FindFirstAndLastPositionOfElementInSortedArray.Solution().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8)
}
  


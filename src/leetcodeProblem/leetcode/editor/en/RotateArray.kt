//Given an array, rotate the array to the right by k steps, where k is non-
//negative. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation: 
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 0 <= k <= 10⁵ 
// 
//
// 
// Follow up: 
//
// 
// Try to come up with as many solutions as you can. There are at least three 
//different ways to solve this problem. 
// Could you do it in-place with O(1) extra space? 
// 
// Related Topics Array Math Two Pointers 👍 6302 👎 1055


package leetcodeProblem.leetcode.editor.en

class RotateArray {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun rotate(nums: IntArray, k: Int) {
            var k = k
            k %= nums.size
            reverse(nums, 0, nums.size - 1)
            reverse(nums, 0, k - 1)
            reverse(nums, k, nums.size - 1)
        }

        private fun reverse(nums: IntArray, start: Int, end: Int) {
            var start = start
            var end = end
            while (start < end) {
                val temp = nums[start]
                nums[start] = nums[end]
                nums[end] = temp
                start++
                end--
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {
    println(RotateArray.Solution().rotate(intArrayOf(1, 2, 3, 4, 5, 6 , 7) , 3))
}
  


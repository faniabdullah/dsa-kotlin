//Given an integer array nums, move all 0's to the end of it while maintaining
//the relative order of the non-zero elements. 
//
// Note that you must do this in-place without making a copy of the array. 
//
// 
// Example 1: 
// Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
// Example 2: 
// Input: nums = [0]
//Output: [0]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//Follow up: Could you minimize the total number of operations done? Related 
//Topics Array Two Pointers 👍 6894 👎 193


package leetcodeProblem.leetcode.editor.en

class MoveZeroes {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun moveZeroes(nums: IntArray) {
            var lastFoundZeroes = 0
            var pointer1 = 0
            while (pointer1 < nums.size) {
                if (nums[pointer1] != 0) {
                    val temp = nums[pointer1]
                    nums[pointer1] = nums[lastFoundZeroes]
                    nums[lastFoundZeroes] = temp
                    lastFoundZeroes++
                }
                println(nums.contentToString())
                pointer1++
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {
    MoveZeroes.Solution().moveZeroes(intArrayOf(0, 1, 0, 3, 12, 0, 0, 0, 1))
}
  


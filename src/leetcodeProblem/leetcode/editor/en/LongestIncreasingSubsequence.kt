//Given an integer array nums, return the length of the longest strictly
//increasing subsequence. 
//
// A subsequence is a sequence that can be derived from an array by deleting 
//some or no elements without changing the order of the remaining elements. For 
//example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the 
//length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,0,3,2,3]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time 
//complexity? 
// Related Topics Array Binary Search Dynamic Programming 👍 9353 👎 192


package leetcodeProblem.leetcode.editor.en

class LongestIncreasingSubsequence {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun lengthOfLIS(nums: IntArray): Int {
            val dp = IntArray(nums.size) { 1 }
            var max = Int.MIN_VALUE
            for (i in 1 until nums.size) {
                for (j in 0..i) {
                    if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1
                    }
                }
                max = maxOf(max, dp[i])
            }
            println(dp.contentToString())
            return max
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {
    println(LongestIncreasingSubsequence.Solution().lengthOfLIS(intArrayOf(10,9,2,5,3,7,101,18)))
}
  


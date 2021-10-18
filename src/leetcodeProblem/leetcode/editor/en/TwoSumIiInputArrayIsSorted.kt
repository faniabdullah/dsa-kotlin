//Given a 1-indexed array of integers numbers that is already sorted in non-
//decreasing order, find two numbers such that they add up to a specific target 
//number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= first 
//< second <= numbers.length. 
//
// Return the indices of the two numbers, index1 and index2, as an integer 
//array [index1, index2] of length 2. 
//
// The tests are generated such that there is exactly one solution. You may not 
//use the same element twice. 
//
// 
// Example 1: 
//
// 
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
// 
//
// Example 2: 
//
// 
//Input: numbers = [2,3,4], target = 6
//Output: [1,3]
//Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3.
// 
//
// Example 3: 
//
// 
//Input: numbers = [-1,0], target = -1
//Output: [1,2]
//Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2.
// 
//
// 
// Constraints: 
//
// 
// 2 <= numbers.length <= 3 * 10⁴ 
// -1000 <= numbers[i] <= 1000 
// numbers is sorted in non-decreasing order. 
// -1000 <= target <= 1000 
// The tests are generated such that there is exactly one solution. 
// 
// Related Topics Array Two Pointers Binary Search 👍 3691 👎 806


package leetcodeProblem.leetcode.editor.en

class TwoSumIiInputArrayIsSorted {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun twoSum(numbers: IntArray, target: Int): IntArray {
            // 2,3,5,6,7,11,15 , 18 , 19 = 9
            var left = 0
            var right = numbers.size - 1
            while (left < right) {
                val sum = numbers[left] + numbers[right]
                if (sum > target) right--
                else if (sum < target) left++
                else return intArrayOf(left + 1, right + 1)
            }
            return intArrayOf(-1, -1)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  









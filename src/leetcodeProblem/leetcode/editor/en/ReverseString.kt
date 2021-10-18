//Write a function that reverses a string. The input string is given as an
//array of characters s. 
//
// 
// Example 1: 
// Input: s = ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]
// Example 2: 
// Input: s = ["H","a","n","n","a","h"]
//Output: ["h","a","n","n","a","H"]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is a printable ascii character. 
// 
//
// 
// Follow up: Do not allocate extra space for another array. You must do this 
//by modifying the input array in-place with O(1) extra memory. 
// Related Topics Two Pointers String Recursion 👍 3178 👎 839


package leetcodeProblem.leetcode.editor.en

class ReverseString {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun reverseString(s: CharArray): Unit {
            var left = 0
            var right = s.size - 1
            while (left < right) {
                val temp = s[left]
                s[left] = s[right]
                s[right] = temp
                left++
                right--
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  


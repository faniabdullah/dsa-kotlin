//Given two integers a and b, return any string s such that:
//
// 
// s has length a + b and contains exactly a 'a' letters, and exactly b 'b' 
//letters, 
// The substring 'aaa' does not occur in s, and 
// The substring 'bbb' does not occur in s. 
// 
//
// 
// Example 1: 
//
// 
//Input: a = 1, b = 2
//Output: "abb"
//Explanation: "abb", "bab" and "bba" are all correct answers.
// 
//
// Example 2: 
//
// 
//Input: a = 4, b = 1
//Output: "aabaa"
// 
//
// 
// Constraints: 
//
// 
// 0 <= a, b <= 100 
// It is guaranteed such an s exists for the given a and b. 
// 
// Related Topics String Greedy 👍 392 👎 307


package leetcodeProblem.leetcode.editor.en

class StringWithoutAaaOrBbb {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun strWithout3a3b(A: Int, B: Int): String {
            var A = A
            var B = B
            val ans = StringBuilder()
            while (A > 0 || B > 0) {
                var writeA = false
                val L = ans.length
                if (L >= 2 && ans[L - 1] == ans[L - 2]) {
                    if (ans[L - 1] == 'b') writeA = true
                } else {
                    if (A >= B) writeA = true
                }
                if (writeA) {
                    A--
                    ans.append('a')
                } else {
                    B--
                    ans.append('b')
                }
            }
            return ans.toString()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  


//Given a string s, reverse the order of characters in each word within a
//sentence while still preserving whitespace and initial word order. 
//
// 
// Example 1: 
// Input: s = "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"
// Example 2: 
// Input: s = "God Ding"
//Output: "doG gniD"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// s contains printable ASCII characters. 
// s does not contain any leading or trailing spaces. 
// There is at least one word in s. 
// All the words in s are separated by a single space. 
// 
// Related Topics Two Pointers String 👍 1910 👎 121


package leetcodeProblem.leetcode.editor.en

class ReverseWordsInAStringIii {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun reverseWords(s: String): String {
            var s = s.toCharArray()
            var left = 0
            var right = 1
            while (right < s.size) {

                if (s[right].isWhitespace() && !s[right - 1].isWhitespace() && right > 1 || right == s.lastIndex && right > 1) {
                    var tempLeft = left
                    var tempRight = right - 1
                    while (tempLeft < tempRight) {
                        val temp = s[tempRight]
                        s[tempRight] = s[tempLeft]
                        s[tempLeft] = temp
                        tempLeft++
                        tempRight--
                    }
                    left = right + 1
                    right++
                } else if (s[right].isWhitespace() && s[right - 1].isWhitespace()) {
                    left = right + 1
                    right++
                } else {
                    right++
                }
            }
            return String(s)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {
    ReverseWordsInAStringIii.Solution().reverseWords("Let's take LeetCode contest")
}
  


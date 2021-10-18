//Given a string s, find the length of the longest substring without repeating
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// Example 4: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table String Sliding Window 👍 18261 👎 839


package leetcodeProblem.leetcode.editor.en

class LongestSubstringWithoutRepeatingCharacters {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun lengthOfLongestSubstring(s: String): Int {
            var longest = 0
            var currentRunStartIndex = 0
            val lastSeenIndices = IntArray(128)
            s.toCharArray().forEachIndexed { index, char ->
                with(char.toInt()) {
                    currentRunStartIndex = maxOf(lastSeenIndices[this], currentRunStartIndex)
                    longest = maxOf(longest, index - currentRunStartIndex + 1)
                    lastSeenIndices[this] = index + 1
                }
            }
            return longest
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {

}
  


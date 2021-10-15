//Given two strings s and t of lengths m and n respectively, return the minimum
//window substring of s such that every character in t (including duplicates) is 
//included in the window. If there is no such substring, return the empty string 
//"". 
//
// The testcases will be generated such that the answer is unique. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' 
//from string t.
// 
//
// Example 2: 
//
// 
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
// 
//
// Example 3: 
//
// 
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
// 
//
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
//Follow up: Could you find an algorithm that runs in O(m + n) time? Related 
//Topics Hash Table String Sliding Window 👍 8292 👎 493


package leetcodeProblem.leetcode.editor.en


class MinimumWindowSubstring {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        fun minWindow(s: String, t: String): String {
            if (s.isEmpty() || t.isEmpty()) {
                return ""
            }
            val dictT: MutableMap<Char, Int> = HashMap()
            for (i in t.indices) {
                val count = dictT.getOrDefault(t[i], 0)
                dictT[t[i]] = count + 1
            }
            val required = dictT.size
            var l = 0
            var r = 0
            var formed = 0
            val windowCounts: MutableMap<Char, Int> = HashMap()
            val ans = intArrayOf(-1, 0, 0)
            while (r < s.length) {
                var c = s[r]
                val count = windowCounts.getOrDefault(c, 0)
                windowCounts[c] = count + 1
                if (dictT.containsKey(c) && windowCounts[c]!!.toInt() == dictT[c]!!.toInt()) {
                    formed++
                }
                while (l <= r && formed == required) {
                    c = s[l]
                    if (ans[0] == -1 || r - l + 1 < ans[0]) {
                        ans[0] = r - l + 1
                        ans[1] = l
                        ans[2] = r
                    }
                    windowCounts[c] = windowCounts[c]!! - 1
                    if (dictT.containsKey(c) && windowCounts[c]!!.toInt() < dictT[c]!!.toInt()) {
                        formed--
                    }

                    l++
                }
                r++
            }
            return if (ans[0] == -1) "" else s.substring(ans[1], ans[2] + 1)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

fun main() {
    println(MinimumWindowSubstring.Solution().minWindow("acbbaca", "aba"))
}
  




















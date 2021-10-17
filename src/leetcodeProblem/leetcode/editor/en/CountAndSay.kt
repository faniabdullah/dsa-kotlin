//The count-and-say sequence is a sequence of digit strings defined by the
//recursive formula: 
//
// 
// countAndSay(1) = "1" 
// countAndSay(n) is the way you would "say" the digit string from countAndSay(
//n-1), which is then converted into a different digit string. 
// 
//
// To determine how you "say" a digit string, split it into the minimal number 
//of groups so that each group is a contiguous section all of the same character. 
//Then for each group, say the number of characters, then say the character. To 
//convert the saying into a digit string, replace the counts with a number and 
//concatenate every saying. 
//
// For example, the saying and conversion for digit string "3322251": 
//
// Given a positive integer n, return the nᵗʰ term of the count-and-say 
//sequence. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: "1"
//Explanation: This is the base case.
// 
//
// Example 2: 
//
// 
//Input: n = 4
//Output: "1211"
//Explanation:
//countAndSay(1) = "1"
//countAndSay(2) = say "1" = one 1 = "11"
//countAndSay(3) = say "11" = two 1's = "21"
//countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 30 
// 
// Related Topics String 👍 895 👎 2576


package leetcodeProblem.leetcode.editor.en

class CountAndSay {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun countAndSay(n: Int): String {
            if (n == 1) {
                return "1"
            }
            if (n == 2) return "11"
            if (n == 3) return "21"
            if (n == 4) return "1211"
            return countAndSayOperation(4, n, "1211")
        }

        private fun countAndSayOperation(position: Int, n: Int, s: String): String {
            if (position == n) return s
            var result = ""
            var count = 0
            var say = 0
            var lastIndexedValue: Char? = s[0]
            for (i in s.indices) {
                if (lastIndexedValue == s[i]) {
                    count++
                } else {
                    say = s[i - 1] - '0'
                    result = "$result$count$say"
                    count = 1
                    lastIndexedValue = s[i]
                }
            }

            if (count >= 1) {
                say = s[s.lastIndex] - '0'
                result = "$result$count$say"
            }

            return countAndSayOperation(position + 1, n, result)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {
    for (i in 1..30) {
        println(CountAndSay.Solution().countAndSay(i))
    }
}
  


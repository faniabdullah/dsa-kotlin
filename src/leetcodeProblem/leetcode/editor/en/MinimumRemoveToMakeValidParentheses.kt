//Given a string s of '(' , ')' and lowercase English characters.
//
// Your task is to remove the minimum number of parentheses ( '(' or ')', in 
//any positions ) so that the resulting parentheses string is valid and return any 
//valid string. 
//
// Formally, a parentheses string is valid if and only if: 
//
// 
// It is the empty string, contains only lowercase characters, or 
// It can be written as AB (A concatenated with B), where A and B are valid 
//strings, or 
// It can be written as (A), where A is a valid string. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "lee(t(c)o)de)"
//Output: "lee(t(c)o)de"
//Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
// 
//
// Example 2: 
//
// 
//Input: s = "a)b(c)d"
//Output: "ab(c)d"
// 
//
// Example 3: 
//
// 
//Input: s = "))(("
//Output: ""
//Explanation: An empty string is also valid.
// 
//
// Example 4: 
//
// 
//Input: s = "(a(b(c)d)"
//Output: "a(b(c)d)"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is either'(' , ')', or lowercase English letter. 
// 
// Related Topics String Stack 👍 2786 👎 60


package leetcodeProblem.leetcode.editor.en


import java.util.*
import kotlin.text.StringBuilder

class MinimumRemoveToMakeValidParentheses {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun minRemoveToMakeValid(s: String): String {
            val arr = s.toCharArray()
            val result = StringBuilder()
            val stack = Stack<Int>()

            for (i in s.indices) {
                val char = s[i]
                if (char == '(') {
                    stack.push(i)
                } else if (char == ')') {
                    if (stack.isNotEmpty()) stack.pop()
                    else arr[i] = '~'
                }
            }

            while (stack.isNotEmpty()) {
                arr[stack.pop()] = '~'
            }

            arr.forEach { if (it != '~') result.append(it) }

            return result.toString()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  


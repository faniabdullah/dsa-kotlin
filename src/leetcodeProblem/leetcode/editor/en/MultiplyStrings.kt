//Given two non-negative integers num1 and num2 represented as strings, return
//the product of num1 and num2, also represented as a string. 
//
// Note: You must not use any built-in BigInteger library or convert the inputs 
//to integer directly. 
//
// 
// Example 1: 
// Input: num1 = "2", num2 = "3"
//Output: "6"
// Example 2: 
// Input: num1 = "123", num2 = "456"
//Output: "56088"
// 
// 
// Constraints: 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 and num2 consist of digits only. 
// Both num1 and num2 do not contain any leading zero, except the number 0 
//itself. 
// 
// Related Topics Math String Simulation 👍 3398 👎 1336


package leetcodeProblem.leetcode.editor.en

class MultiplyStrings {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun multiply(num1: String, num2: String): String {
            if ("0" == num1 || "0" == num2)
                return "0"

            val list = Array(num1.length + num2.length - 1){0}

            for (i in num1.length - 1 downTo 0) {
                for (j in num2.length - 1 downTo 0) {
                    list[i + j] += (num1[i] - '0') * (num2[j] - '0')
                }
            }

            for (i in list.size - 1 downTo 1) {
                list[i - 1] += list[i] / 10
                list[i] %= 10
            }

            val builder = StringBuilder()
            list.forEach {
                builder.append(it)
            }

            return builder.toString()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  


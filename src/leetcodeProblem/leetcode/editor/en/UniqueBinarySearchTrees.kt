//Given an integer n, return the number of structurally unique BST's (binary
//search trees) which has exactly n nodes of unique values from 1 to n. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 19 
// 
// Related Topics Math Dynamic Programming Tree Binary Search Tree Binary Tree ?
//? 6049 👎 232


package leetcodeProblem.leetcode.editor.en

class UniqueBinarySearchTrees {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun numTrees(n: Int): Int {
            var C: Long = 1
            for (i in 0 until n) {
                C = C * 2 * (2 * i + 1) / (i + 2)
            }
            return C.toInt()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  


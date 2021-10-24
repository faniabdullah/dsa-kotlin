//Given an integer numRows, return the first numRows of Pascal's triangle.
//
// In Pascal's triangle, each number is the sum of the two numbers directly 
//above it as shown: 
//
// 
// Example 1: 
// Input: numRows = 5
//Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Example 2: 
// Input: numRows = 1
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics Array Dynamic Programming 👍 3891 👎 170


package leetcodeProblem.leetcode.editor.en

class PascalsTriangle {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun generate(numRows: Int): List<List<Int>> {
            val result = mutableListOf<MutableList<Int>>()
            result.add(mutableListOf(1))
            if (numRows == 1) return result.toList()
            result.add(mutableListOf(1, 1))
            if (numRows == 2) return result.toList()


            for (i in 2 until numRows) {
                val temp = mutableListOf<Int>()
                for (j in 0..i) {
                    when (j) {
                        0 -> temp.add(1)
                        i -> temp.add(1)
                        else -> temp.add(result[i - 1][j] + result[i - 1][j - 1])
                    }
                }
                result.add(temp)
            }
            return result.toList()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {
    val result = PascalsTriangle.Solution().generate(5)
    result.forEach {
        println(it)
    }
}
  


























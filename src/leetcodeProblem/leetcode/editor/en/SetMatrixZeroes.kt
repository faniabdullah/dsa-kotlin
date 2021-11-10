//Given an m x n integer matrix matrix, if an element is 0, set its entire row
//and column to 0's, and return the matrix. 
//
// You must do it in place. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//Output: [[1,0,1],[0,0,0],[1,0,1]]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[0].length 
// 1 <= m, n <= 200 
// -2³¹ <= matrix[i][j] <= 2³¹ - 1 
// 
//
// 
// Follow up: 
//
// 
// A straightforward solution using O(mn) space is probably a bad idea. 
// A simple improvement uses O(m + n) space, but still not the best solution. 
// Could you devise a constant space solution? 
// 
// Related Topics Array Hash Table Matrix 👍 5009 👎 434


package leetcodeProblem.leetcode.editor.en


class SetMatrixZeroes {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    internal class Solution {
        fun setZeroes(matrix: Array<IntArray>) {
            val R = matrix.size
            val C: Int = matrix[0].size
            val rows: MutableSet<Int> = HashSet()
            val cols: MutableSet<Int> = HashSet()


            for (i in 0 until R) {
                for (j in 0 until C) {
                    if (matrix[i][j] == 0) {
                        rows.add(i)
                        cols.add(j)
                    }
                }
            }


            for (i in 0 until R) {
                for (j in 0 until C) {
                    if (rows.contains(i) || cols.contains(j)) {
                        matrix[i][j] = 0
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}


















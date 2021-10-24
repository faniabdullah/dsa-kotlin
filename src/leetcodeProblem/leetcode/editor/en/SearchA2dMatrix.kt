//Write an efficient algorithm that searches for a value in an m x n matrix.
//This matrix has the following properties: 
//
// 
// Integers in each row are sorted from left to right. 
// The first integer of each row is greater than the last integer of the 
//previous row. 
// 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
// Related Topics Array Binary Search Matrix 👍 4843 👎 223


package leetcodeProblem.leetcode.editor.en

class SearchA2dMatrix {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
            for (i in matrix.indices) {
                if (matrix[i][matrix.size - 1] == target) {
                    return true
                }
                if (matrix[i][matrix.size] > target) {
                    var rightSearch = matrix[i].size - 1
                    var leftSearch = 0
                    while (leftSearch <= rightSearch) {
                        val middleSearch = leftSearch + (rightSearch - leftSearch) / 2
                        val valueNow = matrix[i][middleSearch]
                        if (valueNow == target) {
                            return true
                        } else if (valueNow > target) {
                            rightSearch = middleSearch - 1
                        } else {
                            leftSearch = middleSearch + 1
                        }
                    }
                    break
                }
            }

            return false
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  


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
// Related Topics Array Hash Table Matrix 👍 4840 👎 424


package leetcodeProblem.leetcode.editor.en

class SetMatrixZeroes {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun searchChannelMinimum(mutableMap: MutableMap<String, IntArray>, target: Int): String {
            var result = ""
            var indexMin = Int.MAX_VALUE
            mutableMap.forEach { (name, data) ->
                if (data.size < indexMin && data.contains(target)) {
                    result = name
                    indexMin = data.size
                }
            }
            return result
        }

        fun searchDepartmentMinimum(mutableMap: MutableMap<String, IntArray>, target: Int): List<String> {
            var result = mutableListOf<String>()
            mutableMap.forEach { (name, data) ->
                if (data.contains(target)) {
                    result.add(name)
                }
            }
            return result
        }

        fun sortingDepartment(mutableMap: MutableMap<String, IntArray>, target: Int): List<List<String>> {
            val result = mutableListOf<List<String>>()
            val hashMap = hashMapOf<Int, MutableList<String>>()
            mutableMap.forEach { (name, data) ->
                if (hashMap.containsKey(data.size)) {
                    hashMap[data.size]?.add(name)
                } else {
                    hashMap[data.size] = mutableListOf()
                }
            }
            hashMap.keys.sorted().forEach {
                hashMap[it]?.let { it1 -> result.add(it1) }
            }
            return result
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {
    println(
        SetMatrixZeroes.Solution().searchChannelMinimum(
            mutableMapOf(
                "general" to intArrayOf(1, 2, 4, 5, 6, 7, 8, 9, 10, 11),
                "zenius" to intArrayOf(1, 2, 4, 5, 6, 7, 8, 9, 10, 11),
                "ruangguru" to intArrayOf(1, 12, 2),
                "colearn" to intArrayOf(1)

            ), 5
        )
    )

}
  


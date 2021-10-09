//Given an m x n grid of characters board and a string word, return true if
//word exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cells, 
//where adjacent cells are horizontally or vertically neighboring. The same letter 
//cell may not be used more than once. 
//
// 
// Example 1: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCCED"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "SEE"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCB"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board and word consists of only lowercase and uppercase English letters. 
// 
//
// 
// Follow up: Could you use search pruning to make your solution faster with a 
//larger board? 
// Related Topics Array Backtracking Matrix 👍 7371 👎 280


package leetcodeProblem.leetcode.editor.en

class WordSearch {
    fun solution() {
    }

    //below code is used to auto submit to leetcode.com (using ide plugin)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun exist(board: Array<CharArray>, word: String): Boolean {
            val m = board.size;
            val n = board[0].size
            val dx = intArrayOf(1, -1, 0, 0)
            val dy = intArrayOf(0, 0, 1, -1)
            val seen = Array(m) { BooleanArray(n) }

            fun dfs(x: Int, y: Int, start: Int): Boolean {
                if (start == word.length) return true

                if (x < 0 || x >= m || y < 0 || y >= n ||
                    seen[x][y] || board[x][y] != word[start]
                ) {
                    return false
                }

                seen[x][y] = true
                for (i in 0..3) {
                    if (dfs(x + dx[i], y + dy[i], start + 1)) {
                        return true
                    }
                }
                seen[x][y] = false

                return false
            }

            for (i in 0..m - 1) {
                for (j in 0..n - 1) {
                    if (board[i][j] == word[0]) {
                        if (dfs(i, j, 0)) {
                            return true
                        }
                    }
                }
            }

            return false
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  


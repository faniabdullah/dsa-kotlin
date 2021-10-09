//Given an m x n board of characters and a list of strings words, return all
//words on the board. 
//
// Each word must be constructed from letters of sequentially adjacent cells, 
//where adjacent cells are horizontally or vertically neighboring. The same letter 
//cell may not be used more than once in a word. 
//
// 
// Example 1: 
//
// 
//Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i",
//"f","l","v"]], words = ["oath","pea","eat","rain"]
//Output: ["eat","oath"]
// 
//
// Example 2: 
//
// 
//Input: board = [["a","b"],["c","d"]], words = ["abcb"]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] is a lowercase English letter. 
// 1 <= words.length <= 3 * 10⁴ 
// 1 <= words[i].length <= 10 
// words[i] consists of lowercase English letters. 
// All the strings of words are unique. 
// 
// Related Topics Array String Backtracking Trie Matrix 👍 4722 👎 162


package leetcode_daily_chalange

class WordSearchIi {

    class Solution {
        private val ans = mutableSetOf<String>()
        private val root = Word('#')
        lateinit var board: Array<CharArray>

        fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
            if (board.isEmpty() || board[0].isEmpty()) return ans.toList()
            this.board = board
            for (word in words) {
                var parent = root
                for (char in word) {
                    var node = parent.map[char]
                    if (node == null) {
                        node = Word(char)
                        parent.map[char] = node
                    }
                    parent = node
                }
                parent.isCompleted = true
            }
            val builder = StringBuilder()
            for (x in board.indices) {
                for (y in board[0].indices) {
                    val curChar = board[x][y]
                    builder.clear()
                    getWords(x, y, root.map[curChar], builder)
                }
            }
            return ans.toList()
        }

        private fun getWords(x: Int, y: Int, node: Word?, builder: StringBuilder) {
            if (node == null || board[x][y] == '$') return
            val curChar = board[x][y]
            board[x][y] = '$'
            builder.append(curChar)
            if (node.isCompleted) ans.add(builder.toString())

            if (isValid(x + 1, y))
                getWords(x + 1, y, node.map[board[x + 1][y]], builder)
            if (isValid(x - 1, y))
                getWords(x - 1, y, node.map[board[x - 1][y]], builder)
            if (isValid(x, y + 1))
                getWords(x, y + 1, node.map[board[x][y + 1]], builder)
            if (isValid(x, y - 1))
                getWords(x, y - 1, node.map[board[x][y - 1]], builder)

            builder.deleteCharAt(builder.lastIndex)

            board[x][y] = curChar
        }

        private fun isValid(x: Int, y: Int): Boolean {
            return x >= 0 && y >= 0 && x < board.size && y < board[0].size
        }
    }

    data class Word(val char: Char) {
        val map = mutableMapOf<Char, Word>()
        var isCompleted = false
    }

}

fun main() {}
  


package leetcode_daily_chalange

class WordSearch {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        if (word.length > board.size * board[0].size) return false
        var result: Boolean
        repeat(board.count()) { i ->
            repeat(board[i].count()) { j ->
                if (board[i][j] == word[0]) {
                    result = helpWord(board, word, i, j, 0, mutableListOf())
                    if (result) {
                        return result
                    }
                }
            }
        }

        return false
    }

    private fun helpWord(
        board: Array<CharArray>,
        word: String,
        i: Int,
        j: Int,
        x: Int,
        list: MutableList<String>
    ): Boolean {
        if (x + 1 > word.length - 1) {
            println("he")
            return true
        }
        var result = false
        if (i + 1 <= board.lastIndex && board[i + 1][j] == word[x + 1] && !list.contains("${i + 1}$j")) { // down
            list.add("${i + 1}$j")
            result = helpWord(board, word, i + 1, j, x + 1, list) // 1 hide up
            if (result) return true else list.remove("${i + 1}$j")
        }

        if (i - 1 >= 0 && board[i - 1][j] == word[x + 1] && !list.contains("${i - 1}$j")) { // up
            list.add("${i - 1}$j")
            result = helpWord(board, word, i - 1, j, x + 1, list) // 2 hide down
            if (result) return true else list.remove("${i - 1}$j")
        }

        if (j + 1 <= board[i].lastIndex && board[i][j + 1] == word[x + 1] && !list.contains("${i}${j + 1}")) { // right
            list.add("${i}${j + 1}")
            result = helpWord(board, word, i, j + 1, x + 1, list) // 3 hide left
            if (result) return true else list.remove("${i}${j + 1}")
        }

        if (j - 1 >= 0 && board[i][j - 1] == word[x + 1] && !list.contains("${i}${j - 1}")) { // left
            list.add("${i}${j - 1}")
            result = helpWord(board, word, i, j - 1, x + 1, list) // 4 hide right
            if (result) return true else list.remove("${i}${j - 1}")
        }

        return result
    }

}

fun main() {
    println(
        WordSearch().exist(
            arrayOf(
                charArrayOf('a', 'a', 'b', 'a', 'a', 'b'),
                charArrayOf('a', 'a', 'b', 'b', 'b', 'a'),
                charArrayOf('a', 'a', 'a', 'a', 'b', 'a'),
                charArrayOf('b', 'a', 'b', 'b', 'a', 'b'),
                charArrayOf('a', 'b', 'b', 'a', 'b', 'a'),
                charArrayOf('b', 'a', 'a', 'a', 'a', 'b')

            ), "bbbaabbbbbab"
        )
    )

    println(
        WordSearch().exist(
            arrayOf(
                charArrayOf('a')
            ), "a"
        )
    )

}
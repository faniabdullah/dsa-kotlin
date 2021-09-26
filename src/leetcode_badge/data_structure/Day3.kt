package leetcode_badge.data_structure


class Day3 {
    fun getRowBrute(rowIndex: Int): List<Int> {
        val dp = Array(rowIndex + 1) { IntArray(rowIndex + 1) }
        dp[0][0] = 1
        dp[rowIndex][rowIndex] = 1
        var indexRow = 1
        while (indexRow <= rowIndex) {
            repeat(rowIndex) { indexColumn ->
                if (indexColumn == 0) {
                    dp[indexRow][0] = 1
                    return@repeat
                }
                if (indexColumn > indexRow) {
                    return@repeat
                }
                if (indexColumn == indexRow) {
                    dp[indexRow][indexColumn] = 1
                } else {
                    dp[indexRow][indexColumn] = dp[indexRow - 1][indexColumn] + dp[indexRow - 1][indexColumn - 1]
                }
            }
            indexRow++
        }
        return dp[rowIndex].toList()
    }

    fun getRow(rowIndex: Int): List<Int> {
        //base case: first row
        if (rowIndex == 0) {
            val list: ArrayList<Int> = ArrayList()
            list.add(1)
            return list
        }

        //Recursion to calculate each row
        val aboveRow: List<Int> = getRow(rowIndex - 1)
        //When get the list of above row, start to calculate current row
        val row: MutableList<Int> = ArrayList()

        //Calculate each number in current row
        for (i in 0 until rowIndex + 1) {
            var left = 0
            var right = 0
            if (i > 0) left = aboveRow[i - 1]
            if (i < rowIndex) right = aboveRow[i] //Be careful of the index: should be i-1 & i
            row.add(left + right)
        }
        return row
    }

    fun rotate(matrix: Array<IntArray>): Unit {
        val n: Int = matrix.size
        for (i in 0 until (n + 1) / 2) {
            for (j in 0 until n / 2) {
                val temp = matrix[n - 1 - j][i]
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1]
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i]
                matrix[j][n - 1 - i] = matrix[i][j]
                matrix[i][j] = temp
            }
        }
    }

    // https://leetcode.com/problems/spiral-matrix-ii/
    fun generateMatrix(n: Int): Array<IntArray> {
        val array = Array(n) { IntArray(n) { -1 } }
        var state = 0
        var col = 0
        var row = -1
        val filled = n * n

        for (i in 1..filled) {
            when (state) {
                0 -> { // right
                    row++
                    array[col][row] = i
                    if (row == n - 1 || array[col][row + 1] != -1) {
                        state = 1
                    }
                }
                1 -> { // down
                    col++
                    array[col][row] = i
                    if (col == n - 1 || array[col + 1][row] != -1) {
                        state = 2
                    }
                }
                2 -> { // left
                    row--
                    array[col][row] = i
                    if (row == 0 || array[col][row - 1] != -1) {
                        state = 3
                    }
                }
                3 -> { // top
                    col--
                    array[col][row] = i
                    if (col == 0 || array[col - 1][row] != -1) {
                        state = 0
                    }
                }
            }
        }
        return array
    }

}

fun main() {
    val result = Day3().generateMatrix(6)
    var matrix =
        arrayOf(
            intArrayOf(1, 2, 3, 4, 50),
            intArrayOf(5, 6, 7, 8, 51),
            intArrayOf(9, 10, 11, 12, 52),
            intArrayOf(13, 14, 15, 16, 53),
            intArrayOf(17, 18, 19, 20, 54)
        )

    Day3().rotate(matrix)
    println("After rotate")
    result.forEach {
        println(it.contentToString())
    }
}
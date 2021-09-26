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


}

fun main() {
    val result = Day3().getRow(10)
    println(result)
}
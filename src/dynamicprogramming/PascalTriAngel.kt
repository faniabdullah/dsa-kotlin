package dynamicprogramming

class PascalTriAngel {
    fun getRow(numRows: Int): List<Int> {
        val result = mutableListOf<MutableList<Int>>()
        result.add(mutableListOf(1))
        if (numRows == 1) return listOf(1, 1)
        result.add(mutableListOf(1, 1))
        if (numRows == 2) return listOf(1, 2, 1)

        for (i in 2..numRows) {
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
        return result[numRows].toList()
    }
}
package dynamicprogramming

class EditDistance {
    fun minDistance(word1: String, word2: String): Int {

        val dp = Array(word1.length + 1) { IntArray(word2.length + 1) { 0 } }
        for (i in dp.indices) {
            for (j in dp[i].indices) {
                when {
                    i == 0 -> {
                        dp[i][j] = j
                    }
                    j == 0 -> {
                        dp[i][j] = i
                    }
                    word1[i - 1] == word2[j - 1] -> {
                      dp[i][j] = dp[i - 1][j - 1]
                    }
                    else -> {
                        dp[i][j] = minOf(dp[i][j - 1], dp[i - 1][j - 1], dp[i - 1][j]) + 1
                    }
                }
            }
        }

        repeat(dp.count()) {
            println(dp[it].contentToString())
        }

        return dp[dp.size - 1][dp[0].size - 1]
    }

    fun editDistDP(
        str1: String, str2: String, m: Int,
        n: Int
    ): Int { // Create a table to store results of subproblems
        val dp = Array(m + 1) { IntArray(n + 1) }
        // Fill d[][] in bottom up manner
        for (i in 0..m) {
            for (j in 0..n) {
                when {
                    i == 0 -> dp[i][j] = j
                    j == 0 -> dp[i][j] = i
                    str1[i - 1] == str2[j - 1] -> dp[i][j] = dp[i - 1][j - 1]
                    else -> dp[i][j] = (1 + minOf(
                        dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]
                    ))
                }
            }
        }

        repeat(dp.count()) {
            println(dp[it].contentToString())
        }
        return dp[m][n]
    }
}

fun main() {
    val str1 = "zoologicoarchaeologist"
    val str2 = "zoogeologist"
    val result = EditDistance().minDistance(str1, str2)
    println("result 2")
    val result2 = EditDistance().editDistDP(str1, str2, str1.length, str2.length)

}
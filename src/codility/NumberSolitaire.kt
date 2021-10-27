package codility

class NumberSolitaire {
    fun solution(A: IntArray): Int {
        val lens = A.size
        val dp = IntArray(6)
        for (i in 0..5) {
            dp[i] = A[0]
        }
        for (i in 1 until lens) {
            dp[i % 6] = getMax6(dp) + A[i]
            println(dp.contentToString())
        }
        return dp[(lens - 1) % 6]
    }

    private fun getMax6(dp: IntArray): Int {
        var max = dp[0]
        for (i in 1 until dp.size) {
            max = maxOf(max, dp[i])
        }
        return max
    }
}

fun main() {
    println(NumberSolitaire().solution(intArrayOf(1, 2, 3, 4, 5, 6, 7, -8, -9)))
}
























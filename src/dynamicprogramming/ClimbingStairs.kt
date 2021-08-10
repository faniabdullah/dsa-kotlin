package dynamicprogramming

class ClimbingStairs {
    fun climbingStairs() {

    }

    private val dp = IntArray(10000) { -1 }
    fun knappSnackProblem(n: Int): Int {
        // 1 , 3 , 5
        if (n < 0) return 0
        if (n == 0) return 1
        if (dp[n] != -1) {
            return dp[n]
        }
        dp[n] = knappSnackProblem(n - 1) + knappSnackProblem(n - 3) + knappSnackProblem(n - 5)
        return dp[n]
    }
}

fun main() {
    val result = ClimbingStairs().knappSnackProblem(9)
    println(result)
}
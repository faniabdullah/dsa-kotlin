package dynamicprogramming

class ClimbingStairs {
    fun climbingStairs(n: Int): Int {
        if (n <= 3) return n
        var one = 1
        var two = 2
        var result = one + two
        for (i in 3..n) {
            result = one + two
            one = two
            two = result
        }
        return result
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
package compotitiveProgramming.hard

class LongestValidParenthesis {

    fun longestValidParentheses(s: String): Int {
        var maxans = 0
        val dp = IntArray(s.length)
        for (i in 1 until s.length) {
            // ( ) ) ( ( ( ) )
            // 0 0 0 0 0 0 0 0
            // 0 2 0 0 0 0 2
            if (s[i] == ')') {
                if (s[i - 1] == '(') {
                    // i = 5
                    dp[i] = (if (i >= 2) dp[i - 2] else 0) + 2

                } else if (i - dp[i - 1] > 0 && s[i - dp[i - 1] - 1] == '(') { // i= 7, 7 > 2 = &&s[ 7 - 2 - 1] , s[4] == '('

                    dp[i] =
                        dp[i - 1] + (if (i - dp[i - 1] >= 2) dp[i - dp[i - 1] - 2] else 0) + 2
                    // 7 - 1 +       7 - 2  , dp[ 7 - 2 - 2] + 2
                    // 4 .

                }
                maxans = maxOf(maxans, dp[i])
            }
        }
        return maxans
    }

}

fun main() {
    val longestValidParenthesis = LongestValidParenthesis()
        .longestValidParentheses("()()")
    println(longestValidParenthesis)

}
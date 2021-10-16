package leetcode_daily_chalange

class BestTimeToBuyAndSellStock3 {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) return 0
        var s1 = -prices[0]
        var s2 = 0
        var s3 = Int.MIN_VALUE
        var s4 = 0

        for (i in 1 until prices.size) {
            s1 = maxOf(s1, -prices[i])
            s2 = maxOf(s2, s1 + prices[i])
            s3 = maxOf(s3, s2 - prices[i])
            s4 = maxOf(s4, s3 + prices[i])
        }
        return s4
    }
}
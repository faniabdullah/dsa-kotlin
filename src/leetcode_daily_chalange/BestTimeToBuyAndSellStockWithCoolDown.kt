package leetcode_daily_chalange

class BestTimeToBuyAndSellStockWithCoolDown {
    fun maxProfit(prices: IntArray): Int {
        var profitOne = 0
        var profitTwo = 0
        for (i in 1 until prices.size) {
            val temp = profitOne
            profitOne = maxOf(profitOne + prices[i] - prices[i - 1], profitTwo)
            profitTwo = maxOf(temp, profitTwo)
        }
        return maxOf(profitOne, profitTwo)
    }
}
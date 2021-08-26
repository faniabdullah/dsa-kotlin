package dynamicprogramming

class NewStoneGame {
    fun stoneGameVII(stones: IntArray): Int {
        val sum = stones.sum()
        val memo = Array(stones.size){IntArray(stones.size){-1} }
        return play(stones, 0, stones.lastIndex, sum, memo)
    }

    fun play(stones: IntArray, l:Int, r: Int, sum: Int, memo: Array<IntArray>) : Int {
        if(l == r) return 0
        if (memo[l][r] != -1) return memo[l][r]
        val a = sum - stones[l] - play(stones, l+1, r, sum - stones[l], memo)
        val b = sum - stones[r] - play(stones, l, r-1, sum - stones[r], memo)
        memo[l][r] = maxOf(a, b)
        return memo[l][r]
    }
}

fun main() {
    val newStoneGame = NewStoneGame()
    val result = newStoneGame.stoneGameVII(intArrayOf(5, 3, 1, 4, 2))
    println(result)
}
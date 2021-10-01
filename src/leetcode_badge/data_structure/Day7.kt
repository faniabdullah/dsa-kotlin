package leetcode_badge.data_structure

import java.util.*


class Day7 {
    fun wordPattern(pattern: String, s: String): Boolean {
        val list = s.split(" ")
        if (list.size != pattern.length) return false

        val map = mutableMapOf<Char, String>()
        pattern.forEachIndexed { i, ch ->
            when (map.containsKey(ch)) {
                true -> if (map[ch] != list[i]) return false
                false -> {
                    if (map.containsValue(list[i])) return false
                    map[ch] = list[i]
                }
            }
        }

        return true
    }

    fun canSeePersonsCount(heights: IntArray): IntArray {
        // descending monotonic stack
        val res = IntArray(heights.size)
        val stk = Stack<IntArray>() // [height, index]
        for (i in heights.indices) {
            val h = heights[i]
            while (!stk.isEmpty() && stk.peek()[0] < h) {
                val prev = stk.pop()[1]
                res[prev]++ // prev shorter can see taller
            }
            if (!stk.isEmpty()) {
                res[stk.peek()[1]]++ // prev taller can see shorter
            }
            println(res.contentToString())
            stk.push(intArrayOf(h, i))
        }
        return res
    }

    internal class Solution {
        fun stoneGame(piles: IntArray): Boolean {
            val N = piles.size
            val dp = Array(N + 2) { IntArray(N + 2) }
            for (size in 1..N) {
                var i = 0
                while (i + size <= N) {
                    val j = i + size - 1
                    val parity = (j + i + N) % 2
                    if (parity == 1) dp[i + 1][j + 1] =
                        maxOf(piles[i] + dp[i + 2][j + 1], piles[j] + dp[i + 1][j]) else dp[i + 1][j + 1] =
                        minOf(-piles[i] + dp[i + 2][j + 1], -piles[j] + dp[i + 1][j])
                    ++i
                }
            }
            return dp[1][N] > 0
        }

        internal class Solution {
            fun partitionLabels(S: String): List<Int?> {
                val last = IntArray(26)
                for (i in 0 until S.length) last[S[i] - 'a'] = i
                var j = 0
                var anchor = 0
                val ans: MutableList<Int?> = mutableListOf()
                for (i in S.indices) {
                    j = Math.max(j, last[S[i] - 'a'])
                    if (i == j) {
                        ans.add(i - anchor + 1)
                        anchor = i + 1
                    }
                }
                return ans
            }
        }
    }
}

fun main() {
    println(Day7().wordPattern("jsj", "jquery         s           jquery"))
    Day7().canSeePersonsCount(intArrayOf(10, 6, 8, 5, 11, 9))
}
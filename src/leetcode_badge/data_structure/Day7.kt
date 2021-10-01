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
}

fun main() {
    println(Day7().wordPattern("jsj", "jquery         s           jquery"))
    Day7().canSeePersonsCount(intArrayOf(10, 6, 8, 5, 11, 9))
}
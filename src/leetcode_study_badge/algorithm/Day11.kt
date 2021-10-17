package leetcode_study_badge.algorithm

class Day11 {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val combinations: MutableList<List<Int>> = mutableListOf()
        fun recurse(lo: Int, arity: Int, combination: List<Int>) {
            (lo..n).forEach {
                if (arity == 1) combinations.add(combination + it)
                else recurse(it + 1, arity - 1, combination + it)
            }
        }
        if (k > 0) recurse(1, k, emptyList())
        return combinations
    }


}

fun main() {
    val result = Day11().combine(4, 2)
    println(result)
}
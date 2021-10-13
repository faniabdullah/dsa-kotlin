package leetcode_study_badge.data_structure

class Day21 {
    fun frequencySort(s: String): String {
        return s
            .split("")
            .filter { it -> it != "" }
            .groupingBy { it }
            .eachCount()
            .toList()
            .sortedBy { it.second }
            .reversed()
            .map { it ->
                var t = ""
                for (i in 0 until it.second.toInt()) {
                    t = t + it.first
                }
                t
            }
            .joinToString("")
    }

    fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
        var l = MutableList(points.size) {
            intArrayOf(
                points[it][0] * points[it][0] + points[it][1] * points[it][1],
                points[it][0],
                points[it][1]
            )
        }.apply { this.sortWith(compareBy({ it[0] })) }
        return Array(K) { intArrayOf(l[it][1], l[it][2]) }
    }
}
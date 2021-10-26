package codility

class FrogRiverOne {
    fun solution(X: Int, A: IntArray): Int {
        val list = IntArray(X) { -1 }
        var maxCounters = -1
        var minCounters = 0
        for (i in A.indices) {
            if (A[i] <= X && list[A[i] - 1] == -1) {
                list[A[i] - 1] = i
                maxCounters = maxOf(maxCounters, i)
                minCounters++
            }
        }
        return if (minCounters == X) return maxCounters else -1
    }
}

fun main() {
    println(FrogRiverOne().solution(5, intArrayOf(1, 2, 3, 9, 10, 4,5)))
}

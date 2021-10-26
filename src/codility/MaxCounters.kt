package codility

class MaxCounters {
    fun solution(N: Int, A: IntArray): IntArray {
        val result = IntArray(N) { 0 }
        var maxCounters = 0
        var lasIncrease = 0
        for (i in A.indices) {
            if (A[i] == N + 1) {
                lasIncrease = maxCounters
            } else {
                result[A[i] - 1] = maxOf(lasIncrease, result[A[i] - 1])
                result[A[i] - 1]++
                maxCounters = maxOf(maxCounters, result[A[i] - 1])
            }
        }

        for (i in result.indices) {
            result[i] = maxOf(result[i], lasIncrease)
        }
        return result
    }
}

fun main() {
    MaxCounters().solution(5, intArrayOf(3, 4, 4, 6, 1, 4, 4))
}
package codility

class FirstUniqueNumber {
    fun solution(A: IntArray): Int {
        // write your code in Kotlin 1.3.11 (Linux)
        val hashMap = HashMap<Int, Int>()
        for (i in A.indices) {
            hashMap[A[i]] = hashMap.getOrDefault(A[i], 0) + 1
        }
        for (i in A.indices) {
            if (hashMap[A[i]] == 1) return A[i]
        }

        return -1
    }

}

fun main() {
    println(FirstUniqueNumber().solution(intArrayOf(4, 10, 5, 4, 2, 10)))
}
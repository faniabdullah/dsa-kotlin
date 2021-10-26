package codility

class OddOccurrencesInArray {
    fun solution(A: IntArray): Int {
        var result = 0
        A.forEach {
            result = result.xor(it)
        }
        return result
    }
}

fun main() {
    OddOccurrencesInArray().solution(intArrayOf(1, 3, 4, 5, 6))
}












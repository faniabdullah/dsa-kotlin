package codility

import java.util.*


class Fish {
    fun solution(A: IntArray, B: IntArray): Int {
        val livingIndices = Stack<Int>()
        for (i in A.indices) {
            if (B[i] == 0) {
                while (!livingIndices.empty() && B[livingIndices.peek()] == 1 &&
                    A[i] > A[livingIndices.peek()]) {
                    livingIndices.pop()
                }
                if (!(!livingIndices.empty() && B[livingIndices.peek()] == 1)) {
                    livingIndices.push(i)
                }
            } else {
                livingIndices.push(i)
            }
        }
        return livingIndices.size
    }

}

fun main() {
    println(Fish().solution(intArrayOf(4, 3, 2, 1, 5), intArrayOf(0, 1, 0, 0, 0)))
}
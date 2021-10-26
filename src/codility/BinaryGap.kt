package codility

class BinaryGap {
    fun solution(n: Int): Int {
        val binary: String = n.toString(2)
        var longestBinaryGap = 0
        var stateOne = 0
        var countZero = 0
        for (i in binary.indices) {
            if (binary[i] == '1') {
                stateOne++
            }
            if (stateOne == 1 && binary[i] == '0') {
                countZero++
            } else if (stateOne == 2) {
                longestBinaryGap = maxOf(longestBinaryGap, countZero)
                countZero = 0
                stateOne = 1
            }
        }
        return longestBinaryGap
    }
}

fun main() {
    BinaryGap().solution(2147483647)
}

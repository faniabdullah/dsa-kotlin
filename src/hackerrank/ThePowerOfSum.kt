package hackerrank

import kotlin.math.pow


fun powerSum(X: Int, N: Int): Int {
    return helper(X, N, 1)
}

fun helper(total: Int, power: Int, number: Int): Int {
    val value = total - number.toDouble().pow(power).toInt()
    if (value == 0) return 1
    if (value < 0) return 0
    return helper(value, power, number + 1) + helper(total, power, number + 1)
}

fun main() {
    println(powerSum(13, 2))
}
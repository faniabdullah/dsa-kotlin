package leetcode_badge.dynamic_programming

class Day1 {
    fun tribonacci(n: Int): Int {
        if (n == 0) return 0
        if (n <= 2) return 1
        var one = 0
        var two = 1
        var three = 1
        var temp3 = 0
        var temp2 = 0
        for (i in 3..n) {
            temp3 = three
            three += two + one
            temp2 = two
            two = temp3
            one = temp2
        }

        return three
    }
    private val lookupTable: IntArray = IntArray(31)

    fun fib(n: Int): Int {
        if (n <= 1) {
            lookupTable[n] = n
        } else {
            lookupTable[n] = fib(n - 1) + fib(n - 2)
        }

        return lookupTable[n]
    }
}
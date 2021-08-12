package dynamicprogramming

class Fibonacci {

    private val lookupTable: IntArray = IntArray(40) { -1 }

    fun fibRecursive(n: Int): Int {
        if (n <= 1) {
            return n
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2)
    }

    // overlapping sub problem
    fun fib(n: Int): Int {
        if (lookupTable[n] == -1) {
            if (n <= 1) {
                lookupTable[n] = n
            } else {
                lookupTable[n] = fib(n - 1) + fib(n - 2)
            }
        }

        return lookupTable[n]
    }
}

fun main() {
    println(Fibonacci().fibRecursive(6))
    println(Fibonacci().fib(6))
}
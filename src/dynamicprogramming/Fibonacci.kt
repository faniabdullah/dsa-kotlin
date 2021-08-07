package dynamicprogramming

class Fibonacci {

    private val lookupTable: IntArray = IntArray(40){it}

    fun fib(n: Int): Int {
        if (lookupTable[n] <= 1) {
            lookupTable[n] = n
        } else {
            lookupTable[n] = fib(n - 1) + fib(n - 2)
        }

        return lookupTable[n]
    }
}

fun main(){
    println(Fibonacci().fib(6))
}
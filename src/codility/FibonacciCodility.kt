package codility

class FibonacciCodility {

    fun solution(n: Int): Int {

        if (n == 1) return 1 else if (n == 2) return 1 else if(n == 0) return 0
        var previousNumber1 = 1
        var previousNumber2 = 1
        var result = previousNumber2 + previousNumber1
        for (i in 3..n) {
            result = previousNumber2 + previousNumber1
            previousNumber2 = previousNumber1
            previousNumber1 = result
        }
        return result
    }
}
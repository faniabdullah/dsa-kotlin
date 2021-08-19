package compotitiveProgramming.easy

class PrintWithoutLoop {
    fun solution(n: Int, target: Int) {
        if (n <= target) {
            println(n)
            solution(n + 1, target)
        }
    }

    fun solutionWithoutTarget(n: Int) {
        if (n >= 0) {
            solutionWithoutTarget(n - 1)
            println(n)
        }
    }
}

fun main() {
    PrintWithoutLoop().solutionWithoutTarget(100)
}
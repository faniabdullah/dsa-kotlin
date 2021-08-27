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

    fun swapWithoutCreateVariabel(): Int {
        var a = 4
        var b = 6
        a += b //10
        b = a - b // 10 - 6 = 4
        a -= b // 10 - 4  = 6
        println(a)
        println(b)

        var c = "tokopedia"
        var d = "fani abdullah"
        c += d

        d = c.substring(0, c.length - d.length)
        c = c.substring(d.length, c.length)
        println(d)
        println(c)

        return 0
    }

}

fun main() {
    PrintWithoutLoop().swapWithoutCreateVariabel()
}
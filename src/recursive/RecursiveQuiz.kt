package recursive

import java.util.*


class RecursiveQuiz {
    fun quiz1(x: Int, y: Int): Int {
        return if (x == 0) y
        else quiz1(x - 1, x + y)
        /*
        * y = 5 2
        * y = 4 7
        * y = 3 11
        * y = 2 14
        * y = 1 16
        * y = 0 17
        * */
    }

    fun quiz2(n: Int) {
        var i = 0
        if (n > 1) quiz2(n - 1)
        i = 0
        while (i < n) {
            print(" * ")
            i++
        }
    }

    var LIMIT = 1000
    fun fun2(n: Int) {
        if (n <= 0) return
        if (n > LIMIT) return
        print(String.format("%d ", n))
        fun2(2 * n)
        print(String.format("%d ", n))
    }

    fun quiz4(n: Int) {
        var n = n
        if (n > 0) {
            quiz4(--n)
            print("$n ")
            quiz4(--n)
        }
    }

    fun decodeString(s: String): String? {
        val q: Deque<Char> = ArrayDeque()
        for (ch in s.toCharArray()) q.add(ch)
        return recursion(q)
    }

    private fun recursion(q: Queue<*>): String? {
        val ans = StringBuilder()
        var num = 0
        while (!q.isEmpty()) {
            val c = q.poll() as Char
            if (c in '0'..'9') {
                num = num * 10 + c.toInt() - '0'.toInt()
            } else if (c == '[') {
                val temp = recursion(q)
                for (i in 0 until num) ans.append(temp)
                num = 0
            } else if (c == ']') break else ans.append(c)
        }
        return ans.toString()
    }

    fun calculate(s: String): Int {
        val q: Deque<Char> = ArrayDeque()
        var str = s.replace('(', ' ')
        str = str.replace(')', ' ')
        str = str.replace("\\s".toRegex(), "")
        if (!str.contains('+') && !str.contains('-')) return str.toInt()

        for (ch in s.toCharArray()) q.add(ch)
        return recursionCalculate(q, false)
    }

    private fun recursionCalculate(s: Queue<Char>, isMin: Boolean): Int {
        var num = 0
        while (s.isNotEmpty()) {
            var c = s.poll() as Char
            if (c in '0'..'9') { // 3
                num = "$num${c.toInt() - '0'.toInt()}".toInt()
                if (isMin) {
                    c = ')'
                }
            } else if (c == '+') {
                num += recursionCalculate(s, false)
            } else if (c == '-') {
                num -= recursionCalculate(s, true)
            } else if (c == '(') {
                num = recursionCalculate(s, true)
            }else if (c == ')'){
                return num
            }

            if (c == ')') {
                return num
            }
        }
        return num
    }
}

fun main() {
    // (1+(4+5+2)-3)+(6+8)
    println(RecursiveQuiz().calculate("56 - 55"))
    // 2
    //

}
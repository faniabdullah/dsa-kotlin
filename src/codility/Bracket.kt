package codility

import java.util.*

class Bracket {
    fun solution(S: String): Int {
        // write your code in Kotlin 1.3.11 (Linux)
        val pairs = mapOf('{' to '}', '[' to ']', '(' to ')')
        val stack = Stack<Char>()
        for (i in S.indices) {
            if (S[i] == '{' || S[i] == '(' || S[i] == '[') {
                stack.push(S[i])
            } else {
                if (stack.isEmpty()) return 0
                if (S[i] != pairs[stack.peek()]) return 0
                stack.pop()
            }
        }
        return if (stack.isEmpty()) 1 else 0

    }
}

fun main() {
    println(Bracket().solution("{[()()]}}}}}}()}"))
}

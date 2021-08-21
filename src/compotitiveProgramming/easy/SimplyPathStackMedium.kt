package compotitiveProgramming.easy

import java.util.*

class SimplyPathStackMedium {
    /*
    Input: path = "/a/./b/../../c/"
                   ..
                   /./
                   /../
                   //
     */
    fun solution(s: String): String {
        val stack: Stack<Char> = Stack()

        repeat(s.length) {

            if (s[it] == '/' && it >= 2) {
                if (s[it - 2] == '/' && s[it - 1] == '.') {
                    stack.pop()
                }
            }

            if (s[it] == '/' && it >= 3) {
                if (s[it - 3] == '/' && s[it - 2] == '.' && s[it - 1] == '.') {
                    var state = 2
                    while (state > 0) {
                        if (stack.size == 1) {
                            break
                        }
                        if (stack.peek() == '/') {
                            state -= 1
                        }
                        stack.pop()
                    }
                }
            }

            if (stack.isEmpty()) {
                stack.push(s[it])
            } else if (!(s[it] == '/' && stack.peek() == '/')) {
                stack.push(s[it])
            }

            if (s[it] == '.' && it == s.lastIndex) {
                if (s[it - 1] == '/') {
                    stack.pop()
                } else if (s[it - 1] == '.' && s[it - 2] == '/') {
                    var state = 2
                    while (state > 0) {
                        if (stack.size == 1) {
                            break
                        }
                        if (stack.peek() == '/') {
                            state -= 1
                        }
                        stack.pop()
                    }
                }
            }
        }

        if (stack.size > 1 && stack.peek() == '/') {
            stack.pop()
        }
        return String(stack.toCharArray())
    }
}


fun main() {
    val simplyPathStackMedium = SimplyPathStackMedium()
    val result = simplyPathStackMedium.solution("/home")
    println(result)
}
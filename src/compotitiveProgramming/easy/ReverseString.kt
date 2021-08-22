package compotitiveProgramming.easy

import java.util.*

class ReverseString {
    fun solution(s: String): String {
        var i = 0
        var j = s.length - 1
        val stringResult = s.toCharArray()
        while (i < j) {
            val temp = stringResult[j]
            stringResult[j] = stringResult[i]
            stringResult[i] = temp
            i++
            j--
        }
        return String(stringResult)
    }


    fun solutionPerWord(s: String): String {
        val stack = Stack<Char>()
        val stringBuilder = StringBuilder()
        repeat(s.length) {
            if (!s[it].isLetter() || it == s.lastIndex) {

                if (it == s.lastIndex && s[it].isLetter()) {
                    stack.push(s[it])
                }
                while (stack.isNotEmpty()) {
                    stringBuilder.append(stack.pop())
                }
                if (!s[it].isLetter()) {
                    stringBuilder.append(s[it])
                }

            } else {
                stack.push(s[it])
            }
        }
        return stringBuilder.toString()
    }
}


fun main() {
    val reverseString = ReverseString()
    println(reverseString.solutionPerWord("Hello Tokopedia fani abdullah!"))
}
package leetcode_badge.algorithm

class Day4 {
    fun reverseString(s: CharArray): Unit {
        var left = 0
        var right = s.size - 1
        while (left < right) {
            val temp = s[left]
            s[left] = s[right]
            s[right] = temp
            left++
            right--
        }
    }

    fun reverseWords(s: String): String {
        val result = s.toCharArray()
        // Let's take LeetCode contest
        var lastAssign = 0
        var left = 0
        while (left < s.length) {
            if (result[left].isWhitespace() || left == result.lastIndex) {
                var tempLeft = if (left == result.lastIndex) left else left - 1
                while (tempLeft > lastAssign) {
                    val temp = result[tempLeft]
                    result[tempLeft] = result[lastAssign]
                    result[lastAssign] = temp
                    lastAssign++
                    tempLeft--
                }
                lastAssign = left + 1
            }

            left++
        }
        return String(result)
    }
}

fun main() {
    val charArray = charArrayOf('f', 'a', 'n', 'i', 'a', 'b', 'd', 'u', 'l', 'l', 'a', 'h')
    println(charArray.contentToString())
    Day4().reverseString(charArray)
    println(charArray.contentToString())

    println(Day4().reverseWords(" faniabdullah 345 421 risa evi gilang ersan dina nadin "))
}
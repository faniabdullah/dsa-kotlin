package compotitiveProgramming.medium


// just only reverse a word
class ReverseWord {
    fun solution(s: String) {
        // hello world
        var s = s.toCharArray()
        val size = s.size - 1
        var i = 0
        var j = size
        val middle: Int = size / 2

        while (i != middle || j != middle) {
            // hellof world fani
            if (s[j] == ' ') {
                // stop
                if (s[i] == ' ') {
                    for (f in j + 1..size) {
                        val temp = s[i]
                        s[i] = s[j]
                        s[j] = temp
                    }
                    var left = i - j
                    while (left != i) {

                        left++
                    }
                    j--
                }
            } else {
                if (j != middle) {
                    j--
                }
            }

            if (s[i] == ' ') {
                // stop
            } else {
                if (i != middle) {
                    i++
                }
            }
        }

    }
}

internal class Solution {
    fun reverseWords(s: String): String {
        var result: String = ""
        var i = 0
        val len: Int = s.length
        var j: Int
        while (i < len) {
            while (i < len && s[i] == ' ') {
                i++
            }
            if (i >= len) {
                break
            }
            j = i + 1
            while (j < len && s[j] != ' ') {
                j++
            }
            val ans: String = s.substring(i, j - i)
            result = if (result.isEmpty()) {
                ans
            } else {
                "$ans $result"
            }
            i = j + 1
        }
        return result
    }
}

fun main() {
    println(ReverseWord().solution("fani nipa"))
}
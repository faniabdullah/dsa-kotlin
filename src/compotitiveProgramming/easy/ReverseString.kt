package compotitiveProgramming.easy

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
}


fun main() {
    val reverseString = ReverseString()
    println(reverseString.solution("hello tokopedia"))

}
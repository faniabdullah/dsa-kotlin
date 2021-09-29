package leetcode_badge.data_structure

class Day6 {
    fun addStrings(num1: String, num2: String): String {
        var numbers1 = num1.length - 1
        var numbers2 = num2.length - 1
        var carry : Int = 0
        val stringResult = StringBuilder()
        while(numbers1 >= 0 || numbers2 >= 0  ){
            val n1 = if(numbers1 >= 0) num1[numbers1] - '0' else 0
            val n2 = if(numbers2 >= 0 ) num2[numbers2] - '0' else 0
            val result = (n1 + n2 + carry) % 10
            carry = (n1 + n2 + carry) / 10
            stringResult.append(result)
            numbers1--
            numbers2--
        }


        if (carry != 0) stringResult.append(carry)

        return stringResult.reverse().toString()
    }

    fun longestPalindrome(s: String): Int {
        val count = IntArray(128)
        for (c in s.toCharArray()) count[c - '0']++
        s.length
        var ans = 0
        for (v in count) {
            ans += v / 2 * 2
            if (ans % 2 == 0 && v % 2 == 1) ans++
        }
        return ans
    }
}

fun main() {
    println(Day6().addStrings("1", "9"))
}
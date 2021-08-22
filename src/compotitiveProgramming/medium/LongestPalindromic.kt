package compotitiveProgramming.medium

class LongestPalindromic {
    private var palindrome: String = ""
    fun longestPalindrome(s: String): String {
        return recursivePalindrome(s)
    }

    private fun recursivePalindrome(sentence: String): String {
        if (sentence.length <= palindrome.length) {
            return palindrome
        }
        if (sentence.reversed() == sentence && sentence.length > palindrome.length) {
            palindrome = sentence
        }

        recursivePalindrome(sentence.substring(0, sentence.length - 1))
        recursivePalindrome(sentence.substring(1, sentence.length))
        return palindrome
    }
}

fun main() {
    val longestPalindromic = LongestPalindromic()
    val result = longestPalindromic.longestPalindrome("abacdgfdcaba")
        
    println(result)
}
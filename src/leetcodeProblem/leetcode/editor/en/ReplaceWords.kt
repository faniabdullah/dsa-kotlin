//In English, we have a concept called root, which can be followed by some
//other word to form another longer word - let's call this word successor. For example,
// when the root "an" is followed by the successor word "other", we can form a 
//new word "another". 
//
// Given a dictionary consisting of many roots and a sentence consisting of 
//words separated by spaces, replace all the successors in the sentence with the root 
//forming it. If a successor can be replaced by more than one root, replace it 
//with the root that has the shortest length. 
//
// Return the sentence after the replacement. 
//
// 
// Example 1: 
// Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled 
//by the battery"
//Output: "the cat was rat by the bat"
// Example 2: 
// Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
//Output: "a a b c"
// Example 3: 
// Input: dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa 
//aaa aaa aaaaaa bbb baba ababa"
//Output: "a a a a a a a a bbb baba a"
// Example 4: 
// Input: dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was 
//rattled by the battery"
//Output: "the cat was rat by the bat"
// Example 5: 
// Input: dictionary = ["ac","ab"], sentence = "it is abnormal that this 
//solution is accepted"
//Output: "it is ab that this solution is ac"
// 
// 
// Constraints: 
//
// 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 100 
// dictionary[i] consists of only lower-case letters. 
// 1 <= sentence.length <= 10^6 
// sentence consists of only lower-case letters and spaces. 
// The number of words in sentence is in the range [1, 1000] 
// The length of each word in sentence is in the range [1, 1000] 
// Each two consecutive words in sentence will be separated by exactly one 
//space. 
// sentence does not have leading or trailing spaces. 
// 
// Related Topics Array Hash Table String Trie 👍 1212 👎 148


package leetcodeProblem.leetcode.editor.en

import java.lang.StringBuilder
import kotlin.math.sign

class ReplaceWords {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // one line
        fun replaceWords2(
            d: List<String>,
            s: String
        ) = s.split(" ").joinToString(" ") { w -> d.filter { w.startsWith(it) }.minByOrNull { it.length } ?: w }

        fun replaceWords(dictionary: List<String>, sentence: String): String {
            val splitString = sentence.split(" ")
            val result = StringBuilder()
            for (s in splitString) {
                for (i in s.indices) {
                    val subString = s.substring(0, i + 1)
                    if (!dictionary.contains(subString)) {
                        if (i == s.lastIndex) {
                            result.append("$subString ")
                        }
                    } else {
                        result.append("$subString ")
                        break
                    }
                }
            }
            val resultString = result.toString()
            return resultString.substring(0, resultString.length - 1)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {
    val result = ReplaceWords.Solution().replaceWords(
        listOf(
            "cat", "bat", "rat"
        ), "aadsfasf absbs bbab cadsfafs"
    )
    println(result)
}
  


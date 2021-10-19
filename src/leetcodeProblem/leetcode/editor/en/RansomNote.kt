//Given two stings ransomNote and magazine, return true if ransomNote can be
//constructed from magazine and false otherwise. 
//
// Each letter in magazine can only be used once in ransomNote. 
//
// 
// Example 1: 
// Input: ransomNote = "a", magazine = "b"
//Output: false
// Example 2: 
// Input: ransomNote = "aa", magazine = "ab"
//Output: false
// Example 3: 
// Input: ransomNote = "aa", magazine = "aab"
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote and magazine consist of lowercase English letters. 
// 
// Related Topics Hash Table String Counting 👍 1215 👎 266


package leetcodeProblem.leetcode.editor.en

class RansomNote {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun canConstruct(ransomNote: String, magazine: String): Boolean {
            if (ransomNote == magazine) return true
            val hashMap = mutableMapOf<Char, Int>()
            for (i in magazine.indices) {
                hashMap[magazine[i]] = hashMap.getOrDefault(magazine[i], 0) + 1
            }
            for (i in ransomNote.indices) {
                if (hashMap.containsKey(ransomNote[i])) {
                    hashMap[ransomNote[i]] = hashMap[ransomNote[i]]!! - 1
                    if (hashMap[ransomNote[i]] == 0) hashMap.remove(ransomNote[i])
                } else {
                    return false
                }
            }
            return true
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  


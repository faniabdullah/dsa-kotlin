//The Hamming distance between two integers is the number of positions at which
//the corresponding bits are different. 
//
// Given two integers x and y, return the Hamming distance between them. 
//
// 
// Example 1: 
//
// 
//Input: x = 1, y = 4
//Output: 2
//Explanation:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//The above arrows point to positions where the corresponding bits are 
//different.
// 
//
// Example 2: 
//
// 
//Input: x = 3, y = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 0 <= x, y <= 2³¹ - 1 
// 
// Related Topics Bit Manipulation 👍 2642 👎 188


package leetcodeProblem.leetcode.editor.en

class HammingDistance {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun oneLineHammingDistance(x: Int, y: Int): Int {
            return Integer.bitCount(x xor y)
        }

        fun hammingDistance(x: Int, y: Int): Int {
            if (x == y) return 0
            var count = 0
            var n = x xor y
            while (n > 0) {
                count += n and 1
                n = n shr 1
            }
            return count
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {
    HammingDistance.Solution().hammingDistance(11, 12)
}
  


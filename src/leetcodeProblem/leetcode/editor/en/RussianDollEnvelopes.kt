//You are given a 2D array of integers envelopes where envelopesintArrayOf(i) = intArrayOf(wi, hi)
//represents the width and the height of an envelope. 
//
// One envelope can fit into another if and only if both the width and height 
//of one envelope are greater than the other envelope's width and height. 
//
// Return the maximum number of envelopes you can Russian doll (i.e., put one 
//inside the other). 
//
// Note: You cannot rotate an envelope. 
//
// 
// Example 1: 
//
// 
//Input: envelopes = intArrayOf(intArrayOf(5,4),intArrayOf(6,4),intArrayOf(6,7),intArrayOf(2,3))
//Output: 3
//Explanation: The maximum number of envelopes you can Russian doll is 3 (intArrayOf(2,3) 
//=> intArrayOf(5,4) => intArrayOf(6,7)).
// 
//
// Example 2: 
//
// 
//Input: envelopes = intArrayOf(intArrayOf(1,1),intArrayOf(1,1),intArrayOf(1,1))
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= envelopes.length <= 5000 
// envelopesintArrayOf(i).length == 2 
// 1 <= wi, hi <= 10⁴ 
// 
// Related Topics Array Binary Search Dynamic Programming Sorting 👍 2606 👎 66


package leetcodeProblem.leetcode.editor.en

import java.util.*


class RussianDollEnvelopes {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxEnvelopes(envelopes: Array<IntArray>): Int {
            var maxEnvelopes = 1
            val dp = IntArray(envelopes.size) { 1 }
            Arrays.sort(
                envelopes
            ) { arr1, arr2 -> if (arr1[0] == arr2[0]) arr2[1] - arr1[1] else arr1[0] - arr2[0] }

            for (i in 1 until envelopes.size) {
                for (j in 0..i) {
                    if (envelopes[j][0] > envelopes[i][0] && envelopes[j][1] > envelopes[i][1]
                        && dp[j] + 1 > dp[i]
                    ) {
                        dp[i] = dp[j] + 1
                    } else if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1] && dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1
                    }
                }
                maxEnvelopes = maxOf(maxEnvelopes, dp[i])
            }
            return maxEnvelopes
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {
    RussianDollEnvelopes.Solution().maxEnvelopes(
        arrayOf(
            intArrayOf(1, 15),
            intArrayOf(7, 18),
            intArrayOf(7, 6),
            intArrayOf(7, 100),
            // 3 , 5 ?

            intArrayOf(2, 200), //
            intArrayOf(17, 30), // 4
            intArrayOf(17, 45), // 5
            intArrayOf(3, 5),
            intArrayOf(7, 8),
            intArrayOf(3, 6),
            intArrayOf(3, 10),
            intArrayOf(7, 20),
            intArrayOf(17, 3),
            intArrayOf(17, 45)
        )
    )
}
  


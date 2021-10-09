//Given a linked list, swap every two adjacent nodes and return its head. You
//must solve the problem without modifying the values in the list's nodes (i.e., 
//only nodes themselves may be changed.) 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4]
//Output: [2,1,4,3]
// 
//
// Example 2: 
//
// 
//Input: head = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 100]. 
// 0 <= Node.val <= 100 
// 
// Related Topics Linked List Recursion 👍 4687 👎 248


package leetcodeProblem.leetcode.editor.en

import leetcode_study_badge.data_structure.ListNode

class SwapNodesInPairs {
    fun solution() {
    }
    //below code is used to auto submit to leetcode.com (using ide plugin)
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */
    class Solution {
        fun swapPairs(head: ListNode?): ListNode? {
            return helpSwap(head, head?.next)
        }

        private fun helpSwap(head: ListNode?, next: ListNode?): ListNode? {
            if (head == null) return null
            if (next == null) return head
            val nextPair = next.next
            next.next = head
            head.next = helpSwap(nextPair, nextPair?.next)
            return next
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  


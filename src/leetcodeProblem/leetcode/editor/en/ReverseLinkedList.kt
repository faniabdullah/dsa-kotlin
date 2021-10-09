//Given the head of a singly linked list, reverse the list, and return the
//reversed list. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: [2,1]
// 
//
// Example 3: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is the range [0, 5000]. 
// -5000 <= Node.val <= 5000 
// 
//
// 
// Follow up: A linked list can be reversed either iteratively or recursively. 
//Could you implement both? 
// Related Topics Linked List Recursion 👍 8776 👎 153


package leetcodeProblem.leetcode.editor.en

import leetcode_study_badge.data_structure.ListNode

class ReverseLinkedList {
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
        fun reverseList(head: ListNode?): ListNode? {
            if (head == null) return head
            return recurReverseList(head, null)
        }

        private fun recurReverseList(p: ListNode?, l: ListNode?): ListNode? {
            if (p == null) return l

            val n = p.next
            p.next = l

            return recurReverseList(n, p)
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  


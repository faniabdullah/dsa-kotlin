//You are given the head of a singly linked-list. The list can be represented
//as: 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// Reorder the list to be on the following form: 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// 
//
// You may not modify the values in the list's nodes. Only nodes themselves may 
//be changed. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4]
//Output: [1,4,2,3]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,4,5]
//Output: [1,5,2,4,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 5 * 10⁴]. 
// 1 <= Node.val <= 1000 
// 
// Related Topics Linked List Two Pointers Stack Recursion 👍 4025 👎 170


package leetcodeProblem.leetcode.editor.en

import leetcode_study_badge.data_structure.ListNode

class ReorderList {
    fun solution() {
    }
    //below code will be used for submission to leetcode (using plugin of course)
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
        tailrec fun midPoint(slow: ListNode?, fast: ListNode? = slow): ListNode? =
            if (fast?.next == null) slow else midPoint(slow?.next, fast.next?.next)

        tailrec fun reverse(node: ListNode?, reversed: ListNode? = null): ListNode? =
            if (node == null) reversed else reverse(node.next.also { node.next = reversed }, node)

        tailrec fun merge(left: ListNode?, right: ListNode?) {
            if(left != right) {
                val nextRight = right?.next.also { right?.next = left?.next }
                val nextLeft = left?.next.also { left?.next = right }
                if (right != null) merge(nextLeft, nextRight)
            }
        }
        fun reorderList(head: ListNode?) = merge(head, reverse(midPoint(head)))
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  


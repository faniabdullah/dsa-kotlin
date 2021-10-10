//Given the head of a linked list, remove the nᵗʰ node from the end of the list
//and return its head. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1], n = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1,2], n = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is sz. 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
// Follow up: Could you do this in one pass? 
// Related Topics Linked List Two Pointers 👍 7132 👎 367


package leetcodeProblem.leetcode.editor.en

import leetcode_study_badge.data_structure.ListNode

class RemoveNthNodeFromEndOfList {
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
        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            var result = head
            var tempResult = result
            var current = head
            var size = 1
            while (current?.next != null) {
                size++
                current = current?.next
            }

            size -= n
            if (size == 0) {
                tempResult = tempResult?.next
            } else {
                for (i in 1..size) {
                    if (i == size) {
                        result?.next = result?.next?.next
                    } else {
                        result = result?.next
                    }
                }
            }
            return tempResult
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  


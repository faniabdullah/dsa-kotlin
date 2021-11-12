//Given the head of a linked list and an integer val, remove all the nodes of
//the linked list that has Node.val == val, and return the new head. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,6,3,4,5,6], val = 6
//Output: [1,2,3,4,5]
// 
//
// Example 2: 
//
// 
//Input: head = [], val = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [7,7,7,7], val = 7
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 10⁴]. 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
// Related Topics Linked List Recursion 👍 3859 👎 140


package leetcodeProblem.leetcode.editor.en

class RemoveLinkedListElements {
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
        fun removeElements(head: ListNode?, `val`: Int): ListNode? {
            var current = head
            var result = head
            var next = ListNode(0)
            next.next = result

            while (current != null) {
                if (current.`val` == 6) {
                    result?.next = result?.next?.next
                }
                result = result?.next
                current = current.next
            }
            return next.next
        }
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  


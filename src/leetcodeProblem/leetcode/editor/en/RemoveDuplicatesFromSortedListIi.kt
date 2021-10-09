//Given the head of a sorted linked list, delete all nodes that have duplicate
//numbers, leaving only distinct numbers from the original list. Return the linked 
//list sorted as well. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,3,4,4,5]
//Output: [1,2,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1,1,1,2,3]
//Output: [2,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 300]. 
// -100 <= Node.val <= 100 
// The list is guaranteed to be sorted in ascending order. 
// 
// Related Topics Linked List Two Pointers 👍 3700 👎 134


package leetcodeProblem.leetcode.editor.en

import leetcode_study_badge.data_structure.ListNode

class RemoveDuplicatesFromSortedListIi {
    fun solution() {
    }
    //below code is used to auto submit for leetcode.com (using ide plugin)
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
        // sentinel Algorithm
        fun deleteDuplicates(head: ListNode?): ListNode? {
            val sentinel = ListNode(0, head)
            var preD: ListNode? = sentinel
            var head = head
            while (head != null) {
                if (head.next != null && head.`val` == head.next?.`val`) {
                    while (head?.next != null && head?.`val` == head?.next?.`val`) {
                        head = head?.next
                    }
                    preD?.next = head?.next
                } else {
                    preD = preD?.next
                }
                head = head?.next
            }
            return sentinel.next
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  


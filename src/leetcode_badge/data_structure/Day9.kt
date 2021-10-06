package leetcode_badge.data_structure


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


class Day9 {
    fun findRepeatedDnaSequences(s: String): List<String> {

        val sequenceCountMap = HashMap<String, Int>()

        val sequenceCheckLength = 10

        for (index in 0..s.length - sequenceCheckLength) {
            val substring = s.substring(index, index + sequenceCheckLength)
            sequenceCountMap[substring] = (sequenceCountMap[substring] ?: 0) + 1
        }

        return sequenceCountMap.filterValues { it > 1 }.keys.toList()
    }

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var result: ListNode? = ListNode(0)
        val resultSet: ListNode? = result
        var currentL1 = l1
        var currentL2 = l2

        while (currentL1 != null || currentL2 != null) {
            if (currentL1 == null) {
                result?.next = currentL2
                result = result?.next
                currentL2 = currentL2?.next
                continue
            }
            if (currentL2 == null) {
                result?.next = currentL1
                result = result?.next
                currentL1 = currentL1.next
                continue
            }

            if (currentL1.`val` < currentL2.`val`) {
                result?.next = currentL1
                result = result?.next
                currentL1 = currentL1.next

            } else {
                result?.next = currentL2
                result = result?.next
                currentL2 = currentL2.next
            }
        }
        return resultSet?.next
    }

    fun reverseList(head: ListNode?): ListNode? {
        if (head?.next == null)
            return head

        return recurseReverse(head, null)
    }

    private fun recurseReverse(p: ListNode?, l: ListNode?): ListNode? {
        if (p == null) return l
        val n = p.next
        p.next = l
        return recurseReverse(n, p)
    }

}

fun printLinkedList(linkedList: ListNode?) {
    var current = linkedList
    while (current != null) {
        print("" + current.`val` + " ")
        current = current.next
    }
}


fun main() {
    val l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next?.next = ListNode(4)
    val l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next?.next = ListNode(4)

    val linkedListResult = Day9().reverseList(l1)
    printLinkedList(linkedListResult)
}
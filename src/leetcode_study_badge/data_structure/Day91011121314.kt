package leetcode_study_badge.data_structure


class ListNode {
    var `val` = 0
    var next: ListNode? = null

    internal constructor() {}
    constructor(`val`: Int) {
        this.`val` = `val`
    }

    constructor(`val`: Int, next: ListNode?) {
        this.`val` = `val`
        this.next = next
    }
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


    fun detectCycle(head: ListNode?): ListNode? {
        var head: ListNode? = head ?: return null
        while (head != null) {
            if (head.`val` == Int.MAX_VALUE) {
                return head
            }
            head.`val` = Int.MAX_VALUE
            head = if (head.next == null) return null else head.next
        }
        return null
    }

    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var a = headA
        var b = headB
        while (a != b) {
            a = if (a == null) headB else a.next
            b = if (b == null) headA else b.next
        }
        return a
    }

    fun deleteDuplicates(head: ListNode?): ListNode? {
        val dumpHead: ListNode? = ListNode(Int.MIN_VALUE, head)
        var knight = dumpHead?.next // the start point
        var lastValidatedNode = dumpHead // the pointer will run to check node by node

        while (knight != null) {
            if (knight.`val` == knight.next?.`val`) {
                while (knight != null && knight.`val` == knight.next?.`val`) {
                    knight = knight.next
                }
                lastValidatedNode?.next = knight?.next
            } else {
                lastValidatedNode = lastValidatedNode?.next
            }
            knight = knight?.next
        }
        return dumpHead?.next
    }

    private fun swap(node1: ListNode?, node2: ListNode?): ListNode? {
        if (node1 == null) return null
        if (node2 == null) return node1

        val nextPair = node2.next // 3
        node2.next = node1 // 1
        node1.next = swap(nextPair, nextPair?.next)
        return node2 // 2
    }

    fun swapPairs(head: ListNode?): ListNode? {
        return swap(head, head?.next)
    }


    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null || k == 1) {
            return head
        }
        val dummy = ListNode(0)
        dummy.next = head
        var cur: ListNode? = dummy
        var next: ListNode? = dummy
        var pre: ListNode? = dummy
        // Now find count of the linked list
        var count = 0
        while (cur!!.next != null) {
            cur = cur.next
            count++
        }
        while (count >= k) {
            cur = pre!!.next // Point to first node
            next = cur!!.next // point to second node
            // k-1 Operation to reverse k list
            for (i in 1 until k) {
                cur.next = next!!.next
                next.next = pre.next
                pre.next = next
                next = cur.next
            }

            pre = cur
            count -= k
        }
        return dummy.next
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

    fun reverseLinkedList(head: ListNode?): ListNode? {
        return reverseLinkedListHelp(head, head)
    }

    private fun reverseLinkedListHelp(head: ListNode?, newHead: ListNode?): ListNode? {
        if (head == null) return newHead
        val tempLinkedListOld = head.next
        head.next = newHead
        return reverseLinkedListHelp(tempLinkedListOld, head)
    }

    fun findTheWinner(n: Int, k: Int): Int {
        var answer = 0
        for (i in 1..n)
            answer = (answer + k) % i
        return answer + 1
    }


    fun interSectionLinkedList(headA: ListNode?, headB: ListNode?): ListNode? {
        var a = headA
        var b = headB
        while (a != b) {
            a = if (a == null) headB else a.next
            b = if (b == null) headA else b.next
        }
        return a
    }




}

fun printLinkedList(linkedList: ListNode?) {
    println()
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
    l1.next?.next?.next = ListNode(5)
    l1.next?.next?.next?.next = ListNode(5)
    l1.next?.next?.next?.next?.next = ListNode(9)
    l1.next?.next?.next?.next?.next?.next = ListNode(7)
    l1.next?.next?.next?.next?.next?.next?.next = ListNode(7)
    l1.next?.next?.next?.next?.next?.next?.next?.next = ListNode(7)
    l1.next?.next?.next?.next?.next?.next?.next?.next?.next = ListNode(7)

    val l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next?.next = ListNode(4)

    val linkedListResult = Day9().deleteDuplicates(l1)
    printLinkedList(linkedListResult)
}
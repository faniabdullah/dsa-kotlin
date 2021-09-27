package leetcode_badge.algorithm

import data_structure.linkedlist.SinglyLinkedList.Node


class Day5 {
    fun middleNode(head: Node?): Node? {
        var current = head
        var size = 1
        while (current?.next != null) {
            size++
            current = current.next
        }

        if (size % 2 == 0) {
            size += 1
        }
        size /= 2

        current = head
        for (i in 1..size) {
            current = current?.next
        }

        return current
    }

    fun removeNthFromEnd(head: Node?, n: Int): Node? {
        var result = head
        var tempResult = result
        var current = head
        var size = 1
        while (current?.next != null) {
            size++
            current = current.next
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
package data_structure.queue


class QueuesUsingLinkedList {
    inner class Node(var value: String?) {
        var next: Node? = null
    }

    var first: Node? = null
    var last: Node? = null
    var length = 0


    fun enqueue(value: String?) {
        val newNode: Node? = Node(value)
        if (length == 0) {
            first = newNode
        } else {
            last?.next = newNode
        }
        last = newNode
        length++
    }

    fun dequeue() {
        if (length > 0) {
            first = first?.next
            if (length == 1) {
                last = null
            }
            length--
        }
    }

    fun isEmpty() = length == 0

    fun peek(): String? {
        return if (length > 0) {
            first?.value
        } else {
            null
        }
    }

}


fun main() {
    val myQueue = QueuesUsingLinkedList()
    println("is Empty : " + myQueue.isEmpty())
    println("peek : " + myQueue.peek())
    myQueue.enqueue("Apple")
    myQueue.enqueue("Ball")
    myQueue.enqueue("Cat")
    println("peek :" + myQueue.peek())
    myQueue.dequeue()
    println("peek :" + myQueue.peek())

}
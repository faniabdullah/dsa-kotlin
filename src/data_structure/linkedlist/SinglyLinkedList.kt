package data_structure.linkedlist

class SinglyLinkedList(firsValue: Int) {
    inner class Node(var nodeValue: Int) {
        var next: Node? = null
    }

    var head: Node? = Node(firsValue)
    var tail: Node? = head
    var length = 1


    fun append(value: Int) {
        val newNode: Node? = Node(value)
        tail?.next = newNode
        tail = newNode
        length++
    }

    fun prepend(value: Int) {
        val newNode: Node? = Node(value)
        newNode?.next = head
        head = newNode
        length++
    }

    fun getLinkedList(index: Int): Int {
        var current = head
        for (i in 1 until index) {
            current = current?.next
        }

        return current?.nodeValue as Int
    }


    fun printLinkedList(): IntArray {
        var current: Node? = head
        val list = IntArray(length)
        var i = 0
        while (current != null) {
            list[i] = current.nodeValue
            current = current.next
            i++
        }

        return list
    }


    fun remove(index: Int) {
        if (index < 0 || index > length) {
            throw IndexOutOfBoundsException("index out bound")
        } else if (index == 0) {
            head = head?.next
            length--
        } else {
            var currentNode = head
            var i = 0
            while (i < index - 2) {
                println(i)
                currentNode = currentNode?.next
                i++
            }

            currentNode?.next = currentNode?.next?.next

            length--

            if (index == length) {
                tail = currentNode
            }
        }
    }

    fun insert(index: Int, value: Int) {
        if (index < 0 || index > length) {
            println("Index out of bounds for length $length")
        } else if (index == 0) {
            prepend(value)
        } else if (index == length) {
            append(value)
        } else {
            var current: Node? = head
            for (i in 1 until index - 1) {
                current = current?.next
            }
            val newNode = Node(value)
            newNode.next = current?.next
            current?.next = newNode
            length++
        }
    }


    fun swapLinkedList() {
        val tempNext = head?.next
        head?.next = head?.next?.next
        val tempHead = head
        head = tempNext
        head?.next = tempHead
    }

}

fun main() {
    val myLinkedList = SinglyLinkedList(2)
    myLinkedList.append(10)
    myLinkedList.append(11)
    myLinkedList.prepend(1)
    myLinkedList.append(6)
    println("list " + myLinkedList.printLinkedList().contentToString())
    myLinkedList.append(10 * 2)
    myLinkedList.append(11 * 2)
    myLinkedList.append(6 * 2)

    println("list " + myLinkedList.printLinkedList().contentToString())
    myLinkedList.remove(4)

    println("length ${myLinkedList.length}")
    println("list " + myLinkedList.printLinkedList().contentToString())
    myLinkedList.insert(value = 33, index = 4)
    println("list " + myLinkedList.printLinkedList().contentToString())
    println(" get index : 4 =  ${myLinkedList.getLinkedList(4)}")

    myLinkedList.swapLinkedList()

    println("list after swaping" + myLinkedList.printLinkedList().contentToString())

}
































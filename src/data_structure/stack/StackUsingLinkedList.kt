package data_structure.stack

class StackUsingLinkedList() {
    inner class Node(var value: Int) {
        var next: Node? = null
    }

    var first: Node? = null
    var last: Node? = null
    var length = -1

    fun push(value: Int) {
        val newNode: Node? = Node(value)
        if (length == -1) {
            last = newNode
            first = newNode
        } else {
            last?.next = newNode
            last = newNode
        }
        length++
    }

    fun pop(): Int {

        var current = first
        if (length == -1) {
            println("stack is empty")
            return -1
        } else {
            var i = 0
            while (i != length - 1) {
                current = current?.next
                i++
            }

            last = current
            last?.next = current?.next?.next
        }
        length--

        return current?.value as Int
    }

    fun peek(): Int {
        if (length == -1) {
            println("stack is empty")
            return -1
        }
        return last?.value as Int
    }

    fun size(): Int {
        return length
    }

    fun getStack() {
        var current = first
        while (current != null) {
            print("${current?.value} ,  ")
            current = current?.next
        }
    }
}


fun main() {
    val myStack = StackUsingLinkedList()
    myStack.push(15)
    myStack.push(16)
    var peek = myStack.peek()
    println("pek :  $peek")
    myStack.push(17)
    myStack.push(18)

    println("size ${myStack.size()}")
    myStack.getStack()
    println()
    myStack.pop()

    println("size ${myStack.size()}")
    myStack.getStack()
    println()
    println("wait pop 10 data")

    for (i in 1..10) {
        myStack.push(18 + i)
    }
    println()
    myStack.getStack()
    println()
    myStack.pop()
    myStack.getStack()
    println()
    peek = myStack.peek()
    println("pek :  $peek")

}





















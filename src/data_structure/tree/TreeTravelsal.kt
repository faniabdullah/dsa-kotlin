package data_structure.tree

import java.util.*

class TreeTravelsal {
    inner class Node(var value: Int) {
        var left: Node? = null
        var right: Node? = null
    }

    fun inOrder(tree: Node?) {
        if (tree == null) {
            return
        }
        inOrder(tree.left)
        print("" + tree.value + " ")
        inOrder(tree.right)
    }

    fun inOrderStack(tree: Node?) {
        val stack = Stack<Int>()
        var current = tree
        while (current != null) {
            current = current.left
            stack.add(current?.value)
        }
    }

    fun preOrder(tree: Node?) {
        if (tree == null) {
            return
        }
        print("" + tree.value + " ")
        preOrder(tree.left)
        preOrder(tree.right)
    }

    fun postOrder(tree: Node?) {
        if (tree == null) {
            return
        }
        postOrder(tree.left)
        postOrder(tree.right)

        print("" + tree.value + " ")
    }

}

fun main() {
    val tree = TreeTravelsal().Node(1)
    tree.left = TreeTravelsal().Node(2)
    tree.right = TreeTravelsal().Node(3)
    tree.left?.left = TreeTravelsal().Node(4)
    tree.left?.right = TreeTravelsal().Node(5)
    print("in order = ")
    TreeTravelsal().inOrder(tree)
    println()
    print("pre order = ")
    TreeTravelsal().preOrder(tree)
    println()

    print("post order = ")
    TreeTravelsal().postOrder(tree)
}
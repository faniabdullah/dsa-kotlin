package data_structure.tree

import java.util.*

class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class TreeTravelsal {
    fun printLevelOrder(tree: TreeNode?) {
        val queue: Queue<TreeNode?> = LinkedList()
        queue.add(tree)
        while (!queue.isEmpty()) {

            val tempNode = queue.poll()
            print(tempNode?.value.toString() + " ")

            if (tempNode!!.left != null) {
                queue.add(tempNode.left)
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right)
            }
        }
    }

    fun inOrder(tree: TreeNode?) {
        if (tree == null) {
            return
        }
        inOrder(tree.left)
        print("" + tree.value + " ")
        inOrder(tree.right)
    }

    fun inOrderStack(tree: TreeNode?) {
        val stack = Stack<Int>()
        var current = tree
        while (current != null) {
            current = current.left
            stack.add(current?.value)
        }
    }

    fun preOrder(tree: TreeNode?) {
        if (tree == null) {
            return
        }
        print("" + tree.value + " ")
        preOrder(tree.left)
        preOrder(tree.right)
    }

    fun postOrder(tree: TreeNode?) {
        if (tree == null) {
            return
        }
        postOrder(tree.left)
        postOrder(tree.right)

        print("" + tree.value + " ")
    }

}

fun main() {
    val tree = TreeNode(1)
    tree.left = TreeNode(2)
    tree.right = TreeNode(3)
    tree.left?.left = TreeNode(4)
    tree.left?.right = TreeNode(5)
    print("in order = ")
    TreeTravelsal().inOrder(tree)
    println()
    print("pre order = ")
    TreeTravelsal().preOrder(tree)
    println()

    print("post order = ")
    TreeTravelsal().postOrder(tree)
}
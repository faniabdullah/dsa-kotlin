package data_structure.tree

import java.util.*

class TreeNodeInt(key: Int?) {
    var treeValue: Int? = key
    var right: TreeNodeInt? = null
    var left: TreeNodeInt? = null
}

class TreeHelperInt() {
    var root: TreeNodeInt? = null
    var temp: TreeNodeInt? = null

    fun inOrderPrint(node: TreeNodeInt?) {
        if (node == null) {
            return
        }
        inOrderPrint(node.left)
        print("${node.treeValue}  ")
        inOrderPrint(node.right)
    }

    fun insertTree(tempp: TreeNodeInt?, key: Int) {
        if (tempp == null) {
            root = TreeNodeInt(key)
            return
        }
        val q: Queue<TreeNodeInt> = LinkedList<TreeNodeInt>()
        q.add(tempp)
        while (!q.isEmpty()) {
            temp = q.peek()
            q.remove()
            if (temp?.left == null) {
                temp?.left = TreeNodeInt(key)
                break
            } else q.add(temp?.left)
            if (temp?.right == null) {
                temp?.right = TreeNodeInt(key)
                break
            } else q.add(temp?.right)
        }
    }

    fun deleteTree(tempDelete: TreeNodeInt?, key: Int) {
        if (tempDelete == null) {
            root = TreeNodeInt(key)
            return
        }
        val q: Queue<TreeNodeInt> = LinkedList<TreeNodeInt>()
        q.add(tempDelete)
        while (!q.isEmpty()) {
            temp = q.peek()
            q.remove()
            if (temp?.treeValue == key) {
                temp?.treeValue = -1
                temp?.left = null
                temp?.right = null
                break
            } else {
                q.add(temp?.left)
                q.add(temp?.right)
            }

        }

    }

}

fun main() {
    val myClass = TreeHelperInt()
    val root: TreeNodeInt?
    root = TreeNodeInt(10);
    root.left = TreeNodeInt(11);
    root.left?.left = TreeNodeInt(7);
    root.right = TreeNodeInt(9);
    root.right?.left = TreeNodeInt(15);
    root.right?.right = TreeNodeInt(18);
    myClass.root = root

    println("before")
    myClass.inOrderPrint(root)
    println()
    println("after insert")
    myClass.insertTree(root, 12)
    myClass.inOrderPrint(root)

    println("after Delete")
    myClass.deleteTree(root, 10)
    myClass.inOrderPrint(root)

}
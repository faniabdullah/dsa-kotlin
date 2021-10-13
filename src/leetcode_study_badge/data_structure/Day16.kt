package leetcode_study_badge.data_structure

import data_structure.tree.TreeNode

class Day16 {
    private lateinit var paths: MutableList<List<Int>>

    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        paths = mutableListOf()
        root?.traverse(sum, listOf())

        return paths.toList()
    }

    private fun TreeNode.traverse(sum: Int, path: List<Int>) {
        if (this.left == null && this.right == null && sum - this.value == 0) {
            paths.add(path.insert(this.value))
        }

        if (this.left != null) {
            this.left?.traverse(sum - this.value, path.insert(this.value))
        }

        if (this.right != null) {
            this.right?.traverse(sum - this.value, path.insert(this.value))
        }
    }

    private fun List<Int>.insert(n: Int): List<Int> {
        val list = this.toMutableList()
        list.add(n)
        return list
    }

    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return root
        if (key < root.value) {
            root.left = deleteNode(root.left, key)
        } else if (key > root.value) {
            root.right = deleteNode(root.right, key)
        } else {

            if (root.left == null && root.right == null) {
                return null
            } else if (root.left != null && root.right != null) {
                val successor = minimumNode(root.right!!)
                root.right = deleteNode(root.right, successor)
                root.value = successor
            } else {
                return root.left ?: root.right
            }
        }
        return root
    }

    private fun minimumNode(root: TreeNode): Int {
        var node = root
        while (node.left != null) {
            node = node.left!!
        }
        return node.value
    }
}